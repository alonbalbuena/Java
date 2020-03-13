package com.dawes.DAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dawes.DAO.ReparacionDAO;
import com.dawes.modelo.ReparacionVO;

public class ReparacionDAOImpl implements ReparacionDAO {

	private EntityManager manager;


	// CONSTRUCTOR
	public ReparacionDAOImpl(EntityManager manager) {
		// Al llamar a este constructor creamos una conexion, pero nosotros no
		// trabajaremos con esta clase,
		// si no con los servicios, ya que nos facilita el trabajo
		this.manager = manager;
	}

	// METODOS EN LOS QUE PROGRAMAREMOS TODA LA FUNCIONALIDAD DESPUES DE CREAR LA
	// ESTRUCTURA
	public int insertar(ReparacionVO reparacion) {
		try {
			manager.getTransaction().begin();// creamos el area de trabajo

			// realizamos toda las inserciones que queramos
			manager.persist(reparacion);

			// confirmamos los cambios
			manager.getTransaction().commit();
			return 1;// si va todo bien devuelve uno
		} catch (Exception e) {
			e.getMessage();
			return 1;// si no va bien devuelve 0;
		}
	}

}
