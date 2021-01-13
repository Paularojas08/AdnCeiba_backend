package com.ceiba.pedido;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.ComandoSolcitudPedido;
import com.ceiba.pedido.comando.manejador.ManejadorCrearPedido;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorEliminarUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pedido")
@Api(tags = { "Controlador comando pedidos"})
public class ComandoControladorPedido {

    private final ManejadorCrearPedido manejadorCreaPedido;

    @Autowired
    public ComandoControladorPedido(ManejadorCrearPedido manejadorCreaPedido) {
        this.manejadorCreaPedido = manejadorCreaPedido;
    }

    @PostMapping
    @ApiOperation("Crear Pedido")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolcitudPedido comandoPedido) {
        return manejadorCreaPedido.ejecutar(comandoPedido);
    }
}
