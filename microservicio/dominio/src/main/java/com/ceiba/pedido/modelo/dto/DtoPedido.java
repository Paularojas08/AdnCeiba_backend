package com.ceiba.pedido.modelo.dto;

import java.time.LocalDate;
import java.util.List;

import com.ceiba.pedido.servicio.util.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPedido {
	private Long id;
	private String identificadorSeguimiento;
	private LocalDate fechaPedido;
	private LocalDate fechaEnvio;
	private Double precioTotal;
	private List<DtoDetallePedido> detallePedido;
	private EstadoPedido estado;
	

}
