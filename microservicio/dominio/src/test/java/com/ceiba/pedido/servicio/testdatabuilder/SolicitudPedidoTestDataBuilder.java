package com.ceiba.pedido.servicio.testdatabuilder;


import java.util.Arrays;
import java.util.List;

import com.ceiba.pedido.modelo.entidad.SolicitudPedido;
import com.ceiba.producto.modelo.entidad.SolicitudPedidoProducto;


public class SolicitudPedidoTestDataBuilder {
	private static final String CEDULA = "1094956843";
	private static final String NOMBRE_COMPLETO = "Juanito Perez";
	private static final String DIRECCION = "Carrera 12 #13-12";
	private static final Long ID_MUNICIPIO = 8l;
	private static final String CODIGO_PRODUCTO_1 = "354";
	private static final int CANTIDAD_1 = 2;
	private static final String CODIGO_PRODUCTO_2 = "56";
	private static final int CANTIDAD_2 = 1;
	private static final Long USUARIO=1L;

	private String cedula;
	private String nombreCompleto;
	private String direccion;
	private Long idMunicipio;
	private List<SolicitudPedidoProducto> listaSolicitudPedidoProductos;
	private Long idUsuario;

	public SolicitudPedidoTestDataBuilder() {
		this.cedula = CEDULA;
		this.nombreCompleto = NOMBRE_COMPLETO;
		this.direccion = DIRECCION;
		this.idMunicipio = ID_MUNICIPIO;
		this.listaSolicitudPedidoProductos = Arrays.asList(construirObjeto(CODIGO_PRODUCTO_1, CANTIDAD_1),
				construirObjeto(CODIGO_PRODUCTO_2, CANTIDAD_2));
		this.idUsuario=USUARIO;

	}


	public SolicitudPedido build() {
		return new SolicitudPedido(null,this.idMunicipio,this.cedula,this.nombreCompleto,this.direccion,this.listaSolicitudPedidoProductos,this.idUsuario);
	}
	

	private SolicitudPedidoProducto construirObjeto(String codigo, int cantidad) {
		return new SolicitudPedidoProducto(null,codigo,cantidad);
	}

}
