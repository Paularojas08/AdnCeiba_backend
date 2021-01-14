package com.ceiba.configuracion;

import com.ceiba.pedido.puerto.repositorio.RepositorioDetallePedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.ServicioCrearPedido;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.tarifa.puerto.dao.RepositorioTarifa;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
	
    @Bean
    public ServicioCrearPedido servicioCrearPedido(RepositorioPedido repositorioPedido, RepositorioProducto repositorioProducto,
                                                   RepositorioTarifa repositorioTarifa, RepositorioDetallePedido repositorioDetallePedido) {
        return new ServicioCrearPedido(repositorioPedido,repositorioProducto,repositorioTarifa, repositorioDetallePedido);
    }
}
