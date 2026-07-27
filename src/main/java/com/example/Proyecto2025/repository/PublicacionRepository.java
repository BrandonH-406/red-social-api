package com.example.Proyecto2025.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.Proyecto2025.entity.Publicacion;
import com.example.Proyecto2025.entity.Usuario;

import jakarta.transaction.Transactional;

@Repository("PublicacionRepository")

public interface PublicacionRepository extends JpaRepository<Publicacion, Serializable>{
	
	public List<Publicacion> findByUsuarioAndFechaPublicacion(Usuario idUsuario, LocalDate fechaPublicacion);
	
	public List<Publicacion> findByCantidadMegustaLessThanEqual(Integer cantidadMegusta);
	
	public List<Publicacion> findByFechaPublicacionAfter(LocalDate fechaPublicacion);
	
	
	@Query("SELECT COUNT(p) FROM Publicacion p WHERE p.usuario.idUsuario = :idUsuario")
	public int CantidadPublicaciones(@Param("idUsuario") int idUsuario);
	
	@Query("SELECT c FROM Publicacion c WHERE c.usuario.idUsuario = :idUsuario")
	public List<Publicacion> Publicacionesporusuario(@Param("idUsuario") int idUsuario);
	
	@Query("SELECT c FROM Publicacion c WHERE c.usuario.nombreUsuario = :nombreUsuario")
	public List<Publicacion> Publicacionespornombre(@Param("nombreUsuario") String nombreUsuario);
	
	@Modifying
	@Transactional
	@Query("UPDATE Publicacion p SET p.cantidadMegusta = :megustas WHERE p.idPublicacion = :idPublicacion")
	public int CantidadMegustas(@Param("megustas") int megustas, @Param("idPublicacion") int idPublicacion);

	@Query("SELECT p FROM Publicacion p WHERE p.usuario.nombreUsuario = :nombreUsuario")
	public List<Publicacion> busquedaporusuario(@Param ("nombreUsuario") String nombreUsuario);
}
