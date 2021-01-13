package com.ceiba.pedido.servicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.modelo.entidad.SolicitudPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.util.EstadoPedido;
import com.ceiba.pedido.servicio.util.UUIDUtil;
import com.ceiba.pedido.servicio.util.validation.ReglaValidarPrecioPedido;
import com.ceiba.pedido.servicio.util.validation.ReglasDeNegocio;
import com.ceiba.producto.modelo.entidad.SolicitudPedidoProducto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.tarifa.puerto.dao.RepositorioTarifa;


public class ServicioCrearPedido {

	private final RepositorioPedido repositorioPedido;
	private final RepositorioProducto repositorioProducto;
	private final RepositorioTarifa repositorioTarifa;

	private ArrayList<ReglasDeNegocio> reglasDeNegocios;

	private final PedidoBuilder pedidoBuilder = new PedidoBuilder();

	public ServicioCrearPedido(RepositorioPedido repositorioPedido, RepositorioProducto repositorioProducto,
			RepositorioTarifa repositorioTarifa) {
		this.repositorioPedido = repositorioPedido;
		this.repositorioProducto = repositorioProducto;
		this.repositorioTarifa = repositorioTarifa;
		reglasDeNegocios = new ArrayList<>();
	}


	public Long ejecutar(SolicitudPedido solicitudPedido) {
		double precioPedido = calcularPrecioPedido(solicitudPedido.getSolicitudPedidoProductos(),
				solicitudPedido.getIdMunicipio());
		Pedido pedido = contruirPedidoInicial(precioPedido);
		validar(pedido);
		return repositorioPedido.crear(pedido);
	}
	
	
	private double calcularPrecioPedido(List<SolicitudPedidoProducto> pedidoInicialProducto, Long idMunicipio) {
		List<String> identificadoresProductos = pedidoInicialProducto.stream()
				.map(SolicitudPedidoProducto::getCodigoProducto).collect(Collectors.toList());
		Double precioPedido = repositorioProducto.obtenerPrecioTotalProductos(identificadoresProductos);
		Double tarifaMunicipio = repositorioTarifa.obtenerTarifaPorMunicipio(idMunicipio);
		return precioPedido + tarifaMunicipio;
	}


	private Pedido contruirPedidoInicial(Double precioPedido) {
		return pedidoBuilder.build().conEstado(EstadoPedido.CREADO).conFechaPedido(LocalDate.now())
				.conPrecioTotal(precioPedido).conIdDeSeguimiento(UUIDUtil.generarUUID()).toPedido();	
	}
	
	private void validar(Pedido pedido) {
		reglasDeNegocios.add(new ReglaValidarPrecioPedido());
		for (ReglasDeNegocio reglasDeNegocio : reglasDeNegocios) {
			reglasDeNegocio.validar(pedido);
		}
	}

}
