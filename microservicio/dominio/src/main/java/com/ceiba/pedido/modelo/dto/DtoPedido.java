package com.ceiba.pedido.modelo.dto;

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
public class DtoPedido {
	private Long id;
	private String identificadorSeguimiento;
	private LocalDate fechaPedido;
	private LocalDate fechaEnvio;
	private Double precioTotal;
	private List<DtoDetallePedido> detallePedido;
	private EstadoPedido estado;
	private Long idMunicipio;
	private String cedula;
	private String direccion;
	private Long  idUsuario;


}
