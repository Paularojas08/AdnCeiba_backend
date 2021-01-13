package com.ceiba.pedido.servicio;


import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.pedido.modelo.entidad.SolicitudPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.tarifa.puerto.dao.RepositorioTarifa;

import org.junit.Assert;

public class ServicioCrearPedidoTest {
    @Test
    public void validarPrecioTest() {
        // arrange
        SolicitudPedido solicitud = new PedidoTestDataBuilder().build();
        
        
        RepositorioPedido repositorioPedido=Mockito.mock(RepositorioPedido.class);
        RepositorioProducto repositorioProducto=Mockito.mock(RepositorioProducto.class);
        RepositorioTarifa repositorioTarifa=Mockito.mock(RepositorioTarifa.class);
          
        Mockito.when(repositorioProducto.obtenerPrecioTotalProductos(Mockito.mock(null))).thenReturn((double) 142000);
        Mockito.when(repositorioTarifa.obtenerTarifaPorMunicipio(Mockito.anyLong())).thenReturn((double) 2000);
       
        ServicioCrearPedido servicioCrearPedido=new ServicioCrearPedido(repositorioPedido, repositorioProducto, repositorioTarifa);
        
        // act - assert
        Assert.assertEquals(servicioCrearPedido.calcularPrecioPedido(solicitud.getSolicitudPedidoProductos(), 1L), (double) 144000);
    }
}
