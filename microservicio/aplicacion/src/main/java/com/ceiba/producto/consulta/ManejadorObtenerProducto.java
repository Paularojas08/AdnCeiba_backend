package com.ceiba.producto.consulta;

import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerProducto {

    private final DaoProducto daoProducto;

    public ManejadorObtenerProducto(DaoProducto daoProducto){

        this.daoProducto = daoProducto;
    }

    public DtoProducto ejecutar(String codigo){
        return this.daoProducto.obtener(codigo);
    }
}
