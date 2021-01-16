package com.ceiba.pedido.puerto.repositorio;

import java.util.List;

import com.ceiba.pedido.modelo.entidad.DetallePedido;


public interface RepositorioDetallePedido {
	
	void crearDetallesPedido(List<DetallePedido> detallesPedido);

}
