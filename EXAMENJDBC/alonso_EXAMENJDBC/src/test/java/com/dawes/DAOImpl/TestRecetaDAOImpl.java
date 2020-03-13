package com.dawes.DAOImpl;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dawes.modelo.RecetaVO;
import com.dawes.serviciosImpl.ServicioRecetaImpl;

public class TestRecetaDAOImpl {
	
	static ServicioRecetaImpl servicioReceta;
	private static RecetaVO recetaSinId;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		servicioReceta = new ServicioRecetaImpl();
		recetaSinId = new RecetaVO("tostadas con memelada", "pan tostado con mermelada de fresa", LocalDate.now(), "desayuno");
	}

	@Test
	public void testInsertar() {
		assertEquals(1, servicioReceta.crearReceta(recetaSinId));
	}

}
