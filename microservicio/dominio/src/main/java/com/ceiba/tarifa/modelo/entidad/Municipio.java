package com.ceiba.tarifa.modelo.entidad;

public class Municipio {
	private Long id;
	private String nombre;
	private String codigoMunicipio;

	public Municipio(Long id, String nombre, String codigoMunicipio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigoMunicipio = codigoMunicipio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

}
