package com.sophos.co.rest;


import com.sophos.co.models.Tarjeta;
import com.sophos.co.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tarjeta")

//CLASE CON LOS METODOS PARA LA GESTION DE LAS TARJETAS
public class TarjetaController {
	@Autowired
	private TarjetaRepository tarjetaRepository;

	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<Tarjeta>> findAllTarjetas(){
		List<Tarjeta> tarjetas = tarjetaRepository.findAll();
		return ResponseEntity.ok(tarjetas);
	}

	//GUARDA UNA TARJETA CON TODOS SUS DATOS
	@CrossOrigin(origins = "*")
	@PostMapping("/tarjeta")
	public ResponseEntity<Tarjeta> findById(@RequestBody Tarjeta tarjeta) {

		Optional<Tarjeta> tarjetaOptional =tarjetaRepository.findById(tarjeta.getId());

		if (!tarjetaOptional.isPresent()) {
			Tarjeta tarjeta2=tarjetaRepository.save(tarjeta);
			return ResponseEntity.ok(tarjeta);
		}else {
			return new ResponseEntity("Esta no existe", HttpStatus.NOT_FOUND);
		}
	}

	//OBTENER TODOS LOS DATOS DE UNA TARJETA POR EL ID(NUMERO) 
	@CrossOrigin(origins = "*")
	@GetMapping("/tarjeta/{id}")
	public ResponseEntity<Tarjeta> findIdTarjeta(@PathVariable("id") Long id) {
		Optional<Tarjeta > optional = tarjetaRepository.findById(id);

		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}else {
			return new  ResponseEntity("ESTA TAJETA NO EXISTE...!", HttpStatus.NOT_FOUND);
		}
	}
	
	//ELIMINAR UNA TARJETA POR SU ID
	@CrossOrigin(origins = "*")
	@DeleteMapping("/tarjeta/{id}")
	public ResponseEntity<Void> deletePersona(@PathVariable("id") Long id) {

		Optional<Tarjeta> optional = tarjetaRepository.findById(id);
		if (optional.isPresent()) {
			tarjetaRepository.delete(optional.get());
			return ResponseEntity.ok(null);
		}else {
			return new  ResponseEntity("ESTA TAJETA NO EXISTE...! ", HttpStatus.NOT_FOUND);
		}
	}

	//ACTUALIZAR LOS DATOS DE UNA TARJETA
	//ID NO SE ACTUALIZA
	@CrossOrigin(origins = "*")
	@PutMapping("/tarjeta")
	public ResponseEntity<Tarjeta> updateTarjeta(@RequestBody Tarjeta tarjeta) {
		Optional<Tarjeta> optional= tarjetaRepository.findById(tarjeta.getId());
		if (optional.isPresent()) {
			Tarjeta tarjeta2 = new Tarjeta();
			tarjeta2.setId(tarjeta.getId());
			tarjeta2.setTitular(tarjeta.getTitular());
			tarjeta2.setFechaExpiracion(tarjeta.getFechaExpiracion());
			tarjeta2.setNumSeguridad(tarjeta.getNumSeguridad());
			tarjetaRepository.save(tarjeta2);

			return ResponseEntity.ok(tarjeta2);
		}else {
			return new ResponseEntity("ESTA TAJETA NO EXISTE...! ",HttpStatus.BAD_REQUEST);
		}
	}
}