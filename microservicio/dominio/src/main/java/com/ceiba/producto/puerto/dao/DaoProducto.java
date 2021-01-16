package com.ceiba.producto.puerto.dao;

import com.ceiba.pedido.modelo.dto.DtoDetallePedido;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.modelo.entidad.Producto;

import java.util.List;

public interface DaoProducto {
    DtoProducto obtener(String codigo);
}
