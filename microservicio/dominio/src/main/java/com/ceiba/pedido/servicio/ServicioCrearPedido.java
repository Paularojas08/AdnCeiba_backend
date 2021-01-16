package com.ceiba.pedido.servicio;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.modelo.entidad.DetallePedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.modelo.entidad.SolicitudPedido;
import com.ceiba.pedido.puerto.api.ApiClienteEsFestivo;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioDetallePedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.util.Constantes;
import com.ceiba.util.EstadoPedido;
import com.ceiba.util.UUIDUtil;
import com.ceiba.producto.modelo.entidad.SolicitudPedidoProducto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.tarifa.puerto.dao.RepositorioTarifa;


public class ServicioCrearPedido {

	private final RepositorioPedido repositorioPedido;
	private final RepositorioProducto repositorioProducto;
	private final RepositorioTarifa repositorioTarifa;
	private final RepositorioDetallePedido repositorioDetallePedido;
    private final ApiClienteEsFestivo apiClienteEsFestivo;
    private final DaoPedido daoPedido;

	public ServicioCrearPedido(RepositorioPedido repositorioPedido, RepositorioProducto repositorioProducto,
			RepositorioTarifa repositorioTarifa,RepositorioDetallePedido repositorioDetallePedido,ApiClienteEsFestivo apiClienteEsFestivo,DaoPedido daoPedido) {
		this.repositorioPedido = repositorioPedido;
		this.repositorioProducto = repositorioProducto;
		this.repositorioTarifa = repositorioTarifa;
		this.repositorioDetallePedido=repositorioDetallePedido;
		this.apiClienteEsFestivo = apiClienteEsFestivo;
		this.daoPedido=daoPedido;
	}


	public Long ejecutar(SolicitudPedido solicitudPedido)  {
		validarExistencia(solicitudPedido.getCedula());
        Pedido pedido= crearPedidoInicial(solicitudPedido);
		pedido.validarSobreCosto();
		Long pedidoId= repositorioPedido.crear(pedido);
		crearDetallePedido(pedidoId,solicitudPedido);
		return pedidoId;
	}

	private void validarExistencia(String cedulaDestinatario){
		if(daoPedido.obtenerPedidoPorDestinatario(cedulaDestinatario)) {
			throw new ExcepcionDuplicidad(Constantes.YA_EXISTE_UN_PEDIDO_PENDIENTE_PARA_EL_DESTINATARIO_INGRESADO);
		}
	}
	private Pedido crearPedidoInicial(SolicitudPedido solicitudPedido) {
		double precioPedido = calcularPrecioPedido(solicitudPedido);
		LocalDate fechaPedido=LocalDate.now();
		LocalDate fechaEnvio= null;
		try {
			fechaEnvio = construirFechaEnvio(fechaPedido);
		} catch (IOException e) {
			throw new ExcepcionSinDatos(Constantes.EXCEPCION_VALIDACION_FESTIVO + e.getMessage());
		}

		return new Pedido(null, UUIDUtil.generarUUID(),fechaPedido, fechaEnvio, precioPedido, null, EstadoPedido.CREADO,solicitudPedido.getIdMunicipio(),solicitudPedido.getCedula(),solicitudPedido.getDireccion(),solicitudPedido.getIdUsuario());
		}

	private void crearDetallePedido(Long pedidoId,SolicitudPedido solicitudPedido){
		List<DetallePedido> detallePedidos = construirDetallesPedido(pedidoId, solicitudPedido.getSolicitudPedidoProductos());
		repositorioDetallePedido.crearDetallesPedido(detallePedidos);

	}
	private List<DetallePedido> construirDetallesPedido(Long pedidoId, List<SolicitudPedidoProducto> solicitudPedidoProductos) {
		return solicitudPedidoProductos.stream().map(solicitudProducto -> {
			return new DetallePedido(null,pedidoId,solicitudProducto.getCodigoProducto(),solicitudProducto.getCantidad());
		}).collect(Collectors.toList());
	}
	
	private double calcularPrecioPedido(SolicitudPedido solicitudPedido) {
		List<String> identificadoresProductos = solicitudPedido.getSolicitudPedidoProductos().stream()
				.map(SolicitudPedidoProducto::getCodigoProducto).collect(Collectors.toList());
		Double precioPedido = repositorioProducto.obtenerPrecioTotalProductos(identificadoresProductos);
		Double tarifaMunicipio = repositorioTarifa.obtenerTarifaPorMunicipio(solicitudPedido.getIdMunicipio());
		return precioPedido + tarifaMunicipio;
	}

	private LocalDate construirFechaEnvio(LocalDate fechaPedido) throws IOException {
		DayOfWeek dia=fechaPedido.getDayOfWeek();
		int hora=fechaPedido.atStartOfDay().getHour();

		while (dia.equals(DayOfWeek.SUNDAY) ||
				(dia.equals(DayOfWeek.SATURDAY) && hora<= Constantes.HORA_DESPACHO )
				|| apiClienteEsFestivo.validarFestivo(fechaPedido)){

			fechaPedido = fechaPedido.plusDays(Constantes.PLUS_DAYS);
		}
		return fechaPedido;
	}

}
