package com.example.Proyecto2025.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Proyecto2025.entity.Reaccion;
import com.example.Proyecto2025.entity.Usuario;

import jakarta.transaction.Transactional;


@Repository("ReaccionRepository")
public interface ReaccionRepository extends JpaRepository<Reaccion, Serializable> {
	
	@Query("SELECT COUNT(r) FROM Reaccion r WHERE r.usuario.idUsuario = :idUsuario")
	public int CantidadReacciones(@Param("idUsuario") int idUsuario);
	
	@Query("SELECT COUNT(r) FROM Reaccion r WHERE r.publicacion.idPublicacion = :idPublicacion")
	public int CantidadReaccionesporpublicacion(@Param("idPublicacion") int idPublicacion);
	
	@Query("SELECT COUNT(r) FROM Reaccion r WHERE r.tipo = :tipo")
	public int CantidadReaccionesMegusta(@Param("tipo") String tipo);
	
	@Query("SELECT COUNT(r) FROM Reaccion r WHERE r.tipo = :tipo")
	public int CantidadReaccionesNMegusta(@Param("tipo") String tipo);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Reaccion c WHERE c.publicacion.idPublicacion = :idPublicacion")
	public void EliminarReaccion(@Param("idPublicacion") int idPublicacion);
	
	public List<Reaccion> findByUsuario(Usuario idUsuario);


}
