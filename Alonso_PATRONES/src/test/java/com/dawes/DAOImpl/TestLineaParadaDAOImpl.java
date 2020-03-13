package com.dawes.DAOImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import com.dawes.modelo.LineaParadaVO;
import com.dawes.modelo.LineasVO;
import com.dawes.modelo.ParadasVO;
import com.dawes.serviciosImpl.ServicioLineaParadaImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestLineaParadaDAOImpl {

	private static ServicioLineaParadaImpl servicioLineaParada;
	private static LineaParadaVO lineaParada;
	private static ParadasVO parada;
	private static LineasVO linea;

	@BeforeAll
	static void setUpBeforeClass(){
		
		servicioLineaParada = new ServicioLineaParadaImpl();
		
		linea = new LineasVO("1", "cabueñes-calzada", LocalDate.parse("2007-10-10"));
		parada = new ParadasVO("humedal", LocalDate.parse("2007-10-10"));
		
		lineaParada = new LineaParadaVO(linea,parada, 2);//marquesina numero 2
	}

	@Test
	void test1Insertar() {
		assertEquals(1, servicioLineaParada.crearLineaParada(lineaParada));
	}

	@Test
	void test7BorrarLineaParadaVO() {
		assertEquals(1, servicioLineaParada.borrarLineaParada(lineaParada));
	}

	@Test
	void test2Modificar() {
		assertEquals(1, servicioLineaParada.actualizarLineaParada(lineaParada));
	}

	@Test
	void test3LeerIgualInt() {
		assertNotNull(servicioLineaParada.buscarLineaParada(1));
	}

	@Test
	void test4LeerTodos() {
		assertNotNull(servicioLineaParada.mostrarLineasParadas());
	}

	@Test
	void test6BorrarInt() {
		assertEquals(1, servicioLineaParada.borrarLineaParada(1));
	}

	@Test
	void test5LeerIgualString() {
		assertNotNull(servicioLineaParada.buscarLineaParadaPorMarquesina(2));
	}

}
