package com.ceiba.pedido.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pedido.comando.ComandoSolcitudPedido;
import com.ceiba.pedido.comando.fabrica.FabricaSolicitudPedido;
import com.ceiba.pedido.modelo.entidad.SolicitudPedido;
import com.ceiba.pedido.servicio.ServicioCrearPedido;
import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearPedido implements ManejadorComandoRespuesta<ComandoSolcitudPedido, ComandoRespuesta<Long>> {

    private final FabricaSolicitudPedido fabricaSolicitudPedido;
    private final ServicioCrearPedido servicioCrearPedido;

    public ManejadorCrearPedido(FabricaSolicitudPedido fabricaSolicitudPedido, ServicioCrearPedido servicioCrearPedido) {
        this.fabricaSolicitudPedido = fabricaSolicitudPedido;
        this.servicioCrearPedido = servicioCrearPedido;
    }

   

	@Override
	public ComandoRespuesta<Long> ejecutar(ComandoSolcitudPedido comandoSolicitudPedido) {
        SolicitudPedido solicitudPedido = fabricaSolicitudPedido.crear(comandoSolicitudPedido);
		return new ComandoRespuesta<>(this.servicioCrearPedido.ejecutar(solicitudPedido));
	}

}
