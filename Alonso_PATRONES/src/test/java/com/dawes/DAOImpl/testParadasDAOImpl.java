package com.dawes.DAOImpl;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.modelo.ParadasVO;
import com.dawes.serviciosImpl.ServicioParadasImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testParadasDAOImpl {

	private static ServicioParadasImpl servicioParadas;
	private static ParadasVO parada;

	@BeforeClass
	public static void setUpBeforeClass(){
		servicioParadas = new ServicioParadasImpl();
		parada = new ParadasVO( "humedal", LocalDate.parse("2007-10-10"));
	}

	@Test
	public void test1Insertar() {
		assertEquals(1,servicioParadas.crearParada(parada));
	}

	@Test
	public void test6BorrarParadasVO() {
		assertEquals(1, servicioParadas.borrarParada(parada));
	}

	@Test
	public void test2Modificar() {
		assertEquals(1,servicioParadas.actualizarParada(parada));
	}

	@Test
	public void test3LeerIgualInt() {
		assertNotNull(servicioParadas.buscarParada(1));
	}

	@Test
	public void test5LeerTodos() {
		assertNotNull(servicioParadas.mostrarParadas());
	}

	@Test
	public void test7BorrarInt() {
		assertEquals(1, servicioParadas.borrarParada(1));
	}

	@Test
	public void test4LeerIgualString() {
		assertNotNull(servicioParadas.buscarParada(parada.getDenominacion()));
	}

}
