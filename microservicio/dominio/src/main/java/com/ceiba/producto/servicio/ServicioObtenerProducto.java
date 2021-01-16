package com.ceiba.producto.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import com.ceiba.util.Constantes;

public class ServicioObtenerProducto {

    private final DaoProducto daoProducto;

    public ServicioObtenerProducto(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }


    public Producto ejecutar(String codigo){
       DtoProducto dtoProducto=this.daoProducto.obtener(codigo);
       return new Producto(dtoProducto.getId(),dtoProducto.getCodigo(),dtoProducto.getNombre(), dtoProducto.getPrecio());
    }

}
