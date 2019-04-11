package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * Clase que permite pasar los valores de las propiedades de un Objeto Marca
 */
public class MarcaDTO implements Serializable{

	private Long idMarca;

	private String nombre;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}
}
