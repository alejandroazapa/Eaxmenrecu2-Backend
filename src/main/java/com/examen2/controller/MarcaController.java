package com.examen2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen2.entity.Marca;
import com.examen2.service.MarcaService;

import jakarta.validation.Valid;

@RequestMapping("/api/marca")
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class MarcaController {
	@Autowired
	private MarcaService marcaServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<Marca>> readAll() {
		try {
			List<Marca> o = marcaServiceImpl.readAll();
			
			if(o.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(o, HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
	@PostMapping
	public ResponseEntity<Marca> crearMarca(@Valid @RequestBody Marca cat) {
		//TODO: process POST request
		try {
			Marca ordenes = marcaServiceImpl.create(cat);
			return new ResponseEntity<>(ordenes, HttpStatus.ACCEPTED);
		
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateMarca(@PathVariable("id") Long id, @Valid @RequestBody Marca cat) {
		//TODO: process PUT request
		Optional<Marca> ordenes = marcaServiceImpl.read(id);
		if (ordenes.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(marcaServiceImpl.update(cat), HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Marca> readMarca(@PathVariable("id") Long id) {
		//TODO: process PUT request
		try {
			Marca o = marcaServiceImpl.read(id).get();
			return new ResponseEntity<>(o, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Marca> delMarca(@PathVariable("id") Long id) {
		//TODO: process PUT request
		try {
			marcaServiceImpl.delete(id);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
