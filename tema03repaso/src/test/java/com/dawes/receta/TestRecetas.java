package com.dawes.receta;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dawes.modelo.RolVO;
import com.dawes.modelo.UsuarioRolVO;
import com.dawes.modelo.UsuarioVO;

import javassist.expr.NewArray;

public class TestRecetas {

	private static EntityManagerFactory factory;

	private static EntityManager manager;

	@BeforeClass
	public static void antes() {

		// generamos el esquema en la BD mediante "jpa" en persistence.xml
		// el segundo parametro son popiedades para crear el esquema
		//DEBEMOS de cambiar el nombre de la base de datos ANTES
		Persistence.generateSchema("jpa", null);

		factory = Persistence.createEntityManagerFactory("jpa");
		manager = factory.createEntityManager();
	}

	@Test
	public void testConexion() {
		assertNotNull(manager);
	}
	
	
	
}