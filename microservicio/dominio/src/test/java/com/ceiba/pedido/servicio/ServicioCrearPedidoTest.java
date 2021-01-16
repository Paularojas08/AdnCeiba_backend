package com.ceiba.pedido.servicio;

import com.ceiba.core.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.puerto.api.ApiClienteEsFestivo;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioDetallePedido;
import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.pedido.modelo.entidad.SolicitudPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.testdatabuilder.SolicitudPedidoTestDataBuilder;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.tarifa.puerto.dao.RepositorioTarifa;

import org.junit.Assert;

public class ServicioCrearPedidoTest {
    @Test
    public void validarPedidoPendienteDestinatarioTest() {

        SolicitudPedido solicitud = new SolicitudPedidoTestDataBuilder().build();
        RepositorioPedido repositorioPedido=Mockito.mock(RepositorioPedido.class);
        RepositorioProducto repositorioProducto=Mockito.mock(RepositorioProducto.class);
        RepositorioTarifa repositorioTarifa=Mockito.mock(RepositorioTarifa.class);
        RepositorioDetallePedido repositorioDetallePedido=Mockito.mock(RepositorioDetallePedido.class);
        ApiClienteEsFestivo apiClienteEsFestivo=Mockito.mock(ApiClienteEsFestivo.class);
        DaoPedido daoPedido=Mockito.mock(DaoPedido.class);

        Mockito.when(daoPedido.obtenerPedidoPorDestinatario(Mockito.anyString())).thenReturn(true);

        ServicioCrearPedido servicioCrearPedido=new ServicioCrearPedido(repositorioPedido, repositorioProducto, repositorioTarifa,repositorioDetallePedido,apiClienteEsFestivo,daoPedido);

        BasePrueba.assertThrows(() -> servicioCrearPedido.ejecutar(solicitud), ExcepcionDuplicidad.class,"Ya existe un pedido pendiente para el destinatario ingresado");

    }
    @Test
    public void crearPedidoTest(){
        SolicitudPedido solicitud = new SolicitudPedidoTestDataBuilder().build();
        RepositorioPedido repositorioPedido=Mockito.mock(RepositorioPedido.class);
        RepositorioProducto repositorioProducto=Mockito.mock(RepositorioProducto.class);
        RepositorioTarifa repositorioTarifa=Mockito.mock(RepositorioTarifa.class);
        RepositorioDetallePedido repositorioDetallePedido=Mockito.mock(RepositorioDetallePedido.class);
        ApiClienteEsFestivo apiClienteEsFestivo=Mockito.mock(ApiClienteEsFestivo.class);
        DaoPedido daoPedido=Mockito.mock(DaoPedido.class);

        Mockito.when(daoPedido.obtenerPedidoPorDestinatario(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioProducto.obtenerPrecioTotalProductos(Mockito.anyListOf(String.class))).thenReturn((double) 625000);
        Mockito.when(repositorioTarifa.obtenerTarifaPorMunicipio(Mockito.anyLong())).thenReturn((double) 2000);

        ServicioCrearPedido servicioCrearPedido=new ServicioCrearPedido(repositorioPedido, repositorioProducto, repositorioTarifa,repositorioDetallePedido,apiClienteEsFestivo,daoPedido);

        long resultado=servicioCrearPedido.ejecutar(solicitud);
        Assert.assertEquals(0l, resultado);

    }
}
