package com.dawes.DAO;

import java.util.Set;

import com.dawes.modelo.IngredientesVO;
import com.dawes.modelo.RecetaIngredientesVO;
import com.dawes.modelo.RecetaVO;

public interface RecetaIngredientesDAO {
	int insertar(RecetaIngredientesVO relacionSinId,IngredientesVO ingredienteConID,RecetaVO recetaConID);
	int borrar(int idRecetaIngredientes);
	int modificar(RecetaIngredientesVO relacionConId);
	RecetaIngredientesVO leerIgual(int idRecetaIngrediente);
	Set<RecetaIngredientesVO> leerTodo();
}
