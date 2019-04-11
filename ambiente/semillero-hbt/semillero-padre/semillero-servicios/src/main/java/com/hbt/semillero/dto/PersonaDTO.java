package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * Clase que permite pasar los valores de las propiedades de un Objeto Persona
 */
public class PersonaDTO implements Serializable{
	
	private Long idPersona;

	private String numeroIdentificacion;

	private String tipoIdentificacion;

	private String numeroTelefonico;

	private String nombres;

	private String apellidos;

	private Long edad;
	
	private boolean vendedor;
	
	private boolean comprador;

	/**
	 * Obtiene el nombre completo de la persona.
	 * 
	 * @return
	 */
	protected String obtenerNombreCompleto() {
		return getNombres() + " " + getApellidos();
	}

	/*
	 * M�todos de acceso y modificadores de atributos
	 */

	/**
	 * Metodo que obtiene el valor de la propiedad numeroIdentificacion
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * Metodo que asigna el valor de la propiedad numeroIdentificacion
	 * @param numeroIdentificacion the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * Metodo que obtiene el valor de la propiedad tipoIdentificacion
	 * @return the tipoIdentificacion
	 */
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	/**
	 * Metodo que asigna el valor de la propiedad tipoIdentificacion
	 * @param tipoIdentificacion the tipoIdentificacion to set
	 */
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	/**
	 * Metodo que obtiene el valor de la propiedad numeroTelefonico
	 * @return the numeroTelefonico
	 */
	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	/**
	 * Metodo que asigna el valor de la propiedad numeroTelefonico
	 * @param numeroTelefonico the numeroTelefonico to set
	 */
	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}
	
	/**
	 * Metodo que obtiene el valor de la propiedad nombres
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * Metodo que asigna el valor de la propiedad nombres
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * Metodo que obtiene el valor de la propiedad apellidos
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Metodo que asigna el valor de la propiedad apellidos
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Metodo que obtiene el valor de la propiedad edad
	 * @return the edad
	 */
	public Long getEdad() {
		return edad;
	}

	/**
	 * Metodo que asigna el valor de la propiedad edad
	 * @param edad the edad to set
	 */
	public void setEdad(Long edad) {
		this.edad = edad;
	}

	/**
	 * Metodo que obtiene el valor de la propiedad idPersona
	 * @return the idPersona
	 */
	public Long getIdPersona() {
		return idPersona;
	}

	/**
	 * Metodo que asigna el valor de la propiedad idPersona
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * Metodo que obtiene el valor de la propiedad vendedor
	 * @return the vendedor
	 */
	public boolean isVendedor() {
		return vendedor;
	}

	/**
	 * Metodo que asigna el valor de la propiedad vendedor
	 * @param vendedor the vendedor to set
	 */
	public void setVendedor(boolean vendedor) {
		this.vendedor = vendedor;
	}

	/**
	 * Metodo que obtiene el valor de la propiedad comprador
	 * @return the comprador
	 */
	public boolean isComprador() {
		return comprador;
	}

	/**
	 * Metodo que asigna el valor de la propiedad comprador
	 * @param comprador the comprador to set
	 */
	public void setComprador(boolean comprador) {
		this.comprador = comprador;
	}

}
