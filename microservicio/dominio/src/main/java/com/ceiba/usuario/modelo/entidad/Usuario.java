package com.ceiba.usuario.modelo.entidad;


import com.ceiba.util.Constantes;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Usuario {

    private Long id;
    private String cedula;
    private String nombre;
    private String clave;
    private String correo;

    public Usuario(Long id,String cedula,String nombre, String clave,String correo) {
        validarObligatorio(correo, Constantes.VALIDACION_CAMPO_NOMBRE);
        validarObligatorio(clave, Constantes.SE_DEBE_INGRESAR_LA_CLAVE);
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.correo=correo;
    }

}
