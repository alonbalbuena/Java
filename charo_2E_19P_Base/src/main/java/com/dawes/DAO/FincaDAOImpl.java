package com.dawes.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dawes.modelo.FincaVO;

public class FincaDAOImpl {
	
	@Autowired
	FincaDAO fd;

	public <S extends FincaVO> S save(S entity) {
		return fd.save(entity);
	}

	public Optional<FincaVO> findById(Integer id) {
		return fd.findById(id);
	}

	public Iterable<FincaVO> findAll() {
		return fd.findAll();
	}

}
