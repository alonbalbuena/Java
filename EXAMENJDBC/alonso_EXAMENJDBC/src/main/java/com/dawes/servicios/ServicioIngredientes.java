package com.dawes.servicios;

import java.util.Set;

import com.dawes.modelo.IngredientesVO;

public interface ServicioIngredientes {

	int insertarIngrediente(IngredientesVO ingredienteSinId);
	int borrarIngrediente(int idIngredientes);
	int borrarIngrediente(String nombre);
	int modificarIngrediente(IngredientesVO ingredienteConId);
	IngredientesVO mostrarIngrediente(int idIngredientes);
	IngredientesVO mostrarIngrediente(String nombreIngrediente);
	Set< IngredientesVO> mostrarTodo();
}
