package com.examen2.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.examen2.dao.CocheDao;
import com.examen2.entity.Coche;
import com.examen2.repository.CocheRepository;

@Component
public class CocheDaoImpl implements CocheDao{
	@Autowired
	private CocheRepository CocheRepository;
	
	@Override
	public Coche create(Coche c) {
		// TODO Auto-generated method stub
		return CocheRepository.save(c);
	}

	@Override
	public Coche update(Coche c) {
		// TODO Auto-generated method stub
		return CocheRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		CocheRepository.deleteById(id);
	}

	@Override
	public Optional<Coche> read(Long id) {
		// TODO Auto-generated method stub
		return CocheRepository.findById(id);
	}

	@Override
	public List<Coche> readAll() {
		// TODO Auto-generated method stub
		return CocheRepository.findAll();
	}
}
