package com.ceiba.pedido.servicio.util.validation;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.servicio.util.Constantes;

public class ReglaValidarPrecioPedido implements ReglasDeNegocio {

	@Override
	public void validar(Pedido pedido) {
		Double precio = pedido.getPrecioTotal();
		Double precioMinimo = Constantes.PRECIO_MINIMO;
		Double precioMaximo = Constantes.PRECIO_MAXIMO;
		Double porcentajeMinimo = Constantes.PORCENTAJE_MINIMO;
		Double porcentajeMaximo = Constantes.PORCENTAJE_MAXIMO;

		if (precio > precioMinimo && precio < precioMaximo) {
			pedido.setPrecioTotal(calcularSobreCosto(precio, porcentajeMinimo));
		}
		if (precio > precioMaximo) {
			pedido.setPrecioTotal(calcularSobreCosto(precio, porcentajeMaximo));
		}
	}

	private Double calcularSobreCosto(Double precio, Double procentaje) {
		return precio + (precio * procentaje);
	}

}
