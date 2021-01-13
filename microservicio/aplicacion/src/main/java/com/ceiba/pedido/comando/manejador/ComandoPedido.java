package com.ceiba.pedido.comando.manejador;

import java.time.LocalDate;
import java.util.List;

import com.ceiba.pedido.modelo.entidad.DetallePedido;
import com.ceiba.pedido.servicio.util.EstadoPedido;

public class ComandoPedido {

	private Long id;
	private String identificadorSeguimiento;
	private LocalDate fechaPedido;
	private LocalDate fechaEnvio;
	private Double precioTotal;
	private List<DetallePedido> detallePedido;
	private EstadoPedido estado;

	
	public String getIdentificadorSeguimiento() {
		return identificadorSeguimiento;
	}

	public void setIdentificadorSeguimiento(String identificadorSeguimiento) {
		this.identificadorSeguimiento = identificadorSeguimiento;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public LocalDate getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(LocalDate fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public List<DetallePedido> getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(List<DetallePedido> detallePedido) {
		this.detallePedido = detallePedido;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
