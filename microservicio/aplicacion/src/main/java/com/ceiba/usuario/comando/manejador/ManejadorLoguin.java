package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.servicio.ServicioLogin;
import org.springframework.stereotype.Component;

@Component
public class ManejadorLoguin implements ManejadorComandoRespuesta<ComandoUsuario, ComandoRespuesta<DtoUsuario>> {
    private final ServicioLogin servicioLogin;

    public ManejadorLoguin(ServicioLogin servicioLogin) {
        this.servicioLogin = servicioLogin;
    }

    @Override
    public ComandoRespuesta<DtoUsuario> ejecutar(ComandoUsuario comandoUsuario) {
        return new ComandoRespuesta<>(this.servicioLogin.ejecutar(comandoUsuario.getCorreo(), comandoUsuario.getClave()));
    }
}
