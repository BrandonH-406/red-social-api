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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Proyecto2025.entity.Usuario;
import com.example.Proyecto2025.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@PutMapping(path = "/actualizar")
	public Usuario actualizarUsuario(@RequestBody Usuario usuarioActualizado) {
		Optional<Usuario> usuarioExistente = usuarioRepository.findById(usuarioActualizado.getIdUsuario());

		if (usuarioExistente.isPresent()) {
			Usuario usuario = usuarioExistente.get();
			usuario.setNombreUsuario(usuarioActualizado.getNombreUsuario());
			usuario.setNombre(usuarioActualizado.getNombre());
			usuario.setEmail(usuarioActualizado.getEmail());
			usuario.setPassword(usuarioActualizado.getPassword());
			usuario.setEstado(usuarioActualizado.getEstado());
			return usuarioRepository.save(usuario);
		} else {
			throw new RuntimeException("Usuario con ID " + usuarioActualizado.getIdUsuario() + " no encontrado");
		}
	}

	@GetMapping(path = "/buscar")
	public List<Usuario> buscar() {
		return usuarioRepository.findAll();
	}

	@PostMapping(path = "/guardar")
	public Usuario guardar(@RequestBody Usuario usuario) {

		usuarioRepository.save(usuario);
		return usuario;

	}

	@DeleteMapping(path = "/eliminar/{idUsuario}")
	public void eliminar(@PathVariable("idUsuario") Integer idUsuario) {
		Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
		if (usuario.isPresent()) {
			usuarioRepository.delete(usuario.get());
		}

	}

	@GetMapping(path = "/buscar/email/{email}/password/{password}")
	public List<Usuario> buscarporEmailyPassword(@PathVariable String email, @PathVariable String password) {
		return usuarioRepository.findByEmailAndPassword(email, password);
	}

	@GetMapping(path = "/buscar/usuario")
	public List<Usuario> buscarusuario(@RequestParam(name = "e", required = true, defaultValue = "test") String email,
			@RequestParam String password) {
		return usuarioRepository.findByEmailAndPassword(email, password);
	}

	// findbyid1

	@GetMapping(path = "/buscarporid/{idUsuario}")
	public Optional<Usuario> bucarusuarioporid(@PathVariable("idUsuario") Integer idUsuario) {
		Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
		return usuario;

	}

	// Or 1 de 3
	@GetMapping(path = "/buscar/usuario/{nombreUsuario}/email/{email}")
	public List<Usuario> buscarporusuariooemail(@PathVariable String nombreUsuario, @PathVariable String email) {
		return usuarioRepository.findByNombreUsuarioOrEmail(nombreUsuario, email);
	}

	// Like 1 de 4
	@GetMapping(path = "/usuariosactivos/estado/{estado}")
	public List<Usuario> usuariosactivos(@PathVariable String estado) {
		return usuarioRepository.findByEstadoLike(estado);
	}

	// 2 de 4

	@GetMapping(path = "/cantidadpublicacionesporusuario")
	public List<Object[]> cantidadpublicaciones() {
		return usuarioRepository.CantidadPublicacionesPorUsuario();

	}

	// 4 de 4
	@GetMapping(path = "/ordenalfabetico")
	public List<Usuario> usuariosordenados() {
		return usuarioRepository.findAllByOrderByNombreAsc();
	}

	@GetMapping(path = "/totalusuarios")
	public long conteo() {
		long total = usuarioRepository.count();
		return total;
	}

	@GetMapping(path = "/{nombreUsuario}")
	public List<Usuario> filtrado(@PathVariable String nombreUsuario) {
		return usuarioRepository.findByNombreUsuarioContainingIgnoreCase(nombreUsuario);
	}

	@PutMapping(path = "/{estado}/{idUsuario}")
	public int bloquear(@PathVariable("estado") String estado, @PathVariable("idUsuario") int idUsuario) {
		return usuarioRepository.BloquearUsuario(estado, idUsuario);
	}

	@PostMapping(path = "/login")
	public List<Usuario> login(@RequestBody Usuario usuario) {
		return usuarioRepository.findByNombreUsuarioAndPassword(usuario.getNombreUsuario(), usuario.getPassword());
	}

	@GetMapping(path = "/buscarpornombre/{nombre}")
	public List<Usuario> pornombre(@PathVariable("nombre") String nombre) {
		return usuarioRepository.findByNombreLike(nombre);
	}
	
	@PutMapping(path = "/fotoperfil/{foto}/{idUsuario}")
	public int fotoperfil(@PathVariable("foto") String estado, @PathVariable("idUsuario") int idUsuario) {
		return usuarioRepository.FotoUsuario(estado,idUsuario);
	}

}
