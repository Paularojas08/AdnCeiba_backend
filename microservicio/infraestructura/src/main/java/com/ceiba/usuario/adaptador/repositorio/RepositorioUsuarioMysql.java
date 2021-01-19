package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.adaptador.dao.MapeoUsuario;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioMysql implements RepositorioUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;


    @SqlStatement(namespace="usuario", value="buscarUsuario")
    private static String sqlBuscarUsuario;

    public RepositorioUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public DtoUsuario login(String usuario, String contrasena) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("usuario", usuario);
        paramSource.addValue("clave", contrasena);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarUsuario,paramSource, new MapeoUsuario());
    }
}
