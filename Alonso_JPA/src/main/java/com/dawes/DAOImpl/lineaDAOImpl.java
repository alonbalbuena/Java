package com.dawes.DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dawes.DAO.LineaDAO;
import com.dawes.modelos.LineaParadaVO;
import com.dawes.modelos.LineaVO;

public class lineaDAOImpl implements LineaDAO {

	//EN DAO IMPL CREAMOS EL MANAGER AL COMPLETO
	
	private static EntityManagerFactory factory;
	//solo crearemos una "conexion" por clase
	private static EntityManager manager;
	
	public lineaDAOImpl() {
		factory = Persistence.createEntityManagerFactory("jpa");
		manager = factory.createEntityManager();
	}

	
	@Override
	public int buscarPorNombre(String denCorta) {
		Query consulta = manager.createQuery("select l from LineaVO l where nombre = :nombre");
		consulta.setParameter("nombre", denCorta);
		LineaVO linea = (LineaVO) consulta.getSingleResult();
		
		//1-mostrar nombre linea
		//2-mostrar nombre de las paradas
		System.out.println("nombre de la linea"+ linea.getDenLarga());
		List<LineaParadaVO> relaciones = linea.getParadas();
		relaciones.forEach(relacion -> System.out.println(relacion.getIdParada().getDenominacion()));
		return 1;
	}
	
	@Override
	public int buscarNombreLargoPorNombre(String denCorta) {
		Query consulta = manager.createQuery("select l.denlarga,l.dencorta from LineaVO l");
		List<Object[]> lista = consulta.getResultList();//devuelve una lista de objetos
		
		//1-mostrar nombre linea
		//2-mostrar nombre de las paradas
		System.out.println("todos los nombres de linea");
		lista.forEach(linea -> System.out.println(linea[0] + " " + linea[1]));
		return 1;
	}

	@Override
	public int insertarLinea(LineaVO linea) {
		manager.getTransaction().begin();
		manager.persist(linea);
		manager.getTransaction().commit();
		return 1;
	}
}
