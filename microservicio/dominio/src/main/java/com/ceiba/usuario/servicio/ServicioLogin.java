package com.ceiba.usuario.servicio;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioLogin {
    private RepositorioUsuario repositorioUsuario;

    public ServicioLogin(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public DtoUsuario ejecutar(String usuario, String contrasena){
      return repositorioUsuario.login(usuario,contrasena);
    }
}
