package com.ceiba.pedido.modelo;

import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.util.EstadoPedido;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DtoPedidoTest {

    @Test
    public void validarCreacionPedidoTest(){
        DtoPedido dtoPedido=new DtoPedido(1L,"alos1233",LocalDate.now(),LocalDate.now(), 456789.0,null, EstadoPedido.CREADO,1L,"1094567","carrera 13",1L);
        Assert.assertEquals("alos1233",dtoPedido.getIdentificadorSeguimiento());
    }
}
