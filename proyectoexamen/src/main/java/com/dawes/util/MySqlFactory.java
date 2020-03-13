package com.dawes.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dawes.DAO.FincasTratamientoDAO;
import com.dawes.DAOImpl.FincasDAOImpl;
import com.dawes.DAOImpl.FincasTratamientoDAOImpl;
import com.dawes.DAOImpl.TratamientoDAOImpl;
import com.dawes.ServicioImpl.ServicioFincasImpl;
import com.dawes.ServicioImpl.ServicioFincasTratamientoImpl;
import com.dawes.ServicioImpl.ServicioTratamientoImpl;

public class MySqlFactory {
	
	private EntityManagerFactory factoria;
	private EntityManager manager;
	
	//singleton
	private static MySqlFactory dao;

	private MySqlFactory() {
		factoria= Persistence.createEntityManagerFactory("jpa");
		manager = factoria.createEntityManager();
	}
	
	//singleton
	public static MySqlFactory getDAO(){
		if(dao==null) {
			dao = new MySqlFactory();
		}
		return dao;
	}
	
	//devolver tablas modelo facade
	
	public FincasDAOImpl getFincas() {
		return new FincasDAOImpl(manager) ;
	}
	public TratamientoDAOImpl getTratamiento() {
		return new TratamientoDAOImpl(manager) ;
	}
	public FincasTratamientoDAOImpl getFincasTratamiento() {
		return new FincasTratamientoDAOImpl(manager) ;
	}
	

}
