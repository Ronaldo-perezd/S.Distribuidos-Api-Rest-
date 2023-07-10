package com.sophos.co.rest;
/*
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sophos.co.models.Persona;
import com.sophos.co.repository.PersonaRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository;

	@PostMapping()
	public ResponseEntity<Persona> findById(@RequestBody Persona persona) {

		Optional<Persona> carroOptional =personaRepository.findById(persona.getId());

		if (!carroOptional.isPresent()) {
			Persona persona2=personaRepository.save(persona);
			return ResponseEntity.ok(persona);
		}else {
			return new ResponseEntity("Esta no existe", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/persona/{id}")
	public ResponseEntity<Persona> findIdPersona(@PathVariable("id") Long id) {
		Optional<Persona > optional = personaRepository.findById(id);
		return ResponseEntity.ok(optional.get());
	}
	@DeleteMapping("/persona/{id}")
	public ResponseEntity<Void> deletePersona(@PathVariable("id") Long id) {

		Optional<Persona> optional = personaRepository.findById(id);
		if (optional.isPresent()) {
			personaRepository.delete(optional.get());
			return ResponseEntity.ok(null);
		}else {
			return new  ResponseEntity("Este Carro no existe ", HttpStatus.NOT_FOUND);
		}

	}
}
*/