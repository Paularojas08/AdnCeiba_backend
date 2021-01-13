package com.ceiba.pedido.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pedido.comando.ComandoSolcitudPedido;
import com.ceiba.pedido.comando.fabrica.FabricaPedido;
import com.ceiba.pedido.modelo.entidad.SolicitudPedido;
import com.ceiba.pedido.servicio.ServicioCrearPedido;
import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearPedido implements ManejadorComandoRespuesta<ComandoSolcitudPedido, ComandoRespuesta<Long>> {

    private final FabricaPedido fabricaPedido;
    private final ServicioCrearPedido servicioCrearPedido;

    public ManejadorCrearPedido(FabricaPedido fabricaPedido, ServicioCrearPedido servicioCrearPedido) {
        this.fabricaPedido = fabricaPedido;
        this.servicioCrearPedido = servicioCrearPedido;
    }

   

	@Override
	public ComandoRespuesta<Long> ejecutar(ComandoSolcitudPedido solicitudPedido) {
		return new ComandoRespuesta<>(this.servicioCrearPedido.ejecutar(new SolicitudPedido()));		
	}
}
