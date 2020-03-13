package com.dawes.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.LineaParadaVO;
import com.dawes.repositorio.LineaParadaRepository;

@Service
public class ServicioLineaParadaImpl implements ServicioLineaParada {
	@Autowired
	LineaParadaRepository lpr;

	@Override
	public void deleteById(int id) {
		lpr.deleteById(id);
	}

	public <S extends LineaParadaVO> S save(S entity) {
		return lpr.save(entity);
	}
	

}
