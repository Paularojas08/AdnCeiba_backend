package com.ceiba.municipio.modelo.entidad;

import com.ceiba.util.Constantes;
import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Municipio {
	private Long id;
	private String nombre;
	private Long codigoMunicipio;

	public Municipio(Long id, String nombre, Long codigoMunicipio) {
		validarObligatorio(nombre,Constantes.VALIDACION_CAMPO_NOMBRE);
		validarObligatorio(codigoMunicipio, Constantes.SE_DEBE_INGRESAR_CODIGO_MUNICIPIO);
		this.id = id;
		this.nombre = nombre;
		this.codigoMunicipio = codigoMunicipio;
	}



}
