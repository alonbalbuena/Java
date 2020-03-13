package com.dawes.util;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.modelo.LineaVO;
import com.dawes.modelo.ParadaVO;
import com.dawes.servicio.ServicioLineas;
import com.dawes.servicio.ServicioLineasParadas;
import com.dawes.servicio.ServicioParadas;
import com.dawes.servicioImpl.ServicioLineasImpl;
import com.dawes.servicioImpl.ServicioLineasParadasImpl;
import com.dawes.servicioImpl.ServicioParadasImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLineas {

	static ServicioLineas sl;
	
	
	@BeforeClass
	public static void antesdelaclase() {
		sl=new ServicioLineasImpl();
	
	}
	
	@Test
	public void t1persistLinea() {
		assertEquals(1,sl.insertar(new LineaVO("3","Ceares-Pumarin",LocalDate.now(),null)));
		assertEquals(1,sl.insertar(new LineaVO("4","Pumarin-La Providencia",LocalDate.now(),null)));
	}
	
	
	// al eliminar una linea debe eliminar en cascada todas sus paradas
	@Test
	public void t2eliminarLinea() {
		assertEquals(1,sl.eliminar(sl.buscarPorNombre("1")));
	}
	
	@Test
	public void t3paradasDeUnaLinea() {
		assertEquals(1,sl.buscarPorNombre("2").getParadas().size());
	}
	
	@Test
	public void t4modificarLinea() {
		LineaVO l=sl.buscarPorNombre("4");
		l.setDenlarga("Pumarin alto");
		assertEquals("Pumarin alto",sl.buscarPorNombre("4").getDenlarga());
	}
	
	// todas las paradas de una linea
	@Test 
	public void t5Objetivo5(){
		System.out.println("Paradas de la linea 2:");
		sl.buscarPorNombre("2").getParadas().forEach(x->System.out.println(x.getParada().getDenominacion()));
		assertEquals(1,sl.buscarPorNombre("2").getParadas().size());
		
	}
	// correspondencias de una linea en una parada
	@Test
	public void t6Objetivo7() {
		System.out.println("Correspondencias de la linea 2 en la parada GCC");
		sl.buscarPorNombre("2").getParadas().forEach(x->{
			if(!x.getParada().getDenominacion().equals("GCC"))
				System.out.println(x.getLinea().getDencorta());
		});
	
	}
}
