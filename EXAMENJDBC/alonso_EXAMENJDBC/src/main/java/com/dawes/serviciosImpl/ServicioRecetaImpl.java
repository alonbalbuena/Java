package com.dawes.serviciosImpl;

import java.util.HashSet;
import java.util.Set;

import com.dawes.DAOImpl.RecetaDAOImpl;
import com.dawes.modelo.IngredientesVO;
import com.dawes.modelo.RecetaVO;
import com.dawes.servicios.ServicioReceta;
import com.dawes.util.MySQLFactory;

public class ServicioRecetaImpl implements ServicioReceta {

	// cada vez que hagamos una administracion de esta tabla solo llamaremos al
	// singleton
	// con este constructor
	private RecetaDAOImpl sr;

	public ServicioRecetaImpl() {
		// llamo al singleton para confirmar la creacion de una SOLA conexion
		// y llamo a la tabla correspondiente
		sr = MySQLFactory.getDAO().getReceta();
	}

	public int crearReceta(RecetaVO recetaSinId) {
		return sr.insertar(recetaSinId);
	}

	public int borrarReceta(int idReceta) {
		return sr.borrar(idReceta);
	}

	public int borrarReceta(String nombreReceta) {
		return sr.borrar(nombreReceta);
	}

	public int modificarReceta(RecetaVO recetaConId) {
		return sr.modificar(recetaConId);
	}

	public RecetaVO mostrarReceta(int idReceta) {
		return sr.leerIgual(idReceta);
	}

	public RecetaVO mostrarReceta(String nombreReceta) {
		return sr.leerIgual(nombreReceta);
	}

	public Set<RecetaVO> mostrarTodo() {
		return sr.leerTodo();
	}

	public HashSet<RecetaVO> mostrarRecetasPorIngrediente(IngredientesVO ingrediente){
		return sr.mostrarRecetasPorIngrediente(ingrediente)	;
	}

}
