package com.example.Proyecto2025.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.example.Proyecto2025.entity.Administrador;

@RestController("AdministradorRepository")
public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{
	
	public List<Administrador> findByUsuarioAndPassword(String usuario,String password);

}
