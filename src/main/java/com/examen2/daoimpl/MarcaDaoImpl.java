package com.examen2.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.examen2.dao.MarcaDao;
import com.examen2.entity.Marca;
import com.examen2.repository.MarcaRepository;

@Component
public class MarcaDaoImpl implements MarcaDao{
	@Autowired
	private MarcaRepository MarcaRepository;
	
	@Override
	public Marca create(Marca c) {
		// TODO Auto-generated method stub
		return MarcaRepository.save(c);
	}

	@Override
	public Marca update(Marca c) {
		// TODO Auto-generated method stub
		return MarcaRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		MarcaRepository.deleteById(id);
	}

	@Override
	public Optional<Marca> read(Long id) {
		// TODO Auto-generated method stub
		return MarcaRepository.findById(id);
	}

	@Override
	public List<Marca> readAll() {
		// TODO Auto-generated method stub
		return MarcaRepository.findAll();
	}
}
