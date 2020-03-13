package com.dawes.servicios;

import java.util.List;

import com.dawes.modelo.CocheVO;

public interface ServicioCoche {
	//como solo vamos a insertar un coche y actualizar, solo necesitamos 
	//1- buscar por nombre 
	CocheVO buscarPorMatricula(String matricula);
	//2-insertar
	int insertar(CocheVO coche);
	
	int actualizarPorMatricula(CocheVO coche);
	
	List<CocheVO> obtenerTodos();
	
	List<Object[]> cocheDia();
}
