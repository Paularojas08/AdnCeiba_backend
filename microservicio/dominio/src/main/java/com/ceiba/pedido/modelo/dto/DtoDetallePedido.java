package com.ceiba.pedido.modelo.dto;

import com.ceiba.producto.modelo.dto.DtoProducto;
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
	private String nombre;

}
