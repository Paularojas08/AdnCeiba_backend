package com.ceiba.tarifa.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.util.Constantes;
import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Tarifa {
	private Long id;
	private Long idMunicipio;
	private Double precio;

	public Tarifa(Long id, Long idMunicipio, Double precio) {
		validarObligatorio(idMunicipio,Constantes.VALIDACION_CAMPO_ID_MUNICIPIO);
		validarObligatorio(precio, Constantes.SE_DEBE_INGRESAR_PRECIO);
		this.id = id;
		this.idMunicipio = idMunicipio;
		this.precio = precio;
	}



}
