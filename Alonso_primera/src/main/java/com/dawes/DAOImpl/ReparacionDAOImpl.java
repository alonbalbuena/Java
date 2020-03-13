package com.dawes.DAOImpl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dawes.DAO.ReparacionDAO;
import com.dawes.modelo.CocheVO;
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
	
	//BUSCA LAS REPACIONES QUE TENGAN DICHA FECHA (puede haer varias con la misma)
	public List<ReparacionVO> buscarPorFecha(LocalDate fecha) {
		try {
			//Creamos la consulta que nso devuelva todos
			Query consultaFecha = manager.createQuery("SELECT l FROM ReparacionVO l WHERE fecha = :fecha");
			
			//buscamos la fecha indicada
			consultaFecha.setParameter("fecha", fecha);
			
			//introducimos el valor e una lista ya que nos va a devolver muchos datos
			List<ReparacionVO> resultado = consultaFecha.getResultList();
			
			//devolvemos la lista con todos los coches
			return resultado;
			
		} catch (Exception e) {
			//para la asercion
			e.getMessage();
			return null;
		}
	}
	
	public List<ReparacionVO> obtenerTodos(){
		try {
			//Creamos la consulta que nso devuelva todos
			Query consultaBusqueda = manager.createQuery("SELECT l FROM ReparacionVO l");
			
			//introducimos el valor e una lista ya que nos va a devolver muchos datos
			List<ReparacionVO> resultado = consultaBusqueda.getResultList();
			
			//devolvemos la lista con todos los coches
			return resultado;
			
		} catch (Exception e) {
			//para la asercion
			e.getMessage();
			return null;
		}
	}

}
