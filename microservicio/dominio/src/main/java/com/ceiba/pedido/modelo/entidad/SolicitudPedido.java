package com.ceiba.pedido.modelo.entidad;

import java.util.List;

import com.ceiba.util.Constantes;
import com.ceiba.producto.modelo.entidad.SolicitudPedidoProducto;
import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarNoVacio;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class SolicitudPedido {
	private Long id;
	private long idMunicipio;
	private String cedula;
	private String nombreCompleto;
	private String direccion;
	private List<SolicitudPedidoProducto> solicitudPedidoProductos;
	private Long idUsuario;

	public SolicitudPedido(Long id,long idMunicipio,String cedula,String nombreCompleto,String direccion,List<SolicitudPedidoProducto> solicitudPedidoProductos,Long idUsuario) {
		validarObligatorio(idMunicipio, Constantes.VALIDACION_CAMPO_ID_MUNICIPIO);
		validarObligatorio(nombreCompleto,Constantes.VALIDACION_CAMPO_NOMBRE);
		validarObligatorio(direccion,Constantes.VALIDACION_CAMPO_DIRECCION);
		validarNoVacio(solicitudPedidoProductos,Constantes.VALIDACION_CAMPO_SOLICITUD_PRODUCTOS);
		validarObligatorio(cedula,Constantes.VALIDACION_CAMPO_CEDULA);
        this.id=id;
		this.idMunicipio=idMunicipio;
		this.cedula=cedula;
		this.nombreCompleto=nombreCompleto;
		this.direccion=direccion;
		this.solicitudPedidoProductos=solicitudPedidoProductos;
		this.idUsuario=idUsuario;
	}


}
