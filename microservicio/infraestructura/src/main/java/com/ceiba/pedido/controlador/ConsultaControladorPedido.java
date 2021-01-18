package com.ceiba.pedido.controlador;

import com.ceiba.municipio.modelo.dto.DtoMunicipio;
import com.ceiba.pedido.consulta.ManejadorListarPedidos;
import com.ceiba.pedido.consulta.ManejadorSeguimientoPedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@Api(tags = { "Controlador comando pedidos"})
@CrossOrigin
public class ConsultaControladorPedido {
    private final ManejadorSeguimientoPedido manejadorSeguimientoPedido;
    private final ManejadorListarPedidos manejadorListarPedidos;

    public ConsultaControladorPedido(ManejadorSeguimientoPedido manejadorSeguimientoPedido, ManejadorListarPedidos manejadorListarPedidos) {
        this.manejadorSeguimientoPedido = manejadorSeguimientoPedido;
        this.manejadorListarPedidos = manejadorListarPedidos;
    }
    @GetMapping(value = "/{identificador}")
    @ApiOperation("Obtener Producto Por identificador seguimiento")
    public DtoPedido buscarPedidoPorIdentificador(@PathVariable String identificador) {
        return this.manejadorSeguimientoPedido.ejecutar(identificador);
    }
    @GetMapping
    @ApiOperation("Listar pedidos")
    public List<DtoPedido> listar() {
        return this.manejadorListarPedidos.ejecutar();
    }
}
