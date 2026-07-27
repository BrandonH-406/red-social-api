package com.example.Proyecto2025.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Proyecto2025.entity.Amistad;

import jakarta.transaction.Transactional;


@Repository("AmistadRepository")
public interface AmistadRepository extends JpaRepository<Amistad, Serializable>{
	
	@Query("SELECT A FROM Amistad A WHERE A.usuario2.idUsuario = :idUsuario")
	public List<Amistad> solicitudesenviadas(@Param("idUsuario") int idUsuario);
	
	@Query("SELECT A FROM Amistad A WHERE A.usuario1.idUsuario = :idUsuario")
	public List<Amistad> solicitudes(@Param("idUsuario") int idUsuario);
	
	@Query("SELECT A FROM Amistad A WHERE A.usuario1.idUsuario = :idUsuario or A.usuario2.idUsuario = :idUsuario")
	public List<Amistad> Amigosfinales(@Param("idUsuario") int idUsuario);
	
	@Modifying
	@Transactional
	@Query("UPDATE Amistad a SET a.estado = :estado WHERE a.idAmistad = :idAmistad")
	public void aceptar(@Param ("estado") String estado, @Param("idAmistad") int idAmistad);


}
