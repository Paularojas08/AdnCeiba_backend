package com.ceiba.pedido.puerto.repositorio;

import java.util.List;

import com.ceiba.pedido.modelo.entidad.DetallePedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
 

public interface RepositorioDetallePedido {
	
	void crearDetallesPedido(List<DetallePedido> detallesPedido);
	
	Pedido obtenerPedido(String idPedido);
	
}
