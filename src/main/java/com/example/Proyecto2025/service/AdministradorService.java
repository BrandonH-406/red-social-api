package com.example.Proyecto2025.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Proyecto2025.entity.Administrador;
import com.example.Proyecto2025.repository.AdministradorRepository;

@RestController
@RequestMapping("/administrador")
@CrossOrigin
public class AdministradorService {
	
	@Autowired
	AdministradorRepository administradorRepository;
	
	@GetMapping("/buscar")
	public List<Administrador> buscar(){
		return administradorRepository.findAll();
		
	}
	
	@PostMapping("/guardar")
	public Administrador guardar(@RequestBody Administrador administrador) {
		administradorRepository.save(administrador);
		return administrador;
	}
	
	@DeleteMapping("/eliminar/{idAdministrador}")
	public void eliminar(@PathVariable ("idAdministrador") Integer idAdministrador) {
		Optional<Administrador> administrador = administradorRepository.findById(idAdministrador);
		if(administrador.isPresent()) {
			administradorRepository.delete(administrador.get());
		}		
	}
	
	//findby2
	
	@GetMapping(path = "/buscarporid/{idAdministrador}")
	public Optional<Administrador> buscarporid(@PathVariable("idAdministrador") Integer idAdministrador){
		Optional<Administrador> administrador = administradorRepository.findById(idAdministrador);
		return administrador;
	}
	
	// Login
	@PostMapping(path = "/login")
	public List<Administrador> login(@RequestBody Administrador administrador){
		return administradorRepository.findByUsuarioAndPassword(administrador.getUsuario(), administrador.getPassword());		
	}
	
	@PutMapping("/actualizar/{idAdministrador}")
	public Administrador actualizar(@PathVariable int idAdministrador, @RequestBody Administrador administrador) {
	    administrador.setIdAdministrador(idAdministrador);
	    return administradorRepository.save(administrador);
	}


}
