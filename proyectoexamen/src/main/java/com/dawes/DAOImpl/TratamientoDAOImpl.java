package com.dawes.DAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dawes.DAO.TratamientoDAO;
import com.dawes.modelos.TratamientoVO;

public class TratamientoDAOImpl implements TratamientoDAO {

	private EntityManagerFactory factoria;
	private EntityManager manager;

	public TratamientoDAOImpl(EntityManager manager) {
		factoria= Persistence.createEntityManagerFactory("jpa");
		this.manager = manager;
	}
	
	public int insertar(TratamientoVO tratamiento) {
		try {
			manager.getTransaction().begin();
			manager.persist(tratamiento);
			manager.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int borrar(TratamientoVO tratamiento) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modificar(TratamientoVO tratamiento) {
		// TODO Auto-generated method stub
		return 0;
	}

}
