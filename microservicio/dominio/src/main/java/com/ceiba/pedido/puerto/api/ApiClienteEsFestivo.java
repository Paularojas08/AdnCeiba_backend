package com.ceiba.pedido.puerto.api;

import java.io.IOException;
import java.time.LocalDate;

public interface ApiClienteEsFestivo {
    boolean validarFestivo(LocalDate fechaPedido) throws IOException;

}
