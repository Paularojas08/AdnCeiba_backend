package com.ceiba.producto.controlador;

import com.ceiba.municipio.modelo.dto.DtoMunicipio;
import com.ceiba.producto.consulta.ManejadorListarProductos;
import com.ceiba.producto.consulta.ManejadorObtenerProducto;
import com.ceiba.producto.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@Api(tags={"Controlador consulta producto"})
@CrossOrigin
public class ConsultaControladorProducto {
    private final ManejadorObtenerProducto manejadorObtenerProducto;
    private final ManejadorListarProductos manejadorListarProductos;

    public ConsultaControladorProducto(ManejadorObtenerProducto manejadorObtenerProducto, ManejadorListarProductos manejadorListarProductos) {
        this.manejadorObtenerProducto = manejadorObtenerProducto;
        this.manejadorListarProductos = manejadorListarProductos;
    }
    @GetMapping(value = "/{codigo}")
    @ApiOperation("Obtener Producto Por codigo")
    public DtoProducto buscarProductoPorId(@PathVariable String codigo) {
        return this.manejadorObtenerProducto.ejecutar(codigo);
    }
    @GetMapping
    @ApiOperation("Listar productos")
    public List<DtoProducto> listar() {
        return this.manejadorListarProductos.ejecutar();
    }
}
