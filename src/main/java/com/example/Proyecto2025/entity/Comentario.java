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
@Table(name = "Comentario")
public class Comentario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7089102689415185854L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id_comentario")
	private Integer idComentario;
	
	@Column(name = "Texto_comentario")
	private String textoComentario;
	
	@Column(name = "Fecha_de_comentario")
	private LocalDate fechaDeComentario;
	
    @ManyToOne
    @JoinColumn(name = "Id_usuario", nullable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "Id_publicacion", nullable = false)
    private Publicacion publicacion;

	public Integer getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Integer idComentario) {
		this.idComentario = idComentario;
	}

	public String getTextoComentario() {
		return textoComentario;
	}

	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}

	public LocalDate getFechaDeComentario() {
		return fechaDeComentario;
	}

	public void setFechaDePublicacion(LocalDate fechaDeComentario) {
		this.fechaDeComentario = fechaDeComentario;
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
