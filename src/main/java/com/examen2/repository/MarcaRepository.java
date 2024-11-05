package com.examen2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen2.entity.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
