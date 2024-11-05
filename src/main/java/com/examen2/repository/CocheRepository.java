package com.examen2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen2.entity.Coche;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long>{

}
