package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.ParadaVO;

public interface ServicioParada {

	ParadaVO findByDenominacion(String denominacion);
	<S extends ParadaVO> S save(S entity);
	Optional<ParadaVO> findById(Integer id);
	Iterable<ParadaVO> findAll();
	void deleteById(Integer id);
	void delete(ParadaVO entity);
	void deleteAll();
	List<ParadaVO> getParadasNoAñadidas(Integer idlinea);
	
	//void asignarALinea(int idLinea, int idParada, int marquesina);
	
}
