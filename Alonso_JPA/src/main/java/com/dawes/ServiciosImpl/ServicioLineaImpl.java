package com.dawes.ServiciosImpl;

import javax.persistence.EntityManager;

import com.dawes.util.MySQLFactory;

public class ServicioLineaImpl {

	//EN EL SERVICIO LLAMAMOS AL SINGLETON
	
	private EntityManager dao;

	public ServicioLineaImpl() {
		dao = MySQLFactory.getDAO();
	}
	
	
}
