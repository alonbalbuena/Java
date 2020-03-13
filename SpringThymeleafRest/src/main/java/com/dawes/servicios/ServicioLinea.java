package com.dawes.servicios;

import java.util.Optional;

import com.dawes.modelo.LineaVO;

public interface ServicioLinea {

	LineaVO findByDencorta(String dencorta);
	LineaVO findByDenlarga(String denlarga);	
	<S extends LineaVO> S save(S entity);
	Optional<LineaVO> findById(Integer id);
	Iterable<LineaVO> findAll();
	void deleteById(Integer id);
	void delete(LineaVO entity);
	void deleteAll();
	LineaVO buscarParadasDeLinea(int idlinea);
	
}
