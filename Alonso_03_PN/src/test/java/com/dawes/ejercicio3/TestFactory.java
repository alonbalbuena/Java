package com.dawes.ejercicio3;

import static org.junit.Assert.assertNotNull;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.dawes.ejercicio3.repositorio.DepartamentoRepository;
import com.dawes.ejercicio3.util.MySqlDAOFactory;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestFactory {

	static MySqlDAOFactory f;
	static DepartamentoRepository dr;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		f =new MySqlDAOFactory();
	}

	@Test
	public void test1MySqlDAOFactory() {
		assertNotNull(f.getConexion());
	}

	@Test
	public void test2GetDepartamentoRepositoryJDBC() {
		assertNotNull(f.getDepartamentoRepositoryJDBC());
	}

	@Test
	public void test3GetEmpleadoRepositoryJDBC() {
		assertNotNull(f.getEmpleadoRepositoryJDBC());
	}

}
