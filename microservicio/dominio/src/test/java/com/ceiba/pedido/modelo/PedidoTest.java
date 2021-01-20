package com.ceiba.pedido.modelo;

import com.ceiba.core.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;

public class PedidoTest {
    @Test
    public void validacionConstructorTest(){
        Pedido pedido= new PedidoTestDataBuilder().build();
        Assert.assertEquals("1094956843",pedido.getCedula());

    }
}
