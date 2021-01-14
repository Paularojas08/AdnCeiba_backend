package com.ceiba.pedido.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedido {
	
	private Long id;
	private Long pedidoId;
	private String productoId;
	private Long vendedorId;
	private int cantidadPedida;
	

}
