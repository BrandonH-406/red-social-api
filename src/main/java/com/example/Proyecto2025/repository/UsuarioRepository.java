package com.example.Proyecto2025.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.Proyecto2025.entity.Usuario;

import jakarta.transaction.Transactional;

@Repository("UsuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {

	public List<Usuario> findByEmailAndPassword(String email, String password);

	public List<Usuario> findByNombreUsuarioOrEmail(String nombreUsuario, String email);
	
	public List<Usuario> findByNombreUsuarioAndPassword(String nombreUsuario,String password);

	public List<Usuario> findByEstadoLike(String estado);

	@Query("SELECT u.nombre, COUNT(p) " + "FROM Usuario u JOIN u.publicaciones p " + "GROUP BY u.nombre")
	public List<Object[]> CantidadPublicacionesPorUsuario();

	public List<Usuario> findAllByOrderByNombreAsc();

	public List<Usuario> findByNombreUsuarioContainingIgnoreCase(String nombreUsuario);
	
	public List<Usuario> findByNombreLike(String nombre);
	
	@Modifying
	@Transactional
	@Query("UPDATE Usuario u SET u.estado = :estado WHERE u.idUsuario = :idUsuario")
	public int BloquearUsuario(@Param ("estado") String estado, @Param("idUsuario") int idUsuario);
	
	@Modifying
	@Transactional
	@Query("UPDATE Usuario u SET u.foto = :foto WHERE u.idUsuario = :idUsuario")
	public int FotoUsuario(@Param ("foto") String foto, @Param("idUsuario") int idUsuario);
	
	

	// public Integer CountByIdUsuario(Integer idUsuario);

	/*
	 * findByNombre(String nombre) findByEdad(int edad)
	 * 
	 * findByEdadGreaterThan(int edad) // edad > ? findByEdadLessThan(int edad) //
	 * edad < ? findByEdadGreaterThanEqual(int edad) // edad >= ?
	 * findByEdadLessThanEqual(int edad) // edad <= ?
	 * 
	 * findByEdadBetween(int start, int end) // edad BETWEEN ? AND ?
	 * 
	 * findByNombreAndCorreo(String nombre, String correo)
	 * findByNombreOrCorreo(String nombre, String correo)
	 * 
	 * findByActivoTrue() // activo = true findByActivoFalse() // activo = false
	 * 
	 * findByNombreLike(String nombre) // nombre LIKE ? findByNombreNotLike(String
	 * nombre) // nombre NOT LIKE ? findByNombreStartingWith(String prefijo) //
	 * nombre LIKE 'prefijo%' findByNombreEndingWith(String sufijo) // nombre LIKE
	 * '%sufijo' findByNombreContaining(String texto) // nombre LIKE '%texto%'
	 * 
	 * findByNombreOrderByEdadAsc(String nombre) // ORDER BY edad ASC
	 * findByNombreOrderByEdadDesc(String nombre) // ORDER BY edad DESC
	 * 
	 * findFirstByNombre(String nombre) findTop3ByEdadGreaterThan(int edad)
	 * 
	 * findByEdadNot(int edad) // edad <> ? findByNombreNotLike(String n) // nombre
	 * NOT LIKE ?
	 * 
	 * countByEdad(int edad) // COUNT(*) WHERE edad = ?
	 * 
	 * findByFechaAfter(Date fecha) // fecha > ? findByFechaBefore(Date fecha) //
	 * fecha < ? findByFechaBetween(Date f1, Date f2) // fecha BETWEEN ? AND ?
	 * 
	 */

}
