package com.examen2.dao;

import java.util.List;
import java.util.Optional;

import com.examen2.entity.Marca;

public interface MarcaDao {
	Marca create(Marca c);
	Marca update(Marca c);
	void delete(Long id);
	Optional<Marca> read(Long id);
	List<Marca> readAll();
}
