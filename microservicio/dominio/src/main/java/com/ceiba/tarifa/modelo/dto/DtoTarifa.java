package com.ceiba.tarifa.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoTarifa {
	private Long id;
	private Long idMunicipio;
	private Double precio;

}
