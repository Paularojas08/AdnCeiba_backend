package com.ceiba.pedido.servicio;

import com.ceiba.core.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarPedidoTest {


    @Test
    public void validarExistenciaPedidoTest(){
        RepositorioPedido repositorioPedido= Mockito.mock(RepositorioPedido.class);
        Mockito.when(repositorioPedido.obtenerPedidoPorId(Mockito.anyLong())).thenReturn(false);

        ServicioEliminarPedido servicioEliminarPedido=new ServicioEliminarPedido(repositorioPedido);
        BasePrueba.assertThrows(() -> servicioEliminarPedido.ejecutar(1L), ExcepcionDuplicidad.class,"El pedido no existe en el sistema");
    }
}
