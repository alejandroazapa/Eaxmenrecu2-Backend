package com.examen2.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen2.dao.MarcaDao;
import com.examen2.entity.Marca;
import com.examen2.service.MarcaService;

@Service
public class MarcaServiceImpl implements MarcaService{
	@Autowired
	private MarcaDao dao; 
	
	@Override
	public Marca create(Marca c) {
		// TODO Auto-generated method stub
		return dao.create(c);
	}

	@Override
	public Marca update(Marca c) {
		// TODO Auto-generated method stub
		return dao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Optional<Marca> read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Marca> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}
}
