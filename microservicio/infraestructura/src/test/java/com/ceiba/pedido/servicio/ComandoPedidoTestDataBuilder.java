package com.ceiba.pedido.servicio;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.ComandoSolcitudPedido;
import com.ceiba.pedido.controlador.ComandoControladorPedidoTest;
import com.ceiba.pedido.modelo.entidad.SolicitudPedido;
import com.ceiba.producto.modelo.entidad.SolicitudPedidoProducto;

import java.util.Arrays;
import java.util.List;

public class ComandoPedidoTestDataBuilder {
    private static final String CEDULA = "1094956843";
    private static final String NOMBRE_COMPLETO = "Juanito Perez";
    private static final String DIRECCION = "Carrera 12 #13-12";
    private static final Long ID_MUNICIPIO = 8l;
    private static final String CODIGO_PRODUCTO_1 = "354";
    private static final int CANTIDAD_1 = 2;
    private static final String CODIGO_PRODUCTO_2 = "56";
    private static final int CANTIDAD_2 = 1;

    private String cedula;
    private String nombreCompleto;
    private String direccion;
    private Long idMunicipio;
    private List<SolicitudPedidoProducto> listaSolicitudPedidoProductos;

    public ComandoPedidoTestDataBuilder() {
        this.cedula = CEDULA;
        this.nombreCompleto = NOMBRE_COMPLETO;
        this.direccion = DIRECCION;
        this.idMunicipio = ID_MUNICIPIO;
        this.listaSolicitudPedidoProductos = Arrays.asList(construirObjeto(CODIGO_PRODUCTO_1, CANTIDAD_1),
                construirObjeto(CODIGO_PRODUCTO_2, CANTIDAD_2));

    }

    public ComandoPedidoTestDataBuilder conCedula() {
        this.cedula = CEDULA;
        return this;
    }

    public ComandoPedidoTestDataBuilder conNombreCompleto() {
        this.nombreCompleto = NOMBRE_COMPLETO;
        return this;
    }

    public ComandoPedidoTestDataBuilder conDireccion() {
        this.direccion = DIRECCION;
        return this;
    }

    public ComandoPedidoTestDataBuilder conIdMunicipio() {
        this.idMunicipio = ID_MUNICIPIO;
        return this;
    }

    public ComandoPedidoTestDataBuilder conListaSolicitudPedidoProductos() {
        this.listaSolicitudPedidoProductos = Arrays.asList(construirObjeto(CODIGO_PRODUCTO_1, CANTIDAD_1),
                construirObjeto(CODIGO_PRODUCTO_2, CANTIDAD_2));
        return this;
    }

    public ComandoSolcitudPedido build() {
        ComandoSolcitudPedido solicitudPedido=new ComandoSolcitudPedido();
        solicitudPedido.setCedula(this.cedula);
        solicitudPedido.setNombreCompleto(this.nombreCompleto);
        solicitudPedido.setDireccion(this.direccion);
        solicitudPedido.setIdMunicipio(this.idMunicipio);
        solicitudPedido.setSolicitudPedidoProductos(this.listaSolicitudPedidoProductos);
        return solicitudPedido;
    }

    private SolicitudPedidoProducto construirObjeto(String codigo, int cantidad) {
        SolicitudPedidoProducto solicitudPedidoProducto=new SolicitudPedidoProducto();
        solicitudPedidoProducto.setCantidad(cantidad);
        solicitudPedidoProducto.setCodigoProducto(codigo);
        return solicitudPedidoProducto;
    }

}
