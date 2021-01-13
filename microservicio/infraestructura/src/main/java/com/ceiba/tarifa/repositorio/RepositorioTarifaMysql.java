package com.ceiba.tarifa.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tarifa.puerto.dao.RepositorioTarifa;


import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTarifaMysql implements RepositorioTarifa {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="tarifa", value="obtenerPrecio")
    private static String sqlObtenerPrecio;


    public RepositorioTarifaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }



	@Override
	public Double obtenerTarifaPorMunicipio(Long idMunicipio) {
		return this.customNamedParameterJdbcTemplate.obtenerDoubleValue("idMunicipio", idMunicipio, sqlObtenerPrecio);

	}
}
