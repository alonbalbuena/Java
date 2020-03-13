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
public class TestLineasParadas {

	static ServicioLineas sl;
	static ServicioParadas sp;
	static ServicioLineasParadas slp;
	
	@BeforeClass
	public static void antesdelaclase() {
		
		slp=new ServicioLineasParadasImpl();
	}
	
	
	
	@Test
	public void t1asignarParadaALinea() {
	
		assertEquals(1,slp.asignarParadaALinea("2", "Laboral", 1));
		
	
	}
	

}
