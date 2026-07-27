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

import com.example.Proyecto2025.entity.Comentario;
import com.example.Proyecto2025.repository.ComentarioRepository;


@RestController
@RequestMapping(path = "/comentario")
@CrossOrigin
public class ComentarioService {

	@Autowired
	ComentarioRepository CR;
	
	@GetMapping(path = "/buscar")
	public List<Comentario> buscar() {
		return CR.findAll();
	}

	@PostMapping(path = "/guardar")
	public Comentario guardar(@RequestBody Comentario comentario) {

		CR.save(comentario);
		return comentario;

	}

	@DeleteMapping(path = "/eliminar/{idComentario}")
	public void eliminar(@PathVariable("idComentario") Integer idComentario) {
		Optional<Comentario> comentario = CR.findById(idComentario);
		if (comentario.isPresent()) {
			CR.delete(comentario.get());
		}
	}
	
	@GetMapping(path = "/cantidad/{idUsuario}")
	public int CantidadUsuario(@PathVariable ("idUsuario") int idUsuario) {
		return CR.CantidadReacciones(idUsuario);
	}
	
	@GetMapping(path = "/buscarporid/{idUsuario}")
	public List<Comentario> bucarusuarioporid(@PathVariable("idUsuario") Integer idUsuario) {
		List<Comentario> comentario = CR.Comentariosporusuario(idUsuario);
		return comentario;

	}
	
	@GetMapping(path = "/buscarporid/{idPublicacion}")
	public List<Comentario> bucarusuarioporid(@PathVariable("idPublicacion") int idPublicacion) {
		List<Comentario> comentario = CR.ComentariosporPublicacion(idPublicacion);
		return comentario;

	}
	
	@DeleteMapping(path = "/EliminarComentarios/{idPublicacion}")
	public void eliminarcomentarios(@PathVariable ("idPublicacion") int idPublicacion) {
		CR.EliminarComentario(idPublicacion);
	}
	
	@DeleteMapping(path = "/EliminarCindividual/{idPublicacion}/{idUsuario}")
	public void eliminarcomentariosindividual(@PathVariable ("idPublicacion") int idPublicacion,@PathVariable("idUsuario") int idUsuario) {
		CR.EliminarComentariounico(idPublicacion, idUsuario);
	}
	
	@GetMapping(path = "/busquedaporusuario/{nombreUsuario}")
	public List<Comentario> porusuario(@PathVariable ("nombreUsuario") String nombreUsuario){
		return CR.busquedaporusuario(nombreUsuario);
	}
	

}
