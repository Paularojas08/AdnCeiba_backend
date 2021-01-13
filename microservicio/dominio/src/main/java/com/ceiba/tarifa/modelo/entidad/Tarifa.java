package com.ceiba.tarifa.modelo.entidad;

public class Tarifa {
	private Long id;
	private Long idMunicipio;
	private Double precio;

	public Tarifa(Long id, Long idMunicipio, Double precio) {
		super();
		this.id = id;
		this.idMunicipio = idMunicipio;
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
