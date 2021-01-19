package com.ceiba.usuario.servicio;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioLoguin {
    private RepositorioUsuario repositorioUsuario;

    public ServicioLoguin(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public DtoUsuario ejecutar(String usuario, String contrasena){
      return repositorioUsuario.loguin(usuario,contrasena);
    }
}
