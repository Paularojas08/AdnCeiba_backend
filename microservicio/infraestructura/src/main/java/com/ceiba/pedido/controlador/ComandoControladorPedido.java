package com.ceiba.pedido.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.ComandoSolcitudPedido;
import com.ceiba.pedido.comando.manejador.ManejadorActualizarPedido;
import com.ceiba.pedido.comando.manejador.ManejadorCrearPedido;
import com.ceiba.pedido.comando.manejador.ManejadorEliminarPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pedido")
@Api(tags = { "Controlador comando pedidos"})
@CrossOrigin
public class ComandoControladorPedido {

    private final ManejadorCrearPedido manejadorCreaPedido;
    private final ManejadorActualizarPedido manejadorActualizarPedido;
    private final ManejadorEliminarPedido manejadorEliminarPedido;

    @Autowired
    public ComandoControladorPedido(ManejadorCrearPedido manejadorCreaPedido, ManejadorActualizarPedido manejadorActualizarPedido, ManejadorEliminarPedido manejadorEliminarPedido) {
        this.manejadorCreaPedido = manejadorCreaPedido;
        this.manejadorActualizarPedido = manejadorActualizarPedido;
        this.manejadorEliminarPedido = manejadorEliminarPedido;
    }

    @PostMapping
    @ApiOperation("Crear Pedido")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolcitudPedido comandoPedido) {
        return manejadorCreaPedido.ejecutar(comandoPedido);
    }


    @PutMapping
    @ApiOperation("Actualizar pedido")
    public void actualizarPedido(@RequestBody ComandoPedido comandoPedido) {
        this.manejadorActualizarPedido.ejecutar(comandoPedido);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar pedido")
    public void eliminarPedido(@PathVariable Long id) {
        this.manejadorEliminarPedido.ejecutar(id);
    }


}
