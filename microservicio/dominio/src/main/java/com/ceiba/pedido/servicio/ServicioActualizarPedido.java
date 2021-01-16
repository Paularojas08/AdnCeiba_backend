package com.ceiba.pedido.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.util.Constantes;

public class ServicioActualizarPedido {

    private final RepositorioPedido repositorioPedido;

    public ServicioActualizarPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public void ejecutar(Pedido pedido){
        validarExistencia(pedido.getId());
        this.repositorioPedido.actualizar(pedido);
    }

    private void validarExistencia(Long id){
       if(!repositorioPedido.obtenerPedidoPorId(id)){
           throw new ExcepcionDuplicidad(Constantes.EL_PEDIDO_NO_EXISTE_EN_EL_SISTEMA);
       }
    }
}
