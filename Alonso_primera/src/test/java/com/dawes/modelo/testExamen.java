package com.dawes.modelo;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.servicioImpl.ServicioCocheImpl;
import com.dawes.servicioImpl.ServicioReparacionImpl;
 
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testExamen {

	private static ServicioCocheImpl servicioCoche;
	private static ServicioReparacionImpl servicioReparacion;

	@BeforeClass
	public static void antes() {
		//llamamos a los servicios necesarios
		servicioCoche = new ServicioCocheImpl();
		
		servicioReparacion = new ServicioReparacionImpl();
	}
	
	@Test
	public void test1ActualizarCoche() {
		//creamos un coche(sin reparaciones ,de momento)
		CocheVO coche = new CocheVO("12345", "Paco");
		//lo insertamos
		servicioCoche.insertar(coche);
		
		//ejecutamos la actualizacion, que nos cambiara el propietario a "propietario Actualizado"
		//para evitar n+1 consultas (busca el coche puesto para luego actualizarlo)
		servicioCoche.actualizarPorMatricula(coche);
		
		//comprobamos si se ha ejecutado esta actualizacion
		assertEquals("propietarioActualizado", servicioCoche.buscarPorMatricula("12345").getPropietario());
	}
	
	@Test
	public void test2asignarTresReparaciones() {
		//Creamos primero el coche que le introduciremos las reparaciones
		CocheVO coche = new CocheVO("98765","Manolo");
		
		//creamos las reparaciones antes de insertarlas
		ReparacionVO reparacion1 = new ReparacionVO(1200,LocalDate.now(), coche);
		ReparacionVO reparacion2 = new ReparacionVO(300,LocalDate.now(), coche);
		ReparacionVO reparacion3 = new ReparacionVO(400,LocalDate.now(), coche);
		
		//añadimos las reparaciones al coche
		coche.getReparacion().add(reparacion1);
		coche.getReparacion().add(reparacion2);
		coche.getReparacion().add(reparacion3);
		
		//introducimos el coche (si devuelve 1 funciono)
		assertEquals(1, servicioCoche.insertar(coche));
	}

	@Test
	public void test3reparacionesCoche() {
		//buscamos el coche que acabamos de introducir
		CocheVO coche = servicioCoche.buscarPorMatricula("98765");
		
		//obtenemos sus matriculas
		coche.getReparacion().forEach(reparacion -> 
		System.out.println("matricula:"+coche.getMatricula() 
		+ "[ id:"+reparacion.getIdReparacion() 
		+"importe:" + reparacion.getImporte()
		+",fecha:"+ reparacion.getFecha()
		+"]"));
	}

	/*EJERCICIO 2*/
	@Test
	public void test4recaudacion() {
		
	}
	
	/*EJERCICIO 3*/
	@Test
	public void test5recaudacionFecha() {
		servicioCoche.cocheDia().forEach(x -> System.out.println("fecha: "+x[0] +" nºcoches: " + x[1]+ " importeTotal: "+x[2]));
	}
}
