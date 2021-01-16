package com.ceiba.pedido.servicio;

import com.ceiba.pedido.modelo.dto.DtoDetallePedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.modelo.entidad.DetallePedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoDetallePedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.producto.modelo.entidad.SolicitudPedidoProducto;
import com.ceiba.util.EstadoPedido;
import com.ceiba.util.UUIDUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ServicioSeguimientoPedido {

    private DaoDetallePedido daoDetallePedido;
    private DaoPedido daoPedido;

    public ServicioSeguimientoPedido(DaoDetallePedido daoDetallePedido,DaoPedido daoPedido) {
        this.daoDetallePedido = daoDetallePedido;
        this.daoPedido=daoPedido;
    }

    public Pedido ejecutar(String identificadorSeguimiento){
       DtoPedido dtoPedido= daoPedido.obtenerPedidoPorIdSeguimiento(identificadorSeguimiento);
       List<DtoDetallePedido> detallePedido=daoDetallePedido.listar(dtoPedido.getId());

       Pedido pedido= new Pedido(dtoPedido.getId(),dtoPedido.getIdentificadorSeguimiento(),dtoPedido.getFechaPedido(), dtoPedido.getFechaEnvio(), dtoPedido.getPrecioTotal(), null, dtoPedido.getEstado(),dtoPedido.getIdMunicipio(),dtoPedido.getCedula(),dtoPedido.getDireccion(),dtoPedido.getIdUsuario());
       List<DetallePedido>  listaDetalle=convertirDetallesPedido(pedido.getId(), detallePedido);

       pedido.setDetallePedido(listaDetalle);
       return pedido;
    }

    private List<DetallePedido> convertirDetallesPedido(Long pedidoId, List<DtoDetallePedido> detallePedido) {
        return detallePedido.stream().map(dtoDetallePedido -> {
            return new DetallePedido(dtoDetallePedido.getId(),pedidoId,dtoDetallePedido.getIdProducto(),dtoDetallePedido.getCantidadPedida());
        }).collect(Collectors.toList());
    }
}
