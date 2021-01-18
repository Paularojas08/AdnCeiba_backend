package com.ceiba.pedido.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.municipio.adaptador.dao.MapeoMunicipio;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPedidoMysql implements DaoPedido {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "pedido", value = "existePorDestinatario")
    private static String sqlExiste;


    @SqlStatement(namespace = "pedido", value = "buscarPedido")
    private static String sqlBuscarIdentificador;

    @SqlStatement(namespace="pedido", value="listar")
    private static String sqlListar;

    public DaoPedidoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Boolean obtenerPedidoPorDestinatario(String cedula) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("cedula", cedula);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public DtoPedido obtenerPedidoPorIdSeguimiento(String identificadorSeguimiento) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificadorSeguimiento", identificadorSeguimiento);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarIdentificador,
                paramSource, new MapeoPedido());

    }

    @Override
    public List<DtoPedido> listarPedidos() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPedido());
    }
}
