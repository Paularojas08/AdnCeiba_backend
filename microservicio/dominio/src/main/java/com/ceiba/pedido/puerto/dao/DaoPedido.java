package com.ceiba.pedido.puerto.dao;

import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.usuario.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoPedido {
    Boolean obtenerPedidoPorDestinatario(String cedula);
    DtoPedido obtenerPedidoPorIdSeguimiento(String identificadorSeguimiento);
    List<DtoPedido> listarPedidos();
}
