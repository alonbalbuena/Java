package com.dawes.DAOImpl;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dawes.modelo.IngredientesVO;
import com.dawes.modelo.RecetaIngredientesVO;
import com.dawes.modelo.RecetaVO;
import com.dawes.serviciosImpl.ServicioRecetaIngredientes;

public class TestRecetaIngredienteDAOImpl {

	private static RecetaIngredientesVO relacionPrueba;
	private static ServicioRecetaIngredientes servicioRecetaIngredientes;
	private static RecetaVO recetaConId;
	private static IngredientesVO ingredienteConId;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// creamos la conexion
		servicioRecetaIngredientes = new ServicioRecetaIngredientes();

		// creamos un ingrediente de prueba
		ingredienteConId = new IngredientesVO("test", "proteina");
		//creamos una receta de prueba
		recetaConId = new RecetaVO("tostadas con memelada", "pan tostado con mermelada de fresa", LocalDate.now(), "desayuno");

		
		//creamos una relacion entre las dos
		relacionPrueba = new RecetaIngredientesVO(200, recetaConId, ingredienteConId);
	}

	@Test
	public void testInsertar() {
		//probamos
		assertEquals(1, servicioRecetaIngredientes.insertarRelacion(relacionPrueba, ingredienteConId, recetaConId));
	}

}
