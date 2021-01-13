package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoUsuario {
    public DtoUsuario(Long id2, String nombre2, String clave2, LocalDateTime fecha) {
		// TODO Auto-generated constructor stub
	}
	private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fechaCreacion;

}
