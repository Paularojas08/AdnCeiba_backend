package com.ceiba.pedido.servicio;

import com.ceiba.core.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;
import com.ceiba.util.EstadoPedido;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ServicioActualizarPedidoTest {

    @Test
    public void actualizarPedidoTest(){
        Pedido pedido=new PedidoTestDataBuilder().build();
        RepositorioPedido repositorioPedido= Mockito.mock(RepositorioPedido.class);
        Mockito.when(repositorioPedido.obtenerPedidoPorId(Mockito.anyLong())).thenReturn(true);

        ServicioActualizarPedido servicioActualizarPedido=new ServicioActualizarPedido(repositorioPedido);

        servicioActualizarPedido.ejecutar(pedido);

        Assert.assertEquals(pedido.getEstado(), EstadoPedido.PENDIENTE);
    }
@Test
 public void validarExistenciaPedidoTest(){
    Pedido pedido=new PedidoTestDataBuilder().build();
    RepositorioPedido repositorioPedido= Mockito.mock(RepositorioPedido.class);
    Mockito.when(repositorioPedido.obtenerPedidoPorId(Mockito.anyLong())).thenReturn(false);

    ServicioActualizarPedido servicioActualizarPedido=new ServicioActualizarPedido(repositorioPedido);

    BasePrueba.assertThrows(() -> servicioActualizarPedido.ejecutar(pedido), ExcepcionDuplicidad.class,"El pedido no existe en el sistema");
}
}
