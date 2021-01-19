package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.servicio.ServicioLoguin;
import org.springframework.stereotype.Component;

@Component
public class ManejadorLoguin implements ManejadorComandoRespuesta<ComandoUsuario, ComandoRespuesta<DtoUsuario>> {
    private final ServicioLoguin servicioLoguin;

    public ManejadorLoguin(ServicioLoguin servicioLoguin) {
        this.servicioLoguin = servicioLoguin;
    }

    @Override
    public ComandoRespuesta<DtoUsuario> ejecutar(ComandoUsuario comandoUsuario) {
        return new ComandoRespuesta<>(this.servicioLoguin.ejecutar(comandoUsuario.getCorreo(), comandoUsuario.getClave()));
    }
}
