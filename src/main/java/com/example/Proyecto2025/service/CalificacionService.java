package com.example.Proyecto2025.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Proyecto2025.entity.Calificacion;
import com.example.Proyecto2025.repository.CalificacionRepository;

@RestController
@RequestMapping("/calificacion")
@CrossOrigin
public class CalificacionService {
	
	@Autowired
	CalificacionRepository Cr;
	
	@GetMapping("/buscar")
	public List<Calificacion> buscar(){
		return Cr.findAll();
		
	}
	
	@PostMapping("/guardar")
	public Calificacion guardar(@RequestBody Calificacion calificacion) {
		Cr.save(calificacion);
		return calificacion;
	}
	
	@DeleteMapping("/eliminar/{idCalificacion}")
	public void eliminar(@PathVariable ("idCalificacion") Integer idCalificacion) {
		Optional<Calificacion> calificacion = Cr.findById(idCalificacion);
		if(calificacion.isPresent()) {
			Cr.delete(calificacion.get());
		}		
	}
	
	@GetMapping(path = "/busqueda/{nombre}")
	public List<Calificacion> bucarnota(@PathVariable("nombre") String nombre){
		List<Calificacion> calificacion = Cr.findByNombre(nombre);
		return calificacion;
		
	}

}
