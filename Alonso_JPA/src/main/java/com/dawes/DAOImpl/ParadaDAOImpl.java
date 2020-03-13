package com.dawes.DAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dawes.DAO.ParadaDAO;
import com.dawes.modelos.ParadaVO;

public class ParadaDAOImpl implements ParadaDAO {

	//EN DAO IMPL CREAMOS EL MANAGER AL COMPLETO
	
		private static EntityManagerFactory factory;
		//solo crearemos una "conexion" por clase
		private static EntityManager manager;
		
		public ParadaDAOImpl() {
			factory = Persistence.createEntityManagerFactory("jpa");
			manager = factory.createEntityManager();
		}
		
		@Override
		public int buscarPorNombre(String denominacion) {
			Query consulta = manager.createQuery("select l from ParadaVO l where denominacion = :denominacion");
			consulta.setParameter("denominacion", denominacion);
			
			ParadaVO resultado = (ParadaVO) consulta.getSingleResult();
			
			System.out.println(resultado.toString());
			
			return 1;
		}

}
