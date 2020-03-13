package com.dawes.serviciosImpl;

import java.sql.Connection;
import java.util.Set;

import com.dawes.DAOImpl.IngredientesDAOImpl;
import com.dawes.modelo.IngredientesVO;
import com.dawes.servicios.ServicioIngredientes;
import com.dawes.util.MySQLFactory;

public class ServicioIngredientesImpl implements ServicioIngredientes {

	// cada vez que hagamos una administracion de esta tabla solo llamaremos al
	// singleton
	// con este constructor
	private IngredientesDAOImpl si;

	public ServicioIngredientesImpl() {
		// llamo al singleton para confirmar la creacion de una SOLA conexion
		// y llamo a la tabla correspondiente
		si = MySQLFactory.getDAO().getIngredientes();
	}

	public int insertarIngrediente(IngredientesVO ingredienteSinId) {
		return si.insertar(ingredienteSinId);
	}

	public int borrarIngrediente(int idIngredientes) {
		return si.borrar(idIngredientes);
	}

	public int borrarIngrediente(String nombre) {
		return si.borrar(nombre);
	}

	public int modificarIngrediente(IngredientesVO ingredienteConId) {
		return si.modificar(ingredienteConId);
	}

	public IngredientesVO mostrarIngrediente(int idIngredientes) {
		return si.leerIgual(idIngredientes);
	}

	public IngredientesVO mostrarIngrediente(String nombreIngrediente) {
		return si.leerIgual(nombreIngrediente);
	}

	public Set<IngredientesVO> mostrarTodo() {
		return si.leerTodo();
	}

}
