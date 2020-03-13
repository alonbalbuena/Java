package com.dawes.otrosMetodos;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dawes.modelos.LineaVO;

public class testTodasLineasParada {

	private static EntityManagerFactory factory;
	private static EntityManager manager;

	@BeforeClass
	public static void setUpBeforeClass() {
		factory = Persistence.createEntityManagerFactory("jpa");
		manager = factory.createEntityManager();	
	}
	
	@Test
	public void testConsultarParadasDeLinea() {
		//nos imprime todas las lineas de dicha parada
		consultarParadasDeLinea("parchis");
	}

	//OBTENEMOS TODAS LAS LINEAS QUE PASAN POR UNA PARADA PASADA
	public void consultarParadasDeLinea(String denominacionParada) {
		
		Query consulta = manager.createQuery("SELECT u "
				+ "FROM ParadaVO p "
				+ "JOIN p.lineas r "
				+ "JOIN r.idLinea u "
				+ "WHERE p.denominacion = :parada ");
		//UNIMOS LAS TRES TABLAS MEDIANTE JPQL
		//(no es necesario usar ON con JPQL)
		
		//pasamos el nombre de la parada que queremos buscar
		consulta.setParameter("parada", denominacionParada);
		
		//creamos una lista con las lineas devueltas
		List<LineaVO> listaLineas = consulta.getResultList();
		
		System.out.println("--------- Por "+ denominacionParada +" Pasan---------");
		
		//mostramos las paradas resultado
		listaLineas.forEach(x -> System.out.println(x.getDenCorta()));
		
	}

}
