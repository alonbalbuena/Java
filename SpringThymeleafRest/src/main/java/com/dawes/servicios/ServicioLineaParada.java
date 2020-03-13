package com.dawes.servicios;

import com.dawes.modelo.LineaParadaVO;

public interface ServicioLineaParada {

	void deleteById(int id);
	<S extends LineaParadaVO> S save(S entity);
}