package com.dawes.util;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.modelo.LineaVO;
import com.dawes.modelo.ParadaVO;
import com.dawes.servicio.ServicioParadas;
import com.dawes.servicioImpl.ServicioParadasImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestParadas {

	static ServicioParadas sp;

	@BeforeClass
	public static void antesdelaclase() {

		sp = new ServicioParadasImpl();

	}

	@Test
	public void t1persistParada() {
		assertEquals(1, sp.insertar(new ParadaVO("Humedal", LocalDate.now(), null)));
		assertEquals(1, sp.insertar(new ParadaVO("Uria", LocalDate.now(), null)));
	}

	@Test
	public void t2paradasDeUnaLinea() {
		assertEquals(2, sp.buscarPorNombre("GCC").getLineas().size());
	}

	@Test
	public void t3modificarParada() {
		ParadaVO l=sp.buscarPorNombre("Uria");
		l.setDenominacion("Calle Uria");
		assertEquals("Calle Uria",sp.buscarPorNombre("Uria").getDenominacion());
	}
	
	// lineas de una parada
	@Test
	public void t4objetivo6() {
		System.out.println("Lineas de la parada GCC");
		sp.buscarPorNombre("GCC").getLineas().forEach(x->System.out.println(x.getLinea().getDencorta()));
		assertEquals(2,sp.buscarPorNombre("GCC").getLineas().size());
	}
}
