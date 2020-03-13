package com.dawes.servicios;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dawes.modelo.AlumnoCursoVO;
import com.dawes.repositorio.AlumnoCursoRepository;

public class ServicioAlumnoCursoImpl {

	@Autowired
	AlumnoCursoRepository acr;

	public <S extends AlumnoCursoVO> S save(S entity) {
		return acr.save(entity);
	}

	public Optional<AlumnoCursoVO> findById(Integer id) {
		return acr.findById(id);
	}

	public Iterable<AlumnoCursoVO> findAll() {
		return acr.findAll();
	}

	public void delete(AlumnoCursoVO entity) {
		acr.delete(entity);
	}

	public void deleteAll() {
		acr.deleteAll();
	}

	public int deleteByFechaBetween(LocalDate fechaInicial, LocalDate fechaFinal) {
		return acr.deleteByFechaBetween(fechaInicial, fechaFinal);
	}
	
	
}
