package com.ceiba.pedido.consulta;

import com.ceiba.pedido.modelo.dto.DtoDetallePedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.puerto.dao.DaoDetallePedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ManejadorSeguimientoPedido{

    private DaoDetallePedido daoDetallePedido;
    private DaoPedido daoPedido;
    private DaoProducto daoProducto;

    public ManejadorSeguimientoPedido(DaoDetallePedido daoDetallePedido, DaoPedido daoPedido, DaoProducto daoProducto) {
        this.daoDetallePedido = daoDetallePedido;
        this.daoPedido=daoPedido;
        this.daoProducto = daoProducto;
    }

    public DtoPedido ejecutar(String identificadorSeguimiento){
        DtoPedido dtoPedido= daoPedido.obtenerPedidoPorIdSeguimiento(identificadorSeguimiento);
        List<DtoDetallePedido> detallePedido=daoDetallePedido.listar(dtoPedido.getId());
        detallePedido=detallePedido.stream().map(detalle->{
            detalle.setNombre(daoProducto.obtener(detalle.getIdProducto()).getNombre());
            return detalle;
        }).collect(Collectors.toList());
        dtoPedido.setDetallePedido(detallePedido);
        return dtoPedido;
    }

}
