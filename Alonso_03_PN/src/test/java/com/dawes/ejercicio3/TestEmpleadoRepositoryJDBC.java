package com.dawes.ejercicio3;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.ejercicio2.Departamentos;
import com.dawes.ejercicio2.Empleados;
import com.dawes.ejercicio3.repositorio.EmpleadoRepository;
import com.dawes.ejercicio3.util.MySqlDAOFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestEmpleadoRepositoryJDBC {

	static private EmpleadoRepository empleadoRepository;
	static private MySqlDAOFactory f;
	static private Empleados empleadoEjemplo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		f = new MySqlDAOFactory();
		empleadoRepository = f.getEmpleadoRepositoryJDBC();
		empleadoEjemplo = new Empleados("alonso", "53646496p", 1516, "18/10/2019", new Departamentos(0, "DAWES", "gijon"));
	}

	@Test
	public void test1Insertar() {
		assertNotNull(empleadoRepository.insertar(empleadoEjemplo));
	}

	@Test
	public void test2leerIgual() {
		assertNotNull(empleadoRepository.leerIgual("53646496P"));
	}
	
	@Test
	public void test3leerTodos() {
		assertNotNull(empleadoRepository.leerTodos());
	}

	@Test
	public void test4Eliminar() {
		assertNotNull(empleadoRepository.eliminar(empleadoEjemplo));
	}
}
