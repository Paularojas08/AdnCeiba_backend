package com.ceiba.municipio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoMunicipio {
    private Long id;
    private String nombre;
    private Long codigoMunicipio;
}
