package com.ceiba.pedido.servicio;

import com.ceiba.pedido.comando.ComandoSolcitudPedido;
import com.ceiba.producto.modelo.entidad.SolicitudPedidoProducto;

import java.util.Arrays;
import java.util.List;

public class ComandoSolicitudPedidoTestDataBuilder {

    private static final String CEDULA = "109495684";
    private static final String NOMBRE_COMPLETO = "Juanito Perez";
    private static final String DIRECCION = "Carrera 12 #13-12";
    private static final Long ID_MUNICIPIO = 8L;
    private static final String CODIGO_PRODUCTO_1 = "354";
    private static final int CANTIDAD_1 = 2;
    private static final String CODIGO_PRODUCTO_2 = "56";
    private static final int CANTIDAD_2 = 1;
    private static final Long USUARIO=1L;
    private String cedula;
    private String nombreCompleto;
    private String direccion;
    private Long idMunicipio;
    private List<SolicitudPedidoProducto> listaSolicitudPedidoProductos;
    private Long idUsuario;

    public ComandoSolicitudPedidoTestDataBuilder() {
        this.cedula = CEDULA;
        this.nombreCompleto = NOMBRE_COMPLETO;
        this.direccion = DIRECCION;
        this.idMunicipio = ID_MUNICIPIO;
        this.listaSolicitudPedidoProductos = Arrays.asList(construirObjeto(CODIGO_PRODUCTO_1, CANTIDAD_1),
                construirObjeto(CODIGO_PRODUCTO_2, CANTIDAD_2));
        this.idUsuario=USUARIO;
    }

    private SolicitudPedidoProducto construirObjeto(String codigo, int cantidad) {
        return new SolicitudPedidoProducto(null,codigo,cantidad);
    }

    public ComandoSolcitudPedido build() {
        ComandoSolcitudPedido comandoSolcitudPedido=new ComandoSolcitudPedido();
        comandoSolcitudPedido.setCedula(this.cedula);
        comandoSolcitudPedido.setDireccion(this.direccion);
        comandoSolcitudPedido.setSolicitudPedidoProductos(this.listaSolicitudPedidoProductos);
        comandoSolcitudPedido.setIdMunicipio(this.idMunicipio);
        comandoSolcitudPedido.setNombreCompleto(this.nombreCompleto);
        comandoSolcitudPedido.setIdUsuario(this.idUsuario);
        return comandoSolcitudPedido;
    }
}
