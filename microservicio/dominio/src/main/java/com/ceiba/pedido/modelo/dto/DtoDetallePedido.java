package com.ceiba.pedido.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoDetallePedido {
	
	private Long id;
	private Long pedidoId;
	private String productoId;
	private Long vendedorId;
	private int cantidadPedida;

}
