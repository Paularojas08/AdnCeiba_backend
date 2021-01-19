package com.ceiba.configuracion;


import com.ceiba.pedido.puerto.api.ApiClienteEsFestivo;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioDetallePedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.ServicioActualizarPedido;
import com.ceiba.pedido.servicio.ServicioCrearPedido;
import com.ceiba.pedido.servicio.ServicioEliminarPedido;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.tarifa.puerto.dao.RepositorioTarifa;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioLogin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {


    @Bean
    public ServicioActualizarPedido servicioActualizarPedido(RepositorioPedido repositorioPedido){
        return  new ServicioActualizarPedido(repositorioPedido);
    }
    @Bean
    public ServicioEliminarPedido servicioEliminarPedido(RepositorioPedido repositorioPedido){
        return new ServicioEliminarPedido(repositorioPedido);
    }
    @Bean
    public ServicioCrearPedido servicioCrearPedido(RepositorioPedido repositorioPedido, RepositorioProducto repositorioProducto,
                                                   RepositorioTarifa repositorioTarifa, RepositorioDetallePedido repositorioDetallePedido, ApiClienteEsFestivo apiClienteEsFestivo, DaoPedido daoPedido) {
        return new ServicioCrearPedido(repositorioPedido,repositorioProducto,repositorioTarifa, repositorioDetallePedido,apiClienteEsFestivo,daoPedido);
    }

    @Bean
    public ServicioLogin servicioLoguin(RepositorioUsuario repositorioUsuario){
        return new ServicioLogin(repositorioUsuario);
    }

}
