package com.dawes.servicios;

import java.util.Set;

import com.dawes.modelo.IngredientesVO;
import com.dawes.modelo.RecetaIngredientesVO;
import com.dawes.modelo.RecetaVO;

public interface ServicioRecetaIngrediente {
	int insertarRelacion(RecetaIngredientesVO relacionSinId,IngredientesVO ingredienteConID,RecetaVO recetaConID);
	int borrarRelacion(int idRecetaIngredientes);
	int modificarRelacion(RecetaIngredientesVO relacionConId);
	RecetaIngredientesVO mostrarRelacion(int idRecetaIngrediente);
	Set<RecetaIngredientesVO> mostrarTodo();
}
