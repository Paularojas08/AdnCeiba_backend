package com.ceiba.producto.modelo.entidad;

import com.ceiba.util.Constantes;
import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class SolicitudPedidoProducto {
	private Long id;
	private String codigoProducto;
	private int cantidad;

	public SolicitudPedidoProducto(){}
	public SolicitudPedidoProducto(Long id, String codigoProducto, int cantidad) {
		validarObligatorio(codigoProducto, Constantes.VALIDACION_CAMPO_SOLICITUD_PRODUCTOS);
		validarObligatorio(cantidad,Constantes.VALIDACION_CAMPO_CANTIDAD_PRODUCTO);
		this.id=id;
		this.codigoProducto = codigoProducto;
		this.cantidad=cantidad;
	}
}
