package com.ceiba.pedido.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedido.modelo.entidad.DetallePedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioDetallePedido;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioDetallePedidoMysql implements RepositorioDetallePedido {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="pedido", value="crearDetalle")
    private static String sqlCrear;

    public RepositorioDetallePedidoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public void crearDetallesPedido(List<DetallePedido> detallesPedido) {
        for (DetallePedido detallePedido : detallesPedido) {
           this.customNamedParameterJdbcTemplate.crear(detallePedido, sqlCrear);
        }
    }

}
