package com.dawes.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FincaVO;

public class ArbolDAOImpl {

	@Autowired
	ArbolDAO ad;

	public <S extends ArbolVO> S save(S entity) {
		return ad.save(entity);
	}

	public Optional<ArbolVO> findById(Integer id) {
		return ad.findById(id);
	}

	public Iterable<ArbolVO> findAll() {
		return ad.findAll();
	}

	public ArbolVO findByFilaAndColumnaAndFinca(Integer fila, Integer columna, Integer finca) {
		return ad.findByFilaAndColumnaAndFinca(fila, columna, finca);
	}

	
	
}
