package com.dawes.DAOImpl;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dawes.serviciosImpl.ServicioLineasImpl;

public class TestEmtusa {

	private static ServicioLineasImpl servicioLineas;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		servicioLineas = new ServicioLineasImpl();
	}

	@Test
	public void testLeerComplejo() {
		//devuelve todas las paradas de una linea
		assertEquals(1, servicioLineas.buscarCompleja("1"));
	}
	

}
