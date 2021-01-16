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
        validarObligatorio(nombre, Constantes.SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(clave, Constantes.SE_DEBE_INGRESAR_LA_CLAVE);
        validarObligatorio(cedula,Constantes.VALIDACION_CAMPO_CEDULA);
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
    }

}
