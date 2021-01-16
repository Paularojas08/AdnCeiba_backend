package com.ceiba.pedido.puerto.dao;

import com.ceiba.pedido.modelo.dto.DtoDetallePedido;

import java.util.List;

public interface DaoDetallePedido {

    List<DtoDetallePedido> listar(Long idPedido);
}
