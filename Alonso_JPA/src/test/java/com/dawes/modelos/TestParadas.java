package com.dawes.modelos;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestParadas {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		factory = Persistence.createEntityManagerFactory("jpa");
		manager = factory.createEntityManager();
	}
	
	@Test
	public void test1CrearBD() {
		assertNotNull(manager);
	}

	@Test
	public void test2InsertarParada() {
		//Creamos una parada nueva que tendra un id a continuzacion de los metidos en data.sq
		ParadaVO paradaNueva = new ParadaVO("plaza del humedal",LocalDate.now(),new ArrayList<LineaParadaVO>());
		
		manager.getTransaction().begin();
		//aqui van todas las sentencias
		manager.persist(paradaNueva);
		//para confirmar cambios (realizamos el commit)
		manager.getTransaction().commit();
		
		//miramos que hemos metido una PARADA nueva en la BD. 
		//si es nulo es que no existe
		//buscamos el id 5 que es el numero siguiente a los introducidos por sql
		assertNotNull(manager.find(ParadaVO.class, 5));
	}
	
	/* OTRA MANERA DE MODIFICAR LOS DATOS
	 * @Test public void test3ModificarParada() { manager.getTransaction().begin();
	 * 
	 * //los campos con dos puntos delante son variables ha rellenar Query consulta
	 * = manager.createQuery("Update ParadaVO e " +
	 * "SET e.denominacion = :denominacion , " + "e.fecha = :fecha" +
	 * "WHERE e.idParada = :idParada");
	 * 
	 * consulta.setParameter("idParada",1);//cambiamos la parada introducida
	 * 
	 * consulta.setParameter("denominacion", "denominacionCambiada");//cambio
	 * :denominacion por este valor consulta.setParameter("fecha", "1999-01-01");
	 * 
	 * consulta.executeUpdate();//ejecutamos los cambios
	 * 
	 * manager.getTransaction().commit();//confirmamos los cambios }
	 */
	@Test
	public void test4ModificarParada() {
		
		ParadaVO paradaModificable = manager.find(ParadaVO.class, 1);
		
		manager.getTransaction().begin();
		paradaModificable.setDenominacion("denominacionCambiada");
		manager.getTransaction().commit();
		
		//comprobamos que se ha cambiado el nombre
		assertEquals(
				"denominacionCambiada",
				manager.find(ParadaVO.class, 1).getDenominacion()
				);
	}
	
	@Test
	public void test5BorrarParada() {
		ParadaVO paradaBorrable = manager.find(ParadaVO.class, 1);

		manager.getTransaction().begin();
		//no me dejara borrar la parada si esta asignado a una linea
		//en este caso la parada uno esta en la linea 1 por lo que no me deja borrarla
		manager.remove(paradaBorrable);
		manager.getTransaction().commit();
		
		//buscamos la parada borrada, 
		//si se ha borrado no podra encontrarla
		assertNull(paradaBorrable);
	}

}
