package com.dawes.DAO;

import java.util.Set;

import com.dawes.modelo.LineaParadaVO;

public interface LineaParadaDAO {

	int insertar(LineaParadaVO lineaParada);
	int borrar(LineaParadaVO lineaParada);
	int borrar(int idLineaParada);
	int modificar(LineaParadaVO lineaParada);
	LineaParadaVO leerIgual(int lineaParada);
	LineaParadaVO leerIgualMarquesina(int marquesina);
	Set<LineaParadaVO> leerTodos();
}
