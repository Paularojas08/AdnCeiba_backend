package com.ceiba.pedido;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.ComandoSolcitudPedido;
import com.ceiba.pedido.comando.manejador.ManejadorActualizarPedido;
import com.ceiba.pedido.comando.manejador.ManejadorCrearPedido;
import com.ceiba.pedido.comando.manejador.ManejadorEliminarPedido;
import com.ceiba.pedido.comando.manejador.ManejadorSeguimientoPedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pedido")
@Api(tags = { "Controlador comando pedidos"})
public class ComandoControladorPedido {

    private final ManejadorCrearPedido manejadorCreaPedido;
    private final ManejadorActualizarPedido manejadorActualizarPedido;
    private final ManejadorEliminarPedido manejadorEliminarPedido;
    private final ManejadorSeguimientoPedido manejadorSeguimientoPedido;

    @Autowired
    public ComandoControladorPedido(ManejadorCrearPedido manejadorCreaPedido, ManejadorActualizarPedido manejadorActualizarPedido, ManejadorEliminarPedido manejadorEliminarPedido, ManejadorSeguimientoPedido manejadorSeguimientoPedido) {
        this.manejadorCreaPedido = manejadorCreaPedido;
        this.manejadorActualizarPedido = manejadorActualizarPedido;
        this.manejadorEliminarPedido = manejadorEliminarPedido;
        this.manejadorSeguimientoPedido = manejadorSeguimientoPedido;
    }

    @PostMapping
    @ApiOperation("Crear Pedido")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolcitudPedido comandoPedido) {
        return manejadorCreaPedido.ejecutar(comandoPedido);
    }


    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar pedido")
    public void actualizarPedido(@PathVariable Long id, @RequestBody ComandoPedido comandoPedido) {
        comandoPedido.setId(id);
        this.manejadorActualizarPedido.ejecutar(comandoPedido);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar pedido")
    public void eliminarPedido(@PathVariable Long id) {
        this.manejadorEliminarPedido.ejecutar(id);
    }

    @GetMapping(value = "/{identificador}")
    @ApiOperation("Obtener Producto Por identificador seguimiento")
    public Pedido buscarPedidoPorIdentificador(@PathVariable String identificador) {
        return this.manejadorSeguimientoPedido.ejecutar(identificador);
    }
}
