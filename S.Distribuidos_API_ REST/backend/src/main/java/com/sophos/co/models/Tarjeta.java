package com.sophos.co.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;


//CREACION DE LA TABLA DE LA BD
@Entity
@Table(name = "TARJETA")

//CLASE PRINCIPAL DE TARJETA CON SUS ATRIBUTOS 
//ATRIBUTOS QUE VAN A SER CREADOS EN LA BD 
public class Tarjeta implements Serializable {
 
	@Id
	@Column(unique = true, nullable = false)
	private Long id;
	private String titular;
	private String fechaExpiracion;
	private Long numSeguridad;	

	
	public Tarjeta(){}

	public Tarjeta(Long id, String titular, String fechaExpiracion, Long numSeguridad) {
		super();
		this.id = id;
		this.titular = titular;
		this.fechaExpiracion = fechaExpiracion;
		this.numSeguridad = numSeguridad;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public Long getNumSeguridad() {
		return numSeguridad;
	}

	public void setNumSeguridad(Long numSeguridad) {
		this.numSeguridad = numSeguridad;
	}

	@Override
	public String toString() {
		return "Tarjeta [id=" + id + ", titular=" + titular + ", fechaExpiracion=" + fechaExpiracion + ", numSeguridad="
				+ numSeguridad + "]";
	}
}