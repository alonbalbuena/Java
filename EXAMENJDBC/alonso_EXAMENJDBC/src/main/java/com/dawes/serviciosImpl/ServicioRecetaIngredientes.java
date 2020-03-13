package com.dawes.serviciosImpl;

import java.util.Set;

import com.dawes.DAOImpl.RecetaIngredientesDAOImpl;
import com.dawes.modelo.IngredientesVO;
import com.dawes.modelo.RecetaIngredientesVO;
import com.dawes.modelo.RecetaVO;
import com.dawes.servicios.ServicioRecetaIngrediente;
import com.dawes.util.MySQLFactory;

public class ServicioRecetaIngredientes implements ServicioRecetaIngrediente {

	// cada vez que hagamos una administracion de esta tabla solo llamaremos al
	// singleton
	// con este constructor
	private RecetaIngredientesDAOImpl ri;
	public ServicioRecetaIngredientes() {
		//llamo al singleton para confirmar la creacion de una SOLA conexion 
		//y llamo a la tabla correspondiente
		ri = MySQLFactory.getDAO().getRecetaIngredientes();
	}

	public int insertarRelacion(RecetaIngredientesVO relacionSinId,IngredientesVO ingredienteConID,RecetaVO recetaConID) {
		return ri.insertar(relacionSinId, ingredienteConID, recetaConID);
	}

	public int borrarRelacion(int idRecetaIngredientes) {
		return ri.borrar(idRecetaIngredientes);
	}

	public int modificarRelacion(RecetaIngredientesVO relacionConId) {
		return ri.modificar(relacionConId);
	}

	public RecetaIngredientesVO mostrarRelacion(int idRecetaIngrediente) {
		return ri.leerIgual(idRecetaIngrediente);
	}

	public Set<RecetaIngredientesVO> mostrarTodo() {
		return ri.leerTodo();
	}

}
