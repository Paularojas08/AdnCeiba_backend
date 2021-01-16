package com.ceiba.pedido.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.servicio.ServicioSeguimientoPedido;
import org.springframework.stereotype.Component;


@Component
public class ManejadorSeguimientoPedido {

    private final ServicioSeguimientoPedido servicioSeguimientoPedido;

    public ManejadorSeguimientoPedido(ServicioSeguimientoPedido servicioSeguimientoPedido) {
        this.servicioSeguimientoPedido = servicioSeguimientoPedido;
    }

	public Pedido ejecutar(String identificador) {
		return this.servicioSeguimientoPedido.ejecutar(identificador);
	}
}
