package com.ceiba.pedido.modelo.entidad;

import com.ceiba.util.Constantes;
import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class DetallePedido {
	
	private Long id;
	private Long idPedido;
	private String idProducto;
	private int cantidadPedida;

	public DetallePedido(Long id,Long idPedido,String idProducto,int cantidadPedida) {

		validarObligatorio(idProducto, Constantes.SE_DEBE_INGRESAR_CODIGO_PRODUCTO);
		validarObligatorio(idPedido, Constantes.SE_DEBE_INGRESAR_IDENTIICADOR_PEDIDO);
		validarObligatorio(cantidadPedida,Constantes.VALIDACION_CAMPO_CANTIDAD_PRODUCTO);
		this.id = id;
		this.idPedido=idPedido;
		this.idProducto=idProducto;
		this.cantidadPedida=cantidadPedida;
	}
}
