package com.dawes.DAO;

import java.util.Set;

import com.dawes.modelo.IngredientesVO;

public interface IngredientesDAO {
	int insertar(IngredientesVO ingredienteSinId);
	int borrar(int idIngredientes);
	int borrar(String nombre);
	int modificar(IngredientesVO ingredienteConId);
	IngredientesVO leerIgual(int idIngredientes);
	IngredientesVO leerIgual(String nombreIngrediente);
	Set< IngredientesVO> leerTodo();
}
