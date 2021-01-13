package com.ceiba.pedido.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;

@Component
public class FabricaPedido {

    public Pedido crear(ComandoPedido comandoPedido) {
        return new Pedido();
    }

}
