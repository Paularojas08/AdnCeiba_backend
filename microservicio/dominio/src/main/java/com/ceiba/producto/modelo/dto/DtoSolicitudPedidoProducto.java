package com.ceiba.producto.modelo.dto;

public class DtoSolicitudPedidoProducto {
	
	private String codigoProducto;
	private int cantidad;

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
