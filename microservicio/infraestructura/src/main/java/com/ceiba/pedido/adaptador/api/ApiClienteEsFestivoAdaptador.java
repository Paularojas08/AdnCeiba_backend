package com.ceiba.pedido.adaptador.api;

import com.ceiba.infraestructura.api.HolidayAbstractApi;
import com.ceiba.pedido.puerto.api.ApiClienteEsFestivo;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;

@Component
public class ApiClienteEsFestivoAdaptador implements ApiClienteEsFestivo {


    @Override
    public boolean validarFestivo(LocalDate fechaPedido) throws IOException {
        return HolidayAbstractApi.esFestivo(fechaPedido);
    }
}
