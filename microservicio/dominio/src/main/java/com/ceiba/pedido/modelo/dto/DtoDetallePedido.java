package com.ceiba.pedido.modelo.dto;

public class DtoDetallePedido {
	
	private Long id;
	private Long pedidoId;
	private String productoId;
	private Long vendedorId;
	private int cantidadPedida;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}
	public String getProductoId() {
		return productoId;
	}
	public void setProductoId(String productoId) {
		this.productoId = productoId;
	}
	public Long getVendedorId() {
		return vendedorId;
	}
	public void setVendedorId(Long vendedorId) {
		this.vendedorId = vendedorId;
	}
	public int getCantidadPedida() {
		return cantidadPedida;
	}
	public void setCantidadPedida(int cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}
}
