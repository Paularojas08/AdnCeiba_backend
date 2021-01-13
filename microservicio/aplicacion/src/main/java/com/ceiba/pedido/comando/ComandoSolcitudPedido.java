package com.ceiba.pedido.comando;

import java.util.List;

import com.ceiba.producto.modelo.entidad.SolicitudPedidoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolcitudPedido {

	private Long id;
	private long idMunicipio;
	private String cedula;
	private String nombreCompleto;
	private String direccion;
	private List<SolicitudPedidoProducto> solicitudPedidoProductos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<SolicitudPedidoProducto> getSolicitudPedidoProductos() {
		return solicitudPedidoProductos;
	}

	public void setSolicitudPedidoProductos(List<SolicitudPedidoProducto> solicitudPedidoProductos) {
		this.solicitudPedidoProductos = solicitudPedidoProductos;
	}

}
