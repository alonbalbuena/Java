package com.dawes.test;

import static org.junit.Assert.*;

import com.dawes.Aplicacion.*;
import org.junit.BeforeClass;
import org.junit.Test;
public class Aplicacion {
	
	private static Curso aplicacion;
	
	@BeforeClass
	public static void antes() {
		aplicacion = new Curso();
	}
	
	@Test
	public void testConsultaAñosProfesor() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultarCiclos() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultarProfesores() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultarTodo() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCiclo() {
		aplicacion.addCiclo("lengua", "lengua y literatura");
		assertEquals(1,aplicacion.getCiclos().size());
	}

	@Test
	public void testAddProfesor() {
		fail("Not yet implemented");
	}

	@Test
	public void testRelacionar() {
		fail("Not yet implemented");
	}

}
