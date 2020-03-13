package com.dawes.DAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dawes.DAO.FincasDAO;
import com.dawes.modelos.FincasVO;

public class FincasDAOImpl implements FincasDAO {
	
	private EntityManagerFactory factoria;
	private EntityManager manager;
	
	private FincasDAOImpl dao;

	public FincasDAOImpl(EntityManager manager) {
		factoria= Persistence.createEntityManagerFactory("jpa");
		this.manager = manager;
	}
	

	public int insertar(FincasVO fincas) {
		try {
			manager.getTransaction().begin();
			manager.persist(fincas);
			manager.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int borrar(FincasVO finca) {
		try {
		manager.getTransaction().begin();
		manager.remove(finca);
		manager.getTransaction().commit();
		return 1;
	} catch(Exception e) {
		return 0;
	}
	}

	public int modificar(FincasVO finca) {
		try {
			manager.getTransaction().begin();
			FincasVO fincaModificable = manager.find(FincasVO.class, finca.getIdfinca());
			fincaModificable.setNombre("nuevo Nombre");
			manager.getTransaction().commit();
			return 1;
		} catch(Exception e) {
			return 0;
		}
	}

}
