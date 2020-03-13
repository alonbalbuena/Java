package com.dawes.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dawes.DAOImpl.CocheDAOImpl;
import com.dawes.DAOImpl.ReparacionDAOImpl;

public class MySQLFactory {

	private EntityManagerFactory factoria;
	private EntityManager manager;
	
	//singleton
	private static MySQLFactory dao;

	private MySQLFactory() {
		Persistence.generateSchema("primera", null);
		factoria= Persistence.createEntityManagerFactory("primera");
		manager = factoria.createEntityManager();
	}
	
	//singleton(nos permite crear una)
	public static MySQLFactory getDAO(){
		if(dao==null) {
			dao = new MySQLFactory();
		}
		return dao;
	}
	
	//devolver las tablas con las que queramos trabajar 
	public CocheDAOImpl getCoche() {
		return new CocheDAOImpl(manager) ;
	}
	public ReparacionDAOImpl getReparacion() {
		return new ReparacionDAOImpl(manager) ;
	}
}
