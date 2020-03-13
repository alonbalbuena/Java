package com.dawes.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dawes.modelo.CursoVO;
import com.dawes.repositorio.CursoRepository;

public class ServicioCursoImpl {

	@Autowired
	CursoRepository cr;

	public <S extends CursoVO> S save(S entity) {
		return cr.save(entity);
	}

	public Optional<CursoVO> findById(Integer id) {
		return cr.findById(id);
	}

	public Iterable<CursoVO> findAll() {
		return cr.findAll();
	}

	public void delete(CursoVO entity) {
		cr.delete(entity);
	}

	public void deleteAll() {
		cr.deleteAll();
	};
	
	
}
