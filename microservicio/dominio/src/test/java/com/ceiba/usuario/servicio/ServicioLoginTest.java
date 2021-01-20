package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioLoginTest {
    @Test
    public void loginTest(){
        DtoUsuario dtoUsuario=new DtoUsuario(1L,"1222","pepito","1234","admin@gmail.com");
        RepositorioUsuario repositorioUsuario= Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.login(Mockito.anyString(), Mockito.anyString())).thenReturn(dtoUsuario);

        ServicioLogin servicioLogin=new ServicioLogin(repositorioUsuario);
        Assert.assertEquals("admin@gmail.com",servicioLogin.ejecutar("admin@gmail.com","1234").getCorreo());

    }
}
