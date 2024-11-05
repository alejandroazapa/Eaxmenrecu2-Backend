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

import com.examen2.entity.Tipo;
import com.examen2.serviceImpl.TipoServiceImpl;

import jakarta.validation.Valid;

@RequestMapping("/api/tipo")
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class TipoController {
	@Autowired
	private TipoServiceImpl tipoServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<Tipo>> readAll() {
		try {
			List<Tipo> o = tipoServiceImpl.readAll();
			
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
	public ResponseEntity<Tipo> crearTipo(@Valid @RequestBody Tipo cat) {
		//TODO: process POST request
		try {
			Tipo ordenes = tipoServiceImpl.create(cat);
			return new ResponseEntity<>(ordenes, HttpStatus.ACCEPTED);
		
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTipo(@PathVariable("id") Long id, @Valid @RequestBody Tipo cat) {
		//TODO: process PUT request
		Optional<Tipo> ordenes = tipoServiceImpl.read(id);
		if (ordenes.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(tipoServiceImpl.update(cat), HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Tipo> readTipo(@PathVariable("id") Long id) {
		//TODO: process PUT request
		try {
			Tipo o = tipoServiceImpl.read(id).get();
			return new ResponseEntity<>(o, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Tipo> delTipo(@PathVariable("id") Long id) {
		//TODO: process PUT request
		try {
			tipoServiceImpl.delete(id);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
