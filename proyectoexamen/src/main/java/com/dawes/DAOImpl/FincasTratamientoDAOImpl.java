package com.dawes.DAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dawes.DAO.FincasTratamientoDAO;
import com.dawes.modelos.FincasTratamientoVO;

public class FincasTratamientoDAOImpl implements FincasTratamientoDAO {

	private EntityManagerFactory factoria;
	private EntityManager manager;

	public FincasTratamientoDAOImpl(EntityManager manager) {
		factoria= Persistence.createEntityManagerFactory("jpa");
		this.manager = manager;
	}
	
	public int insertar(FincasTratamientoVO fincastratamiento) {
		try {
			manager.getTransaction().begin();
			manager.persist(fincastratamiento);
			manager.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int borrar(FincasTratamientoVO fincastratamiento) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modificar(FincasTratamientoVO fincastratamiento) {
		// TODO Auto-generated method stub
		return 0;
	}

}
