package com.ceiba.producto.controlador;

import com.ceiba.producto.consulta.ManejadorObtenerProducto;
import com.ceiba.producto.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
@Api(tags = { "Controlador comando productos"})
public class ComandoControladorProducto {

    private final ManejadorObtenerProducto manejadorObtenerProducto;

    @Autowired
    public ComandoControladorProducto(ManejadorObtenerProducto manejadorObtenerProducto){

        this.manejadorObtenerProducto = manejadorObtenerProducto;
    }

    @GetMapping(value = "/{codigo}")
    @ApiOperation("Obtener Producto Por codigo")
    public DtoProducto buscarProductoPorId(@PathVariable String codigo) {
        return this.manejadorObtenerProducto.ejecutar(codigo);
    }

}

