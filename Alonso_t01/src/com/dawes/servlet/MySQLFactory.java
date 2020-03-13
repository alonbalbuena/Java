package com.dawes.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLFactory {

	EntityManagerFactory emf;
	EntityManager em;
	
	private static MySQLFactory factoria;//singleton
	
	private MySQLFactory() {
		Persistence.generateSchema("servlets", null);
		emf = Persistence.createEntityManagerFactory("servlets");
		em = emf.createEntityManager();
	}
	
	public static MySQLFactory getFactory() {
		if(factoria == null) {
			factoria = new MySQLFactory();
		}
		return factoria;
	}
	
	
	//IMPLEMENTACION DEL DAO
	public UsuarioDAOImpl getUsuarios() {
		return new UsuarioDAOImpl(em);
	}
}
