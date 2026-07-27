package com.example.Proyecto2025.service;

import java.time.LocalDate;
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


import com.example.Proyecto2025.entity.Publicacion;
import com.example.Proyecto2025.entity.Usuario;
import com.example.Proyecto2025.repository.PublicacionRepository;

@RestController
@RequestMapping("/publicacion")
@CrossOrigin
public class PublicacionService {
	
	@Autowired
	PublicacionRepository publicacionRepository;
	
	@GetMapping(path = "/buscar")
	public List<Publicacion> buscar(){
		return publicacionRepository.findAll();
	}
	
	@PostMapping(path = "/guardar")
	public Publicacion guardar(@RequestBody Publicacion publicacion) {
		publicacionRepository.save(publicacion);
		return publicacion;
	}
	
	@DeleteMapping(path = "/eliminar/{idPublicacion}")
	public void eliminar(@PathVariable ("idPublicacion") Integer idPublicacion) {
		Optional<Publicacion> publicacion = publicacionRepository.findById(idPublicacion);
		if(publicacion.isPresent()) {
			publicacionRepository.delete(publicacion.get());
		}
	}
	
	//findbyid3
	@GetMapping(path = "/buscarporid1/{idPublicacion}")
	public Optional<Publicacion> buscarporid(@PathVariable ("idPublicacion") Integer idPublicacion){
		Optional<Publicacion> publicacion = publicacionRepository.findById(idPublicacion);
		return publicacion;	
	}
	
	//and 2 de 3
	@GetMapping(path = "/buscarporusuarioyfecha/usuario/{usuario}/fecha/{fechaPublicacion}")
	public List<Publicacion> buscarporusuarioyfecha(@PathVariable Usuario usuario, @PathVariable LocalDate fechaPublicacion){
		return publicacionRepository.findByUsuarioAndFechaPublicacion(usuario, fechaPublicacion);
		
	}
	
	//between 3 de 3
	
	@GetMapping(path = "/cantidaddemegusta/{cantidadMegusta}")
	public List<Publicacion> cantidadmegusta(@PathVariable Integer cantidadMegusta){
		return publicacionRepository.findByCantidadMegustaLessThanEqual(cantidadMegusta);
	}
	
	// 3 de 4 
	
	@GetMapping(path = "/publicacionesdespuesde/{fechaPublicacion}")
	public List<Publicacion> publicacionesporfecha(@PathVariable LocalDate fechaPublicacion){
		return publicacionRepository.findByFechaPublicacionAfter(fechaPublicacion);
	}
	
	@GetMapping(path = "/totalpublicaciones")
	public long conteo() {
		long total = publicacionRepository.count();
		return total;
	}
	
	@GetMapping(path = "/cantidad/{idUsuario}")
	public int CantidadUsuario(@PathVariable ("idUsuario") int idUsuario) {
		return publicacionRepository.CantidadPublicaciones(idUsuario);
	}
	
	@GetMapping(path = "/buscarporid/{idUsuario}")
	public List<Publicacion> bucarusuarioporid(@PathVariable("idUsuario") Integer idUsuario) {
		List<Publicacion> publicacion = publicacionRepository.Publicacionesporusuario(idUsuario);
		return publicacion;
	}
	
	@GetMapping(path = "/buscarpornombre/{nombreUsuario}")
	public List<Publicacion> bucarusuarioporid(@PathVariable("nombreUsuario") String nombreUsuario) {
		List<Publicacion> publicacion = publicacionRepository.Publicacionespornombre(nombreUsuario);
		return publicacion;
	}
	
	@PutMapping(path = "/cambiar/{megustas}/{idPublicacion}")
	public int megustas(@PathVariable("megustas") int megustas, @PathVariable("idPublicacion") int idPublicacion) {
		return publicacionRepository.CantidadMegustas(megustas, idPublicacion);
	}
	
	@GetMapping(path = "/busquedaporusuario/{nombreUsuario}")
	public List<Publicacion> porusuario(@PathVariable ("nombreUsuario") String nombreUsuario){
		return publicacionRepository.busquedaporusuario(nombreUsuario);
	}
}
