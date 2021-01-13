package com.ceiba.pedido.servicio.util.validation;

import com.ceiba.pedido.modelo.entidad.Pedido;

@FunctionalInterface
public interface ReglasDeNegocio {
	void validar(Pedido pedido);
}
