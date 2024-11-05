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

import com.examen2.entity.Coche;
import com.examen2.serviceImpl.CocheServiceImpl;

import jakarta.validation.Valid;

@RequestMapping("/api/coche")
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class CocheController {
	@Autowired
	private CocheServiceImpl cocheServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<Coche>> readAll() {
		try {
			List<Coche> o = cocheServiceImpl.readAll();
			
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
	public ResponseEntity<Coche> crearCoche(@Valid @RequestBody Coche cat) {
		//TODO: process POST request
		try {
			Coche ordenes = cocheServiceImpl.create(cat);
			return new ResponseEntity<>(ordenes, HttpStatus.ACCEPTED);
		
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCoche(@PathVariable("id") Long id, @Valid @RequestBody Coche cat) {
		//TODO: process PUT request
		Optional<Coche> ordenes = cocheServiceImpl.read(id);
		if (ordenes.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(cocheServiceImpl.update(cat), HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Coche> readCoche(@PathVariable("id") Long id) {
		//TODO: process PUT request
		try {
			Coche o = cocheServiceImpl.read(id).get();
			return new ResponseEntity<>(o, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Coche> delCoche(@PathVariable("id") Long id) {
		//TODO: process PUT request
		try {
			cocheServiceImpl.delete(id);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
