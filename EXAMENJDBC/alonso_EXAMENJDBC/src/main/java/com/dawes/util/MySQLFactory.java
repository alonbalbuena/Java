package com.dawes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.dawes.DAOImpl.IngredientesDAOImpl;
import com.dawes.DAOImpl.RecetaDAOImpl;
import com.dawes.DAOImpl.RecetaIngredientesDAOImpl;

public class MySQLFactory {

	//es un atributo privado
	private Connection conexion;
	//mientras que dao es publico pues vamos a aplicar el patron singleton
	private static MySQLFactory dao;
	
	//este constructor solo se usara dentro del ambito de la clase
	private MySQLFactory() {
		try {
			conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/examenjdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root",
					"temporal"
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//mientras que este metodo es el que usaremos para crear la conexion de forma estatica(llamando a la clase)
	//el llamado SINGLETON
	public static MySQLFactory getDAO() {
		if(dao==null) {
			dao = new MySQLFactory();
		}
		return dao;
	}
	
	//las conexiones individuales con cada modelo implemetado DAO
	public IngredientesDAOImpl getIngredientes() {
		return new IngredientesDAOImpl(conexion);
	}
	public RecetaIngredientesDAOImpl getRecetaIngredientes() {
		return new RecetaIngredientesDAOImpl(conexion);
	}
	public RecetaDAOImpl getReceta() {
		return new RecetaDAOImpl(conexion);		
	}
	
}
