package com.ceiba.tarifa.puerto.dao;


public interface RepositorioTarifa {
	/**
	 * Permite obtener la tarifa de envio de un municipio dado un idMunicipio
	 * @param idMunicipio
	 * @return tarifa
	 */
	Double obtenerTarifaPorMunicipio(Long idMunicipio);
}
