package com.ceiba.pedido.modelo;

import com.ceiba.pedido.modelo.dto.DtoDetallePedido;
import com.ceiba.pedido.modelo.entidad.DetallePedido;
import org.junit.Assert;
import org.junit.Test;

public class DetallePedidoTest {

    @Test
    public void validacionConstructorTest(){
        DetallePedido detallePedido=new DetallePedido(1L,1L,"56",10);
        Assert.assertEquals(detallePedido.getCantidadPedida(),10);
    }
}
