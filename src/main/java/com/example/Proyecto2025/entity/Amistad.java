package com.example.Proyecto2025.entity;

import java.io.Serializable;
import java.time.LocalDate;


import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "amistad")
public class Amistad implements Serializable {


	private static final long serialVersionUID = 3634043901899274903L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id_amistad")
	private Integer idAmistad;
	
	@Column(name = "Fecha_amistad")
	private LocalDate fechaAmistad;
	
	@Column(name = "estado")
	private String estado;
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@ManyToOne
    @JoinColumn(name = "Id_usuario1", nullable = false)
    private Usuario usuario1;
	
	@ManyToOne
    @JoinColumn(name = "Id_usuario2", nullable = false)
    private Usuario usuario2;

	public Integer getIdAmistad() {
		return idAmistad;
	}

	public void setIdAmistad(Integer idAmistad) {
		this.idAmistad = idAmistad;
	}

	public LocalDate getFechaAmistad() {
		return fechaAmistad;
	}

	public void setFechaAmistad(LocalDate fechaAmistad) {
		this.fechaAmistad = fechaAmistad;
	}

	public Usuario getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}
