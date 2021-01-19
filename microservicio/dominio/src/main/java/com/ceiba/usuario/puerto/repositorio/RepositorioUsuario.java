package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioUsuario {
        DtoUsuario login(String usuario, String contrasena);

}
