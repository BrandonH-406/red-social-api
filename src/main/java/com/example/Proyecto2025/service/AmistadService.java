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

import com.example.Proyecto2025.entity.Amistad;

import com.example.Proyecto2025.repository.AmistadRepository;

@RestController
@RequestMapping(path = "/amistad")
@CrossOrigin

public class AmistadService {
	
	@Autowired
	AmistadRepository AR;
	
	@GetMapping(path = "/buscar")
	public List<Amistad> buscar() {
		return AR.findAll();
	}

	@PostMapping(path = "/guardar")
	public Amistad guardar(@RequestBody Amistad amistad) {

		AR.save(amistad);
		return amistad;

	}

	@DeleteMapping(path = "/eliminar/{idAmistad}")
	public void eliminar(@PathVariable("idAmistad") Integer idAmistad) {
		Optional<Amistad> amistad = AR.findById(idAmistad);
		if (amistad.isPresent()) {
			AR.delete(amistad.get());
		}

	}
	
	@GetMapping(path = "/pendinte/{idUsuario}")
	public List<Amistad> solicitudesenviadas(@PathVariable int idUsuario){
		return AR.solicitudesenviadas(idUsuario);
	}
	
	@GetMapping(path = "/solicitud/{idUsuario}")
	public List<Amistad> solicitud(@PathVariable int idUsuario){
		return AR.solicitudes(idUsuario);
	}
	
	@GetMapping(path = "/Amigosf/{idUsuario}")
	public List<Amistad> amigosfinales(@PathVariable int idUsuario){
		return AR.Amigosfinales(idUsuario);
	}	
	
	@PutMapping(path = "/aceptar/{estado}/{idAmistad}")
	public void aceptarsolicitud(@PathVariable String estado, @PathVariable int idAmistad) {
		AR.aceptar(estado, idAmistad);
	}

}
