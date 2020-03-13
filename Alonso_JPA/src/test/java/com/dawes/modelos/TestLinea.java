package com.dawes.modelos;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestLinea {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	
	@BeforeAll
	static void setUpBeforeClass(){
		factory = Persistence.createEntityManagerFactory("jpa");
		manager = factory.createEntityManager();	
	}

	@Test
	public void test1CrearBD() {
		assertNotNull(manager);
	}
	
	
	@Test
	public void test2InsertarLinea() {
		//Creamos una linea nueva que tendra un id a continuzacion de los metidos en data.sql
		LineaVO lineaNueva = new LineaVO("linea 3", "Centro-Camocha", LocalDate.now(), new ArrayList<LineaParadaVO>());
		
		//para confirmar cambios (realizamos el commit)
		manager.getTransaction().begin();
		manager.persist(lineaNueva);
		manager.getTransaction().commit();
		
		//miramos que hemos metido una LINEA nueva en la BD. si es nulo es que no existe
		//buscamos el id 3 que es el numero siguiente a los del sql
		assertNotNull(manager.find(LineaVO.class, 3));
	}
	
	@Test
	public void test3ModificarLinea() {
		//modificamos la linea introducida en el test anterior
		LineaVO lineaModificable = manager.find(LineaVO.class, 3);
		
		manager.getTransaction().begin();
		lineaModificable.setDenCorta("lineaModificada");
		lineaModificable.setDenLarga("linea Modificada denLarga");
		manager.getTransaction().commit();
		
		//comprobamos que se ha cambiado los campos
				assertEquals(
						"lineaModificada",
						manager.find(LineaVO.class,3).getDenCorta()
						);
	}
	
	

}
