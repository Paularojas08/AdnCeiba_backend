package com.ceiba.pedido.consulta;

import com.ceiba.pedido.modelo.dto.DtoDetallePedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.puerto.dao.DaoDetallePedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ManejadorListarPedidos {
    private final DaoPedido daoPedido;
    private final DaoDetallePedido daoDetallePedido;
    private final DaoProducto daoProducto;

    public ManejadorListarPedidos(DaoPedido daoPedido, DaoDetallePedido daoDetallePedido, DaoProducto daoProducto) {
        this.daoPedido = daoPedido;
        this.daoDetallePedido = daoDetallePedido;
        this.daoProducto = daoProducto;
    }
    public List<DtoPedido> ejecutar(){
        return daoPedido.listarPedidos();
    }
}
