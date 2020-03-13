package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.LineaParadaVO;
import com.dawes.modelo.LineaVO;
import com.dawes.modelo.ParadaVO;
import com.dawes.repositorio.LineaRepository;
import com.dawes.repositorio.ParadaRepository;

@Service
public class ServicioParadaImpl implements ServicioParada{

	@Autowired
	ParadaRepository pr;
	
	@Autowired
	LineaRepository lr;

	
	public ParadaRepository getPr() {
		return pr;
	}
	public void setPr(ParadaRepository pr) {
		this.pr = pr;
	}
	
	@Override
	public ParadaVO findByDenominacion(String denominacion) {
		return pr.findByDenominacion(denominacion);
	}
	@Override
	public <S extends ParadaVO> S save(S entity) {
		return pr.save(entity);
	}
	@Override
	public Optional<ParadaVO> findById(Integer id) {
		return pr.findById(id);
	}
	@Override
	public Iterable<ParadaVO> findAll() {
		return pr.findAll();
	}
	@Override
	public void deleteById(Integer id) {
		pr.deleteById(id);
	}
	@Override
	public void delete(ParadaVO entity) {
		pr.delete(entity);
	}
	@Override
	public void deleteAll() {
		pr.deleteAll();
	}
	public List<ParadaVO> getParadasNoAñadidas(Integer idlinea) {
		return pr.getParadasNoAñadidas(idlinea);
	}
	
//	@Override
//	@Transactional
//	public void asignarALinea(int idLinea, int idParada, int marquesina) {
//		LineaVO l = lr.findById(idLinea).get();
//		ParadaVO p = pr.findById(idParada).get();
//		LineaParadaVO lp = new LineaParadaVO(l, p, marquesina);
//		l.addLineaParada(lp);
//		p.addLineaParada(lp);
//	}
	
	
}

