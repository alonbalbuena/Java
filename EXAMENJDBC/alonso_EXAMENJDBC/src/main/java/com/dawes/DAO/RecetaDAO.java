package com.dawes.DAO;

import java.util.HashSet;
import java.util.Set;

import com.dawes.modelo.IngredientesVO;
import com.dawes.modelo.RecetaVO;

public interface RecetaDAO {
	int insertar(RecetaVO recetaSinId);
	int borrar(int idReceta);
	int borrar(String nombreReceta);
	int modificar(RecetaVO recetaConId);
	RecetaVO leerIgual(int idReceta);
	RecetaVO leerIgual(String nombreReceta);
	Set<RecetaVO> leerTodo();
	HashSet<RecetaVO> mostrarRecetasPorIngrediente(IngredientesVO ingrediente);
}
