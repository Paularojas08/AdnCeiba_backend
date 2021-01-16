package com.ceiba.pedido.comando;

import java.time.LocalDate;
import java.util.List;

import com.ceiba.pedido.modelo.entidad.DetallePedido;
import com.ceiba.util.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPedido {
	private Long id;
	private String identificadorSeguimiento;
	private LocalDate fechaPedido;
	private LocalDate fechaEnvio;
	private Double precioTotal;
	private List<DetallePedido> detallePedido;
	private EstadoPedido estado;
	private long idMunicipio;
	private String cedula;
	private String direccion;
	private Long idUsuario;

}
