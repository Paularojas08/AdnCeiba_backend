package com.ceiba.pedido.modelo;

import com.ceiba.pedido.modelo.dto.DtoSolicitudPedido;
import org.junit.Assert;
import org.junit.Test;

public class DtoSolicitudPedidoTest {
    @Test
    public void validacionConstruccionSolicitudTest(){
        DtoSolicitudPedido dtoSolicitudPedido=new DtoSolicitudPedido(1L,8L,"1234","PEPITO JUAREZ","CARRERA 12",null, 1L);
        Assert.assertEquals(8L,dtoSolicitudPedido.getIdMunicipio());
    }
}
