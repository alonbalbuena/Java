package com.dawes.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dawes.ServiciosImpl.ServicioLineaImpl;
import com.dawes.ServiciosImpl.ServicioLineaParadaImpl;
import com.dawes.ServiciosImpl.ServicioParadaImpl;

public class MySQLFactory {
	
	private static EntityManagerFactory factory;
	//solo crearemos una "conexion" por clase
	private static EntityManager manager;

	//es privado para el patron Singleton
	private MySQLFactory() {
		factory = Persistence.createEntityManagerFactory("jpa");
		manager = factory.createEntityManager();	
	}
	
	//SINGLETON
	public static EntityManager getDAO() {
		//si no existe lo creo
		if(manager == null) {
			new MySQLFactory();
		}
		//si ya existe devuelvo el creado ya
		return manager;
	}
	
	//FAÇADE
	public ServicioLineaImpl getLineas(){
		return new ServicioLineaImpl();
	}
	
	public ServicioParadaImpl getParadas() {
		return new ServicioParadaImpl();
	}
	
	public ServicioLineaParadaImpl getLineaParada() {
		return new ServicioLineaParadaImpl();
	}
	
}
