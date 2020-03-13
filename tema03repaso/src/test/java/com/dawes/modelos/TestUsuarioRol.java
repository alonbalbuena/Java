package com.dawes.modelos;

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

public class TestUsuarioRol {
	
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
	public void test1Conexion() {
		assertNotNull(manager);
	}
	
	@Test
	public void test2InsertarRol() {
		manager.getTransaction().begin();
		manager.persist(new RolVO("administrador",new ArrayList()));
		manager.getTransaction().commit();
		
		assertNotNull(manager.find(RolVO.class,1));
	}
	
	@Test
	public void t3crearUsuarioConRol(){
		
		UsuarioVO usuario = new UsuarioVO("oscar",LocalDate.now(),new ArrayList());
		RolVO rol = new RolVO("administrador",new ArrayList());
		
		/*creo la relacion*/
		UsuarioRolVO ur = new UsuarioRolVO(rol,usuario);
		/*actulizo las relaciones de usuario y rol*/
		usuario.getRoles().add(ur);
		rol.getUsuarios().add(ur);
		
		//persisto
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		
		//consulto a ver si funciona
		UsuarioVO consulta = (UsuarioVO) manager.createQuery("SELECT u FROM usuarios u WHERE nombre:=nombre").setParameter("nombre", usuario.getNombre()).getSingleResult();
		assertEquals(1, consulta.getRoles().size());
	}
	
	public void crearUsuario(UsuarioVO usuario,RolVO rol){
		/*creo la relacion*/
		UsuarioRolVO ur = new UsuarioRolVO(rol,usuario);
		/*actulizo las relaciones de usuario y rol*/
		usuario.getRoles().add(ur);
		rol.getUsuarios().add(ur);
		
		//persisto
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
	}
	
	@Test
	public void t4BuscarUsuariosPorRol() {
		//usuarios
		UsuarioVO ramon = new UsuarioVO("ramon", LocalDate.now(),new ArrayList());
		UsuarioVO jorge = new UsuarioVO("jorge", LocalDate.now(),new ArrayList());
		UsuarioVO raul = new UsuarioVO("raul", LocalDate.now(),new ArrayList());
		UsuarioVO victor = new UsuarioVO("victor", LocalDate.now(),new ArrayList());
		//roles
		RolVO administrador = new RolVO("administrador",new ArrayList());
		RolVO registrado = new RolVO("administrador",new ArrayList());
		
		//creamos los usuarios junto con sus tablas intermedias
		crearUsuario(ramon,administrador);
		crearUsuario(jorge,administrador);
		
		//buscamos los usuarios por el rol introducido
		buscarUsuariosPorRol(administrador);
	}
	
	public void buscarUsuariosPorRol(RolVO rol) {
		Query consulta =  manager.createQuery("SELECT u FROM usuarios u,roles r, usuariorol x WHERE u.idusuario:=x.idusuario AND x.idrol :=r.idrol AND r.nombre:=nombre");
		consulta.setParameter("nombre", rol.getNombre());//relacionamos tablas y buscamos por nombre
		System.out.println(consulta.getResultList());
	}
}
