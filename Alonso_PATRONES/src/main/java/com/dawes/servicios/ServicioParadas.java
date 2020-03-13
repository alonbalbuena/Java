package com.dawes.servicios;

import java.util.Set;

import com.dawes.modelo.ParadasVO;


public interface ServicioParadas {
	int crearParada(ParadasVO parada);

	int borrarParada(ParadasVO parada);

	int borrarParada(int idParada);

	int actualizarParada(ParadasVO parada);

	ParadasVO buscarParada(String denominacion);

	ParadasVO buscarParada(int idParada);

	Set<ParadasVO> mostrarParadas();
}
