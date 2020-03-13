package com.dawes.servicios;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dawes.modelos.FincaVO;
import com.dawes.serviciosImpl.ServicioFincasImpl;

public class TestServicioFincasImpl {

	private static ServicioFincasImpl servicioFincas;

	@BeforeClass
	public static void setUpBeforeClass() {
		servicioFincas = new ServicioFincasImpl();
	}

	@Test
	public void testInsertarFinca() {
		FincaVO finca = new FincaVO("finca");
		servicioFincas.insertarFinca(finca);
	}

	@Test
	public void testActualizarFinca() {
		
	}

	@Test
	public void testBorrarFinca() {
		
	}

	@Test
	public void testBorrarFincaID() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarFinca() {
		fail("Not yet implemented");
	}

	@Test
	public void testMostrarFincas() {
		fail("Not yet implemented");
	}

}
