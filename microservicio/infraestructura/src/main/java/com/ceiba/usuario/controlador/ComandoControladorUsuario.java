package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorLoguin;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(tags = { "Controlador comando usuario"})
@CrossOrigin
public class ComandoControladorUsuario {

	private final ManejadorLoguin manejadorLoguin;

    @Autowired
    public ComandoControladorUsuario(ManejadorLoguin manejadorLoguin) {
		this.manejadorLoguin = manejadorLoguin;
	}

	@PostMapping(value = "/login")
	@ApiOperation("login")
	public ComandoRespuesta<DtoUsuario> login(@RequestBody ComandoUsuario comandoUsuario) {
		return manejadorLoguin.ejecutar(comandoUsuario);
	}
}
