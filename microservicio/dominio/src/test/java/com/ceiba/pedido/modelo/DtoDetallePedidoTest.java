package com.ceiba.pedido.modelo;

import com.ceiba.pedido.modelo.dto.DtoDetallePedido;
import org.junit.Assert;
import org.junit.Test;

public class DtoDetallePedidoTest {
    @Test
    public void validacionCreacionDetalleTest(){
        DtoDetallePedido dtoDetallePedido=new DtoDetallePedido(1L,1L,"56",10,"CEPILLO");
        Assert.assertEquals(dtoDetallePedido.getCantidadPedida(),10);
    }
}
