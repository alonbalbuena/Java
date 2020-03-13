package com.dawes.servicios;

import java.util.Set;

import com.dawes.modelo.LineaParadaVO;

public interface ServicioLineaParada {
	int crearLineaParada(LineaParadaVO lineaParada);
	int borrarLineaParada(LineaParadaVO lineaParada);
	int borrarLineaParada(int idLineaParada);
	int actualizarLineaParada(LineaParadaVO lineaParada);
	LineaParadaVO buscarLineaParada(int idLineaParada);
	LineaParadaVO buscarLineaParadaPorMarquesina(int marquesina);
	Set<LineaParadaVO> mostrarLineasParadas();
}
