package com.example.Proyecto2025.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Proyecto2025.entity.Comentario;

import jakarta.transaction.Transactional;

@Repository("ComentarioRepository")
public interface ComentarioRepository extends JpaRepository<Comentario, Serializable> {
	
	@Query("SELECT c FROM Comentario c WHERE c.usuario.nombreUsuario = :nombreUsuario")
	public List<Comentario> busquedaporusuario(@Param ("nombreUsuario") String nombreUsuario);
	
	@Query("SELECT COUNT(c) FROM Comentario c WHERE c.usuario.idUsuario = :idUsuario")
	public int CantidadReacciones(@Param("idUsuario") int idUsuario);
	
	@Query("SELECT c FROM Comentario c WHERE c.usuario.idUsuario = :idUsuario")
	public List<Comentario> Comentariosporusuario(@Param("idUsuario") int idUsuario);
	
	@Query("SELECT c FROM Comentario c WHERE c.publicacion.idPublicacion = :idPublicacion")
	public List<Comentario> ComentariosporPublicacion(@Param("idPublicacion") int idPublicacion);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Comentario c WHERE c.publicacion.idPublicacion = :idPublicacion")
	public void EliminarComentario(@Param("idPublicacion") int idPublicacion);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Comentario c WHERE c.publicacion.idPublicacion = :idPublicacion AND c.usuario.idUsuario = :idUsuario")
	public void EliminarComentariounico(@Param("idPublicacion") int idPublicacion, @Param("idUsuario") int idUsuario);
	
}
