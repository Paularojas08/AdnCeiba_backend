package com.ceiba.pedido.modelo.entidad;

import java.time.LocalDate;
import java.util.List;

import com.ceiba.pedido.servicio.util.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
	private Long id;
	private String identificadorSeguimiento;
	private LocalDate fechaPedido;
	private LocalDate fechaEnvio;
	private Double precioTotal;
	private List<DetallePedido> detallePedido;
	private EstadoPedido estado;
	

}
