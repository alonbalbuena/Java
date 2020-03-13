package com.dawes.DAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dawes.DAO.CocheDAO;
import com.dawes.modelo.CocheVO;

public class CocheDAOImpl implements CocheDAO {
	
	private EntityManager manager;

	//CONSTRUCTOR
	public CocheDAOImpl(EntityManager manager) {
		//Al llamar a este constructor creamos una conexion, pero nosotros no trabajaremos con esta clase,
		//si no con los servicios, ya que nos facilita el trabajo
		this.manager = manager;
	}
	
	
	//METODOS EN LOS QUE PROGRAMAREMOS TODA LA FUNCIONALIDAD DESPUES DE CREAR LA ESTRUCTURA
	public CocheVO buscarPorMatricula(String matricula) {
		try {
			//Creamos la consulta 
			Query consultaBusqueda = manager.createQuery("SELECT l FROM CocheVO l WHERE matricula = :matricula");
			
			//rellenamos las variables con los valore que queremos buscar
			consultaBusqueda.setParameter("matricula", matricula);
			
			//ejecutamos la busqueda
			manager.getTransaction().begin();
			CocheVO cochesEncontrados = (CocheVO) consultaBusqueda.getSingleResult();
			manager.getTransaction().commit();
			
			//devolvemos el valor encontrado
			return cochesEncontrados;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public int insertar(CocheVO coche) {
		try {
			manager.getTransaction().begin();//creamos el area de trabajo
			
			//realizamos toda las inserciones que queramos
			manager.persist(coche);
			
			//confirmamos los cambios
			manager.getTransaction().commit();
			return 1;//si va todo bien devuelve uno
		} catch (Exception e) {
			e.getMessage();
			return 0;//si no va bien devuelve 0;
		}
	}


	public int actualizarPorMatricula(CocheVO coche) {
		try {
			//Creamos la consulta 
			Query consultaBusqueda = manager.createQuery("SELECT l FROM CocheVO l WHERE matricula = :matricula");
			
			//rellenamos las variables con los valore que queremos buscar
			consultaBusqueda.setParameter("matricula", coche.getMatricula());
			
			//ejecutamos la busqueda
			CocheVO cochesEncontrados = (CocheVO) consultaBusqueda.getSingleResult();
			
			//modificamos el campo encontrado e hibernate nos lo actualiza automaticamente
			cochesEncontrados.setPropietario("propietarioActualizado");
			
			//devolvemos si ha funcionado
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

}
