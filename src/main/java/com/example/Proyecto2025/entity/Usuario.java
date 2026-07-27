package com.example.Proyecto2025.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "publicaciones", "reaccion", "comentario" , "amistad1","amistad2"})
@Table(name = "Usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 9094517629652175728L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id_usuario")
	private Integer idUsuario;
	
	@Column(name = "Nombre_usuario")
	private String nombreUsuario;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Password")
	private String password;
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "foto")
	private String foto;
	
	@Column(name = "Estado")
	private String estado;
	
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Publicacion> publicaciones;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reaccion> reaccion;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentario;
    
    @OneToMany(mappedBy = "usuario1", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Amistad> Amistad1;
    
    public List<Amistad> getAmistad1() {
		return Amistad1;
	}

	public void setAmistad1(List<Amistad> amistad1) {
		Amistad1 = amistad1;
	}

	public List<Amistad> getAmistad2() {
		return Amistad2;
	}

	public void setAmistad2(List<Amistad> amistad2) {
		Amistad2 = amistad2;
	}

	@OneToMany(mappedBy = "usuario2", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Amistad> Amistad2;

	public List<Reaccion> getReaccion() {
		return reaccion;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}

	public void setReaccion(List<Reaccion> reaccion) {
		this.reaccion = reaccion;
	}

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
