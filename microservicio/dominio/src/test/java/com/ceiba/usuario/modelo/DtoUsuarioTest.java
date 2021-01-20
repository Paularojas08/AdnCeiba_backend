package com.ceiba.usuario.modelo;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.junit.Assert;
import org.junit.Test;

public class DtoUsuarioTest {
    @Test
    public void validacionConstruccionDtoUsuarioTest(){
        DtoUsuario dtoUsuario=new DtoUsuario(1L,"1222","pepito","1234","admin@gmail.com");
        Assert.assertEquals(dtoUsuario.getCedula(),"1222");
    }
}
