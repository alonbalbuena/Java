package com.dawes.DAOImpl;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dawes.modelo.IngredientesVO;
import com.dawes.serviciosImpl.ServicioIngredientesImpl;

public class TestIngredientesDAOImpl {

	private static IngredientesVO ingredientePrueba;
	private static ServicioIngredientesImpl servicioIngredientes;

	@BeforeClass
	public static void setUpBeforeClass() {
		//creamos la conexion
		servicioIngredientes = new ServicioIngredientesImpl();
		
		//creamos un ingrediente de prueba para insertar
		ingredientePrueba = new IngredientesVO("test", "proteina");
	}

	@Test
	public void test1Insertar() {
		//si el metodo funciona devuelve 1
		assertEquals(1,servicioIngredientes.insertarIngrediente(ingredientePrueba));
	}

}
