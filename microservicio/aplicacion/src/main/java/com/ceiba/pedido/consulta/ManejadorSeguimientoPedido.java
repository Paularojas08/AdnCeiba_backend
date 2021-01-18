package com.ceiba.pedido.consulta;

import com.ceiba.pedido.modelo.dto.DtoDetallePedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.puerto.dao.DaoDetallePedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ManejadorSeguimientoPedido{

    private DaoDetallePedido daoDetallePedido;
    private DaoPedido daoPedido;

    public ManejadorSeguimientoPedido(DaoDetallePedido daoDetallePedido, DaoPedido daoPedido) {
        this.daoDetallePedido = daoDetallePedido;
        this.daoPedido=daoPedido;
    }

    public DtoPedido ejecutar(String identificadorSeguimiento){
        DtoPedido dtoPedido= daoPedido.obtenerPedidoPorIdSeguimiento(identificadorSeguimiento);
        List<DtoDetallePedido> detallePedido=daoDetallePedido.listar(dtoPedido.getId());
        dtoPedido.setDetallePedido(detallePedido);
        return dtoPedido;
    }

}
