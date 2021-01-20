package com.ceiba.pedido.servicio.testdatabuilder;


import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.modelo.entidad.SolicitudPedido;
import com.ceiba.producto.modelo.entidad.SolicitudPedidoProducto;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.util.Constantes;
import com.ceiba.util.EstadoPedido;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class PedidoTestDataBuilder {
	private static final String CEDULA = "1094956843";
	private static final String DIRECCION = "Carrera 12 #13-12";
	private static final Long ID_MUNICIPIO = 8l;
	private static final Long USUARIO = 2l;
	private static final Long ID = 1l;
	private static final String FECHA = "2021-01-12";
	private static final String ESTADO = "PENDIENTE";
	private static final double PRECIO = 90000;
	private static final String IDENTIFICADOR="oljaa65s";

	private Long id;
	private String cedula;
	private String direccion;
	private Long idMunicipio;
	private Long idUsuario;
	private LocalDate fechaPedido;
	private EstadoPedido estado;
    private Double precioTotal;
    private String identificadorSeguimiento;



	public PedidoTestDataBuilder() {
		this.id=ID;
     this.cedula=CEDULA;
     this.direccion=DIRECCION;
     this.idMunicipio=ID_MUNICIPIO;
     this.idUsuario= USUARIO;
     this.fechaPedido=LocalDate.parse(FECHA);
     this.estado=EstadoPedido.valueOf(ESTADO);
     this.precioTotal=PRECIO;
     this.identificadorSeguimiento=IDENTIFICADOR;
	}
	public Pedido buildFallo() {
		return new Pedido(this.id,this.identificadorSeguimiento,this.fechaPedido,null,this.precioTotal,null,this.estado,this.idMunicipio,null,this.direccion,this.idUsuario);
	}
	public Pedido build() {
		return new Pedido(this.id,this.identificadorSeguimiento,this.fechaPedido,null,this.precioTotal,null,this.estado,this.idMunicipio,this.cedula,this.direccion,this.idUsuario);
	}
	

}
