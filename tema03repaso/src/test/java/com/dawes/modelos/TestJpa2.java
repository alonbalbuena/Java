package com.dawes.modelos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.modelo.PostVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJpa2 {

	// la factoria la crea el propio hibernate
	static EntityManagerFactory factory;

	// tiene varios metodos para borrar,crear,etc...
	static EntityManager em;

	@BeforeClass
	public static void antes() {
		// Persistence genera la conexion mediante persistence.xml

		// generamos el esquema en la BD siguiendo directrices del persistence.jpa
		Persistence.generateSchema("jpa", null);

		// creamos la factoria usando el archivo de configuracion
		factory = Persistence.createEntityManagerFactory("jpa");

		// creamos el manejador de entidades
		em = factory.createEntityManager();
	}
	
	@Test
	public void test1Conexion(){
		assertNotNull(em);
	}
	
	@Test
	public void test2Insertar() {
		//lo insertamos
		em.getTransaction().begin();
		em.persist(new PostVO("post1", "hola mundo", LocalDate.now()));
		em.getTransaction().commit();
		
		//buscamos a ver si lo hemos introducido correctamente
		assertNotNull(em.find(PostVO.class, 1));
	}
	
	@Test
	public void test3Update() {
		//buscamospost1
		PostVO post1 = em.find(PostVO.class,1);
		
		//actualizamos
		post1.setNombre("post1Actualizado");
		
		//comienzo de transaccion
		em.getTransaction().begin();
		em.merge(post1);
		em.getTransaction().commit();
		
		//comprobamos
		assertEquals("post1Actualizado", em.find(PostVO.class, 1).getNombre());
	}
	
	@Test
	public PostVO test4Buscar() {
		try {
			//creo una query(javax.persistence)
			Query consulta= em.createQuery("select u from PostVO u where nombre=:nombre");
			consulta.setParameter("nombre", "post1Actualizado");
			PostVO registro = (PostVO) consulta.getSingleResult();
			
			//asignar valor al parametero
			assertEquals("post1Actualizado", registro.getNombre().toString());
			
			return registro;
		}
		//si no encuentra un resultado
		catch(NoResultException e){
			return null;
		}
	}
	
	@Test
	public void test5BuscarTodos() {
		Query consulta = em.createQuery("select u from PostVO u");
		assertEquals(1, consulta.getResultList().size());
	}
	
	@Test
	public void test6Eliminar() {
		em.getTransaction().begin();
		em.remove(em.find(PostVO.class, 1));
		em.getTransaction().commit();
		
		assertNull(em.find(PostVO.class, 1));
	}

}
