package com.dawes.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.LineaVO;
import com.dawes.repositorio.LineaRepository;

@Service
public class ServicioLineaImpl implements ServicioLinea{
	
	@Autowired
	LineaRepository lr;

	public LineaRepository getLr() {
		return lr;
	}
	public void setLr(LineaRepository lr) {
		this.lr = lr;
	}
	
	@Override
	public LineaVO findByDencorta(String dencorta) {
		return lr.findByDencorta(dencorta);
	}
	@Override
	public LineaVO findByDenlarga(String denlarga) {
		return lr.findByDenlarga(denlarga);
	}
	@Override
	public <S extends LineaVO> S save(S entity) {
		return lr.save(entity);
	}
	@Override
	public Optional<LineaVO> findById(Integer id) {
		return lr.findById(id);
	}
	@Override
	public Iterable<LineaVO> findAll() {
		return lr.findAll();
	}
	@Override
	public void deleteById(Integer id) {
		lr.deleteById(id);
	}
	@Override
	public void delete(LineaVO entity) {
		lr.delete(entity);
	}
	@Override
	public void deleteAll() {
		lr.deleteAll();
	}
	public LineaVO buscarParadasDeLinea(int idlinea) {
		return lr.buscarParadasDeLinea(idlinea);
	}	

}

