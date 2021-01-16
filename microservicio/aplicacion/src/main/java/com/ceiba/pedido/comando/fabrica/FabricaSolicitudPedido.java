package com.ceiba.pedido.comando.fabrica;

import com.ceiba.pedido.comando.ComandoSolcitudPedido;
import com.ceiba.pedido.modelo.entidad.SolicitudPedido;
import org.springframework.stereotype.Component;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;

@Component
public class FabricaSolicitudPedido {

    public SolicitudPedido crear(ComandoSolcitudPedido comandoPedido) {
        return new SolicitudPedido(comandoPedido.getId(), comandoPedido.getIdMunicipio(), comandoPedido.getCedula(), comandoPedido.getNombreCompleto(), comandoPedido.getDireccion(), comandoPedido.getSolicitudPedidoProductos(),comandoPedido.getIdUsuario());

    }

}
