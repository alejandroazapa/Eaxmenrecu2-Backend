package com.examen2.dao;

import java.util.List;
import java.util.Optional;

import com.examen2.entity.Tipo;

public interface TipoDao {
	Tipo create(Tipo c);
	Tipo update(Tipo c);
	void delete(Long id);
	Optional<Tipo> read(Long id);
	List<Tipo> readAll();
}
