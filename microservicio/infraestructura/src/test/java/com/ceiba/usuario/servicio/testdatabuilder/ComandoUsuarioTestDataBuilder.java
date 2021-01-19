package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String cedula;
    private String nombre;
    private String clave;
    private String correo;

    public ComandoUsuarioTestDataBuilder() {
        id=1L;
        cedula="1234545";
        nombre="admin";
        correo ="admin@gmail.com";
        clave = "1234";
    }


    public ComandoUsuario build() {
        ComandoUsuario comandoUsuario=new ComandoUsuario();
        comandoUsuario.setId(this.id);
        comandoUsuario.setClave(this.clave);
        comandoUsuario.setCorreo(this.correo);
        comandoUsuario.setNombre(this.nombre);
        comandoUsuario.setCedula(this.cedula);
        return comandoUsuario;
    }
}
