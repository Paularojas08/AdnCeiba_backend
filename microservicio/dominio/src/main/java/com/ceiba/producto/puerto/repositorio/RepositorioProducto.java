package com.ceiba.producto.puerto.repositorio;

import java.util.List;

import com.ceiba.producto.modelo.entidad.Producto;


public interface RepositorioProducto {

	Double obtenerPrecioTotalProductos(List<String> identificadoresProductos);
}
