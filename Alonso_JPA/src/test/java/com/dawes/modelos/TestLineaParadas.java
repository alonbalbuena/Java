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
class TestLineaParadas {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	
	@BeforeAll
	static void setUpBeforeClass(){
		factory = Persistence.createEntityManagerFactory("jpa");
		manager = factory.createEntityManager();	
	}

	@Test
	void test1CrearBD() {
		assertNotNull(manager);
	}
	
	@Test
	public void test2InsertarLineaParada() {
		//creamos una relacion entre las paradas ya creadas
		LineaParadaVO relacion = new LineaParadaVO(2,manager.find(LineaVO.class,8), manager.find(ParadaVO.class,5));
		
		manager.getTransaction().begin();
		//aqui van todas las sentencias
		manager.persist(relacion);
		//confirmamos
		manager.getTransaction().commit();
		
		//comprobamos que hemos creado la relacion
		//buscamos el id 8 que es el numero siguiente a los del sql
		assertNotNull(manager.find(LineaParadaVO.class, 8));
	}
	
	@Test
	public void test3ModificarLineaParada() {
		//modificamos la linea introducida en el test anterior
		LineaParadaVO relacionModificable = manager.find(LineaParadaVO.class, 1);
		
		manager.getTransaction().begin();
		relacionModificable.setMarquesina(2);//cambiamos la marquesina
		manager.getTransaction().commit();
		
		//comprobamos que se ha cambiado los campos
				assertEquals(
						2,
						relacionModificable.getMarquesina()
						);
	}
	

}
