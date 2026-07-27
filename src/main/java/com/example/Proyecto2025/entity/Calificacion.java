package com.example.Proyecto2025.entity;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "calificacion")
public class Calificacion implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2807331784229261240L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id_calificacion")
	private Integer idCalificacion;
	
	@Column(name = "fecha_calificacion")
	private String fechaCalificacion;
	
	@Column(name = "nota")
	private int nota;
	
	@Column(name = "nombre")
	private String nombre;

	public Integer getIdCalificacion() {
		return idCalificacion;
	}

	public void setIdCalificacion(Integer idCalificacion) {
		this.idCalificacion = idCalificacion;
	}

	public String getFechaCalificacion() {
		return fechaCalificacion;
	}

	public void setFechaCalificacion(String fechaCalificacion) {
		this.fechaCalificacion = fechaCalificacion;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
