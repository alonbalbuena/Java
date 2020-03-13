package com.dawes.modelos;

import static org.junit.Assert.*;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dawes.modelo.UsuarioVO;

public class TestJPA1 {

	//la factoria la crea el propio hibernate
	static EntityManagerFactory factory;
	
	//tiene varios metodos para borrar,crear,etc...
	static EntityManager em;
	
	@BeforeClass
	public static void antes() {
		//Persistence genera la conexion mediante persistence.xml
		
		//generamos el esquema en la BD
		//el segundo parametro son popiedades para crear el esquema
		//pero no utilizamos
		Persistence.generateSchema("jpa", null);
		
		//creamos la factoria usando el archivo de configuracion
		factory=Persistence.createEntityManagerFactory("jpa");
		
		//creamos el manejador de entidades
		em =factory.createEntityManager();		
	}
	
	@Test
	public void testConexion() {
		assertNotNull(em);
	}
	
	@Test
	public void testInsertar() {
		//lo insertamos
		em.getTransaction().begin();
		em.persist(new UsuarioVO("Jorge", LocalDate.now()));
		em.getTransaction().commit();
		
		//buscamos
		assertNotNull(em.find(UsuarioVO.class, 3));
	}
	
	@Test
	public void testUpdate() {
		//buscamos a jorge
		UsuarioVO jorge = em.find(UsuarioVO.class,3);
		
		//actualizamos
		jorge.setNombre("Jorge luis");
		
		//comienzo de transaccion
		em.getTransaction().begin();
		em.merge(jorge);
		em.getTransaction().commit();
		
		//comprobamos
		assertEquals("Jorge Luis", em.find(UsuarioVO.class, 3));
	}
	
	@Test
	public void testBuscar() {
		//creo una query(javax.persistence)
		Query consulta= em.createQuery("select u from UsuarioVO u where nombre=:nombre");
		
		//asignar valor al parametero
		assertEquals("Jorge Luis", consulta);
	}
	
	@Test
	public void testBuscarTodos() {
		Query consulta = em.createQuery("select u from UsuarioVO u");
		assertEquals(3, consulta.getResultList().size());
	}
	
	@Test
	public void testEliminar() {
		em.getTransaction().begin();
		em.remove(em.find(UsuarioVO.class, 1));
		em.getTransaction().commit();
		
		assertNull(em.find(UsuarioVO.class, 1));
	}

}
