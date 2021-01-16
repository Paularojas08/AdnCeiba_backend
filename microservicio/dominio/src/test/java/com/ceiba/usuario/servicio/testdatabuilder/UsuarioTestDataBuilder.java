package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class UsuarioTestDataBuilder {

    private Long id;
    private String cedula;
    private String nombre;
    private String clave;
    private String correo;

    public UsuarioTestDataBuilder() {
        cedula="1097857234";
        nombre = "admin";
        clave = "1234";
        correo="admin@gmail.com";
    }

    public UsuarioTestDataBuilder conClave(String clave) {
        this.clave = clave;
        return this;
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Usuario build() {
        return new Usuario(id,cedula,nombre, clave,correo);
    }
}
