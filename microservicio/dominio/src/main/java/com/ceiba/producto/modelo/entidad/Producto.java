package com.ceiba.producto.modelo.entidad;

import com.ceiba.util.Constantes;
import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Producto {
	private Long id;
	private String codigo;
	private String nombre;
	private double precio;

	public Producto(Long id,String codigo,String nombre,Double precio) {
		validarObligatorio(codigo, Constantes.SE_DEBE_INGRESAR_CODIGO_PRODUCTO);
		validarObligatorio(nombre,Constantes.VALIDACION_CAMPO_NOMBRE);
		validarObligatorio(precio,Constantes.SE_DEBE_INGRESAR_PRECIO);
		this.id = id;
		this.codigo=codigo;
		this.nombre=nombre;
		this.precio=precio;
	}
}
