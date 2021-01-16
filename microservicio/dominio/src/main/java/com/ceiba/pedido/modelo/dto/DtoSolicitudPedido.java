package com.ceiba.pedido.modelo.dto;

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
public class DtoSolicitudPedido {
	private Long id;
	private long idMunicipio;
	private String cedula;
	private String nombreCompleto;
	private String direccion;
	private List<SolicitudPedidoProducto> solicitudPedidoProductos;
	private Long idUsuario;
}
