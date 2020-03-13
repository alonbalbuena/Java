package com.dawes.parte2;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.modelo.IngredientesVO;
import com.dawes.modelo.RecetaIngredientesVO;
import com.dawes.modelo.RecetaVO;
import com.dawes.serviciosImpl.ServicioIngredientesImpl;
import com.dawes.serviciosImpl.ServicioRecetaImpl;
import com.dawes.serviciosImpl.ServicioRecetaIngredientes;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testParte2 {

	private static ServicioIngredientesImpl servicioIngredientes;
	private static ServicioRecetaImpl servicioRecetas;
	private static ServicioRecetaIngredientes servicioRecetaIngredientes;
	private static IngredientesVO ingrediente;
	private static RecetaVO receta;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		// conexiones necesarias para hacer los test
		servicioIngredientes = new ServicioIngredientesImpl();
		servicioRecetas = new ServicioRecetaImpl();
		servicioRecetaIngredientes = new ServicioRecetaIngredientes();

		// creamos objetos con id pero NO harian falta porque estan TODOS los metodos
		// programados
		// los creo simplemente para comprobarlo todo de una con los mismo objetos

		//PROBAMOS CON id 50 en los dos casos
		ingrediente = new IngredientesVO(50,"platano", "hidratos");
		receta = new RecetaVO(50,"platano con mantequilla", "platano recubierto de mantequilla de cacahuete",
				LocalDate.now(), "Postre");
	}

	@Test
	public void test1InsertarIngrediente() {
		assertEquals(1, servicioIngredientes.insertarIngrediente(ingrediente));
	}

	@Test
	public void test2InsertarRecetas() {
		assertEquals(1, servicioRecetas.crearReceta(receta));
	}

	@Test 
	public void test3AsignarIngrediente() { 
	  
	  // creamos una relacion entre las dos
	  RecetaIngredientesVO relacionPrueba = new RecetaIngredientesVO(200, receta, ingrediente);
	  
	  //probamos assertEquals
	  assertEquals(1,servicioRecetaIngredientes.insertarRelacion(relacionPrueba, ingrediente, receta)); 
	  
	  //NO ME FUNCIONA LA RELACION
	  //PERO EL TEST DE MOSTRAR DEBERIA DE FUNCIONAR PERFECTAMENTE
	  }

	@Test
	public void test4MostrarRecetasPorIngrediente() {
		//buscaremos por el ingredienete platano creado e insertado mas arriba

		// lo buscamos y mostramos
		System.out.println(servicioRecetas.mostrarRecetasPorIngrediente(ingrediente));
	}

}
