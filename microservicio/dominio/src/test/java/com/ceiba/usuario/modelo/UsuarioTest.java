package com.ceiba.usuario.modelo;

import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;

public class UsuarioTest {
    @Test
    public void validacionConstructorTest(){
        Usuario usuario=new UsuarioTestDataBuilder().build();
        Assert.assertEquals("1097857234",usuario.getCedula());
    }
}
