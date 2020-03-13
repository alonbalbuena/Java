package com.dawes.DAOImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import com.dawes.modelo.LineasVO;
import com.dawes.serviciosImpl.ServicioLineasImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class testLineaDAOImpl {

	private static ServicioLineasImpl servicioLineas;
	private static LineasVO linea;

	@BeforeAll
	static void setUpBeforeClass() {
		servicioLineas = new ServicioLineasImpl();
		linea = new LineasVO("1", "linea cabueñes-calzada", LocalDate.parse("2007-10-10"));
	}

	@Test
	void test1Insertar() {
		assertEquals(1, servicioLineas.crearLinea(linea));
	}

	@Test
	void test2Modificar() {
		assertEquals(1, servicioLineas.actualizarLinea(linea));
	}

	@Test
	void test6BorrarInt() {
		assertEquals(1, servicioLineas.borrarLinea(1));
	}

	@Test
	void test7BorrarLineasVO() {
		assertEquals(1, servicioLineas.borrarLinea(linea));
	}

	@Test
	void test3LeerIgualInt() {
		assertNotNull(servicioLineas.buscarLinea(1));
	}

	@Test
	void test4LeerTodos() {
		assertNotNull(servicioLineas.mostrarLineas());
	}

	@Test
	void test5LeerIgualString() {
		assertNotNull(servicioLineas.buscarLinea(linea.getDenCorta()));
	}

}
