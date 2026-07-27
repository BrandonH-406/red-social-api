package com.example.Proyecto2025.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "reaccion", "comentario"})
@Table(name = "publicacion")
public class Publicacion implements Serializable{

	private static final long serialVersionUID = -1399836869308545532L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id_publicacion")
	private Integer idPublicacion;
	
	@Column(name = "Texto")
	private String texto;
	
	@Column(name = "Imagen")
	private String imagen;
	
	@Column(name = "Fecha_publicacion")
	private LocalDate fechaPublicacion;
	
	@Column(name = "Cantidad_megusta")
	private Integer cantidadMegusta;
	
    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reaccion> reaccion;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentario;
    
    public List<Reaccion> getReaccion() {
		return reaccion;
	}

	public void setReaccion(List<Reaccion> reaccion) {
		this.reaccion = reaccion;
	}

	@ManyToOne
    @JoinColumn(name = "Id_usuario", nullable = false)
    private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(Integer idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Integer getCantidadMegusta() {
		return cantidadMegusta;
	}

	public void setCantidadMegusta(Integer cantidadMegusta) {
		this.cantidadMegusta = cantidadMegusta;
	}

}
