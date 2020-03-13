package com.dawes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.dawes.DAOImpl.FincaDAOImpl;
import com.dawes.DAOImpl.RelacionDAOImpl;
import com.dawes.DAOImpl.TratamientosDAOImpl;

public class MySQLFactory {
	
	private Connection con;
	
	//singleton
	private static MySQLFactory DAO;
	
	//conexion
	public MySQLFactory(){
		try {
			//CAMBIAMOS LA ZONA HORARIO EN EL SQL "SET GLOBAL time_zone='+1:00';"
			con = DriverManager.getConnection("jdbc:mysql://localhost/fincasytratamientos" ,"root", "Hacendado15*");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	//conexion con cada tabla
	public FincaDAOImpl getFincas() {
		return new FincaDAOImpl(con);	
	}
	
	public TratamientosDAOImpl getTratamientos() {
		return new TratamientosDAOImpl(con);
	}
	
	public RelacionDAOImpl getRelacion() {
		return new RelacionDAOImpl(con);
	}
	
	//metodos singleton
	
	public static MySQLFactory getDAO() {
		//si no existe la conexion crea una con
		if(DAO==null) {
			DAO= new MySQLFactory();
		}
		return DAO;
	}
	
}
