package com.dawes.servicios;

import java.util.HashSet;
import java.util.Set;

import com.dawes.modelo.IngredientesVO;
import com.dawes.modelo.RecetaVO;

public interface ServicioReceta {
	int crearReceta(RecetaVO recetaSinId);
	int borrarReceta(int idReceta);
	int borrarReceta(String nombreReceta);
	int modificarReceta(RecetaVO recetaConId);
	RecetaVO mostrarReceta(int idReceta);
	RecetaVO mostrarReceta(String nombreReceta);
	Set<RecetaVO> mostrarTodo();
	HashSet<RecetaVO> mostrarRecetasPorIngrediente(IngredientesVO ingrediente);
}
