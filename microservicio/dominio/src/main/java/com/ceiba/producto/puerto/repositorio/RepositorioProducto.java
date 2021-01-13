package com.ceiba.producto.puerto.repositorio;

import java.util.List;

import com.ceiba.producto.modelo.entidad.Producto;


public interface RepositorioProducto {

	Producto obtener(String codigo);
	
	Double obtenerPrecioTotalProductos(List<String> identificadoresProductos);
}
