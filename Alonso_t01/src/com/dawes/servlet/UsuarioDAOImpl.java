package com.dawes.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioDAOImpl implements UsuarioDAO {

	EntityManager em;
	
	public UsuarioDAOImpl(EntityManager em) {
		//le pasamos el manager generado en el servicio mediante la factoria daoImpl->servicio->factoria
		this.em = em;
	}

	@Override
	public int insertar(UsuarioVO usuario) {
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			System.err.println("error al introducir usuario");
			return 2;
		}
	}

	@Override
	public List<UsuarioVO> mostrar() {
			Query consulta = em.createQuery("SELECT u FROM UsuarioVO u");
			
			ArrayList<UsuarioVO> lista = (ArrayList<UsuarioVO>) consulta.getResultList();
			
			return lista;
	}

}
