package com.ceiba.pedido.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pedido.modelo.dto.DtoDetallePedido;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoDetallePedido implements RowMapper<DtoDetallePedido>, MapperResult {

    @Override
    public DtoDetallePedido mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idPedido=resultSet.getLong("id_pedido");
        String idProducto = resultSet.getString("id_producto");
        Integer cantidad = resultSet.getInt("cantidadPedida");

        return new DtoDetallePedido(id,idPedido,idProducto,cantidad,null);
    }

}
