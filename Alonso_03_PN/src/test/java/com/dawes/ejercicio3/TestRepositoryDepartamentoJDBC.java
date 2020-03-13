package com.dawes.ejercicio3;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.ejercicio2.Departamentos;
import com.dawes.ejercicio3.repositorio.DepartamentoRepository;
import com.dawes.ejercicio3.util.MySqlDAOFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRepositoryDepartamentoJDBC {

	private static MySqlDAOFactory f;
	private static DepartamentoRepository departamentoRepository;
	private static Departamentos departamentoPrueba;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		f = new MySqlDAOFactory();
		departamentoRepository = f.getDepartamentoRepositoryJDBC();
		departamentoPrueba = new Departamentos("i+D","Gijón");
	}

	@Test
	public void test1Insertar() {
		assertNotNull(departamentoRepository.insertar(departamentoPrueba));
	}
	@Test
	public void test2LeerIgual() {
		assertNotNull(departamentoRepository.leerIgual("i+D"));
	}
	
	@Test
	public void test3LeerTodos() {
		assertNotNull(departamentoRepository.leerTodos());
	}

	@Test
	public void test4Eliminar() {
		assertNotNull(departamentoRepository.eliminar(departamentoPrueba));
	}

	@Test
	public void test5Modificar() {
		fail("Not yet implemented");
	}
}
