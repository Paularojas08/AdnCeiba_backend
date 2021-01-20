package com.ceiba.pedido.modelo;

import com.ceiba.pedido.modelo.entidad.SolicitudPedido;
import com.ceiba.pedido.servicio.testdatabuilder.SolicitudPedidoTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;

public class SolicitudPedidoTest {
    @Test
    public void validacionConstructor(){
        SolicitudPedido solicitudPedido=new SolicitudPedidoTestDataBuilder().build();
        Assert.assertEquals(8L,solicitudPedido.getIdMunicipio());
    }
}
