package com.dawes.otrosMetodos;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dawes.modelos.ParadaVO;

public class testTodasParadas {

	private static EntityManagerFactory factory;
	private static EntityManager manager;

	@BeforeClass
	public static void setUpBeforeClass() {
		factory = Persistence.createEntityManagerFactory("jpa");
		manager = factory.createEntityManager();
	}

	@Test
	public void testConsultarParadasDeLinea() {
		consultarParadasDeLinea("linea 1");
	}

	public void consultarParadasDeLinea(String denCortaLinea) {

		Query consulta = manager.createQuery("SELECT p " + "FROM ParadaVO p " + "JOIN p.lineas r " + "JOIN r.idLinea u "
				+ "WHERE u.denCorta = :linea ");
		// UNIMOS LAS TRES TABLAS MEDIANTE JPQL
		// (no es necesario usar ON con JPQL)

		// pasamos el nombre de la linea que queremos buscar
		consulta.setParameter("linea", denCortaLinea);

		// creamos una lista con las lineas devueltas
		List<ParadaVO> listaParadas = consulta.getResultList();

		System.out.println("--------- paradas de " + denCortaLinea + "---------");

		// mostramos las paradas resultado
		listaParadas.forEach(x -> System.out.println(x.getDenominacion()));
	}
}
