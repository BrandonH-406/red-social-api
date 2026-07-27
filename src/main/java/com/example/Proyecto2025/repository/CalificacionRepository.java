package com.example.Proyecto2025.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.example.Proyecto2025.entity.Calificacion;

@RestController("calificacionRepository")
public interface CalificacionRepository extends JpaRepository<Calificacion, Serializable> {

	public List<Calificacion> findByNombre(String nombre);
}
