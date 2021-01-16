package com.ceiba.pedido.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoDetallePedido {

	private Long id;
	private Long idPedido;
	private String idProducto;
	private int cantidadPedida;

}
