package com.ceiba.pedido.controlador;

import com.ceiba.pedido.consulta.ManejadorSeguimientoPedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
@Api(tags = { "Controlador comando pedidos"})
@CrossOrigin
public class ConsultaControladorPedido {
    private final ManejadorSeguimientoPedido manejadorSeguimientoPedido;

    public ConsultaControladorPedido(ManejadorSeguimientoPedido manejadorSeguimientoPedido) {
        this.manejadorSeguimientoPedido = manejadorSeguimientoPedido;
    }
    @GetMapping(value = "/{identificador}")
    @ApiOperation("Obtener Producto Por identificador seguimiento")
    public DtoPedido buscarPedidoPorIdentificador(@PathVariable String identificador) {
        return this.manejadorSeguimientoPedido.ejecutar(identificador);
    }
}
