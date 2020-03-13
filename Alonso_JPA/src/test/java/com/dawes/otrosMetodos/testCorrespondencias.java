package com.dawes.otrosMetodos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dawes.modelos.LineaVO;
import com.dawes.modelos.ParadaVO;

public class testCorrespondencias {

	private static EntityManagerFactory factory;
	private static EntityManager manager;

	@BeforeClass
	public static void setUpBeforeClass() {
		factory = Persistence.createEntityManagerFactory("jpa");
		manager = factory.createEntityManager();
	}

	@Test
	public void testConsultarParadasDeLinea() {
		consultarParadasDeLinea("linea 2");
	}
	
	
	public void consultarParadasDeLinea(String denCortaLinea) {

		Query consulta = manager.createQuery("SELECT p " 
		+ "FROM ParadaVO p " 
		+ "JOIN p.lineas r " 
		+ "JOIN r.idLinea u "
		+ "WHERE u.denCorta = :linea ");
		// UNIMOS LAS TRES TABLAS MEDIANTE JPQL
		// (no es necesario usar ON con JPQL)

		consulta.setParameter("linea", denCortaLinea);//linea que vamos a probar

		// creamos una lista con las lineas devueltas
		List<ParadaVO> listaParadas = consulta.getResultList();

		System.err.println("---------"+denCortaLinea+"---------");

		// mostramos las paradas resultado con sus correspondientes lineas
		for (ParadaVO parada : listaParadas) {
			
			//miramos cuantas lineas tiene la parada
			List<LineaVO> lineasDeParada = obtenerLineasDeParada(parada);
			
			if (lineasDeParada.size() > 1) {
				//si tiene mas de una linea coincidente tiene correspondencias
				
				System.err.print(parada.getDenominacion());
				
				//le añadimos las lineas con la que corresponde
				System.err.print(" Correspondencias --> (");
				lineasDeParada.stream()
				.map(linea -> linea.getDenCorta())//solo mostramos las denominaciones de la linea
				.filter(denominacion -> ! denominacion.equals(denCortaLinea))//filtramos para que no nos ponga la propia linea 
				.forEach(System.err::print);
				System.err.print(")\n");

			}else {
				//si la parada no tiene correspondencia lo imprime normal
				System.err.println(parada.getDenominacion());
			}
		}
	}
	
	
	//Creamos un metodo que devuelva la lista de lineas de cada parada
	public List<LineaVO> obtenerLineasDeParada(ParadaVO parada) {//pasamos la parada que queremos comprobar
		
		Query consulta = manager.createQuery("SELECT u "
				+ "FROM ParadaVO p "
				+ "JOIN p.lineas r "
				+ "JOIN r.idLinea u "
				+ "WHERE p.denominacion = :parada ");
		
		//pasamos el nombre de la parada que queremos buscar
		consulta.setParameter("parada", parada.getDenominacion());
		
		//creamos una lista con las lineas de correspondencia
		List<LineaVO> listaLineas = consulta.getResultList();
		
		//devolvemos las lineas encontrados con dicha parada
		return listaLineas;
	}

}
