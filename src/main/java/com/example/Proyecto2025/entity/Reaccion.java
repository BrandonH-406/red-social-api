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
@Table(name = "Reaccion")
public class Reaccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3840487796040784548L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id_reaccion")
	private Integer idReaccion;
	
	@Column(name = "Fecha_reaccion")
	private LocalDate fechaReaccion;
	
    @ManyToOne
    @JoinColumn(name = "Id_usuario", nullable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "Id_publicacion", nullable = false)
    private Publicacion publicacion;
    
    @Column(name = "tipo")
    private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getIdReaccion() {
		return idReaccion;
	}

	public void setIdReaccion(Integer idReaccion) {
		this.idReaccion = idReaccion;
	}

	public LocalDate getFechaReaccion() {
		return fechaReaccion;
	}

	public void setFechaReaccion(LocalDate fechaReaccion) {
		this.fechaReaccion = fechaReaccion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

}
