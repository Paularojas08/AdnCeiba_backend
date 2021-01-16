package com.ceiba.pedido.modelo.entidad;

import java.time.LocalDate;
import java.util.List;

import com.ceiba.util.Constantes;
import com.ceiba.util.EstadoPedido;
import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Pedido {
	private Long id;
	private String identificadorSeguimiento;
	private LocalDate fechaPedido;
	private LocalDate fechaEnvio;
	private Double precioTotal;
	private List<DetallePedido> detallePedido;
	private EstadoPedido estado;
	private Long idMunicipio;
	private String cedula;
	private String direccion;
	private Long  idUsuario;

		public Pedido(Long id,String identificadorSeguimiento,LocalDate fechaPedido,LocalDate fechaEnvio,Double precioTotal,List<DetallePedido> detallePedido,EstadoPedido estado,Long idMunicipio,String cedula,String direccion,Long idUsuario) {
		validarObligatorio(fechaPedido,Constantes.VALIDACION_CAMPO_FECHA_PEDIDO);
		validarObligatorio(estado,Constantes.VALIDACION_CAMPO_ESTADO);
		validarObligatorio(precioTotal,Constantes.VALIDACION_CAMPO_PRECIO);
        validarObligatorio(identificadorSeguimiento,Constantes.VALIDACION_CAMPO_IDENTIFICADOR_SEGUIMIENTO);
		validarObligatorio(cedula,Constantes.VALIDACION_CAMPO_CEDULA);
		validarObligatorio(idMunicipio,Constantes.VALIDACION_CAMPO_ID_MUNICIPIO);
		validarObligatorio(direccion,Constantes.VALIDACION_CAMPO_DIRECCION);
        this.id=id;
		this.identificadorSeguimiento=identificadorSeguimiento;
		this.fechaPedido=fechaPedido;
		this.fechaEnvio=fechaEnvio;
		this.precioTotal=precioTotal;
		this.detallePedido=detallePedido;
		this.estado=estado;
		this.idMunicipio=idMunicipio;
		this.cedula=cedula;
		this.direccion=direccion;
		this.idUsuario=idUsuario;
	}

	public void validarSobreCosto() {
       double precio=this.precioTotal;

		if (precio > Constantes.PRECIO_MINIMO && precio < Constantes.PRECIO_MAXIMO) {
			this.precioTotal=calcularSobreCosto(precio, Constantes.PORCENTAJE_MINIMO);
		}
		if (precio > Constantes.PRECIO_MAXIMO) {
			this.precioTotal=calcularSobreCosto(precio, Constantes.PORCENTAJE_MAXIMO);
		}
	}

	private Double calcularSobreCosto(Double precio, Double procentaje) {
		return precio + (precio * procentaje);
	}



}
