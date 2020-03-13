package com.dawes.DAO;

import java.util.Set;

import com.dawes.modelo.ParadasVO;

public interface ParadasDAO {
	
	int insertar(ParadasVO parada);
	int borrar(ParadasVO parada);
	int borrar(int idParada);
	int modificar(ParadasVO parada);
	ParadasVO leerIgual(int idParada);
	ParadasVO leerIgual(String denominacion);
	Set<ParadasVO> leerTodos();

}
