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

import com.example.Proyecto2025.entity.Reaccion;
import com.example.Proyecto2025.entity.Usuario;
import com.example.Proyecto2025.repository.ReaccionRepository;

@RestController
@RequestMapping(path = "/reaccion")
@CrossOrigin
public class ReaccionService {

	@Autowired
	ReaccionRepository RR;

	@GetMapping(path = "/buscar")
	public List<Reaccion> buscar() {
		return RR.findAll();
	}

	@PostMapping(path = "/guardar")
	public Reaccion guardar(@RequestBody Reaccion reaccion) {

		RR.save(reaccion);
		return reaccion;

	}

	@DeleteMapping(path = "/eliminar/{idReaccion}")
	public void eliminar(@PathVariable("idReaccion") Integer idReaccion) {
		Optional<Reaccion> reaccion = RR.findById(idReaccion);
		if (reaccion.isPresent()) {
			RR.delete(reaccion.get());
		}
	}
	
	@GetMapping(path = "/totalreacciones")
	public long conteo() {
		long total = RR.count();
		return total;
	}
	
	@GetMapping(path = "/cantidadporusuario/{idUsuario}")
	public int CantidadUsuario(@PathVariable ("idUsuario") int idUsuario) {
		return RR.CantidadReacciones(idUsuario);
	}
	
	@GetMapping(path = "/cantidad/{idPublicacion}")
	public int CantidadPublicacion(@PathVariable ("idPublicacion") int idPublicacion) {
		return RR.CantidadReaccionesporpublicacion(idPublicacion);
	}
	
	@DeleteMapping(path = "/EliminarReaccion/{idPublicacion}")
	public void eliminarReaccion(@PathVariable ("idPublicacion") int idPublicacion) {
		RR.EliminarReaccion(idPublicacion);
	}
	
	
	@GetMapping(path = "/porusuario/{usuario}")
	public List<Reaccion> porusuario(@PathVariable("usuario") Usuario usuario){
		return RR.findByUsuario(usuario);
	}
	
	@GetMapping(path = "/Megusta/{tipo}")
	public int Megusta(@PathVariable("tipo") String tipo) {
		return RR.CantidadReaccionesMegusta(tipo);
	}
	
	@GetMapping(path = "/NoMegusta/{tipo}")
	public int NoMegusta(@PathVariable("tipo") String tipo) {
		return RR.CantidadReaccionesNMegusta(tipo);
	}


}
