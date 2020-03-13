package com.dawes.ejercicio2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGestion {

	public static Gestion app;
	public static Departamentos departamento;
	
	@BeforeClass
	public static void antes() {
		app = new Gestion();
		departamento = new Departamentos("i+D","gijon");
	}
	
	@Test
	public void test1Conexion() {
		assertNotNull(app.getConexion());
	}
	
	@Test
	public void test2AddDepartamento() {
		assertEquals(1,app.addDepartamento(departamento));
	}
	
	@Test
	public void test3AddEmpleado() {
		assertEquals(1,app.addEmpleado(new Empleados("53646496p","alonso",800,"10/10/2010",departamento)));
	}
	

}
