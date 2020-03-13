package com.dawes;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestModelo1 {

	static EntityManagerFactory emf;
	static EntityManager em;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		//generamos la persistencia para un esquema que tengamos creado en la 
		Persistence.generateSchema("jpa", null);
		
		//creamos la factoria
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();
		
	}

	@Test
	public void testGenerarEsquema() {
		assertNotNull(emf);
	}
	
	@Test
	public void testPersistir() {
	}

}
