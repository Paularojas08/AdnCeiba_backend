package com.ceiba.pedido.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.util.Constantes;

public class ServicioEliminarPedido {
    private final RepositorioPedido repositorioPedido;

    public ServicioEliminarPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public void ejecutar(Long id){
        validarExistencia(id);
        this.repositorioPedido.eliminar(id);
    }

    private void validarExistencia(Long id){
        if(!repositorioPedido.obtenerPedidoPorId(id)){
            throw new ExcepcionDuplicidad(Constantes.EL_PEDIDO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
