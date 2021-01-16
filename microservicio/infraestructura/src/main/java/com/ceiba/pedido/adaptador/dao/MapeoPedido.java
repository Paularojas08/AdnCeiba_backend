package com.ceiba.pedido.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pedido.modelo.dto.DtoDetallePedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.modelo.entidad.DetallePedido;
import com.ceiba.util.EstadoPedido;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class MapeoPedido implements RowMapper<DtoPedido>, MapperResult {

    @Override
    public DtoPedido mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String identificadorSeguimiento=resultSet.getString("identificadorSeguimiento");
        LocalDate fechaPedido=LocalDate.parse(resultSet.getString("fechaPedido"));
        LocalDate fechaEnvio=LocalDate.parse(resultSet.getString("fechaEnvio"));
        Double precioTotal=resultSet.getDouble("precioTotal");
        EstadoPedido estado=EstadoPedido.valueOf(resultSet.getString("estado"));
        Long idMunicipio=resultSet.getLong("id_municipio");
        String cedula=resultSet.getString("cedula");
        String direccion=resultSet.getString("direccion");
        Long idUsuario=resultSet.getLong("id_usuario");

        return new DtoPedido(id,identificadorSeguimiento,fechaPedido,fechaEnvio,precioTotal,estado,idMunicipio,cedula,direccion,idUsuario);
    }

}
