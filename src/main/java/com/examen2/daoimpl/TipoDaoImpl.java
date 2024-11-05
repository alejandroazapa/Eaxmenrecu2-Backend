package com.examen2.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.examen2.dao.TipoDao;
import com.examen2.entity.Tipo;
import com.examen2.repository.TipoRepository;

@Component
public class TipoDaoImpl implements TipoDao{

	@Autowired
	private TipoRepository TipoRepository;
	
	@Override
	public Tipo create(Tipo c) {
		// TODO Auto-generated method stub
		return TipoRepository.save(c);
	}

	@Override
	public Tipo update(Tipo c) {
		// TODO Auto-generated method stub
		return TipoRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		TipoRepository.deleteById(id);
	}

	@Override
	public Optional<Tipo> read(Long id) {
		// TODO Auto-generated method stub
		return TipoRepository.findById(id);
	}

	@Override
	public List<Tipo> readAll() {
		// TODO Auto-generated method stub
		return TipoRepository.findAll();
	}
}
