package com.dawes.DAO;

import com.dawes.modelo.CocheVO;

public interface CocheDAO {

	//como solo vamos a insertar un coche y actualizar, solo necesitamos 
	//1- buscar por nombre 
	CocheVO buscarPorMatricula(String matricula);
	//2-insertar
	int insertar(CocheVO coche);
	
	int actualizarPorMatricula(CocheVO coche);
}
