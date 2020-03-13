package com.dawes.serviciosImpl;

import java.util.HashSet;

import com.dawes.DAO.FincaDAO;
import com.dawes.DAOImpl.FincaDAOImpl;
import com.dawes.modelos.FincaVO;
import com.dawes.servicios.ServicioFincas;
import com.dawes.util.MySQLFactory;

public class ServicioFincasImpl implements ServicioFincas {
	
	private MySQLFactory DAO;
	private FincaDAOImpl c;
	
	public ServicioFincasImpl(){
		DAO = MySQLFactory.getDAO();
		c= DAO.getFincas();
		
	}

	public int insertarFinca(FincaVO finca) {
		return c.insertarFinca(finca);
	}

	public int actualizarFinca(FincaVO finca) {
		return c.actualizarFinca(finca);
	}

	public int borrarFinca(FincaVO finca) {
		return c.borrarFinca(finca);
	}

	public int borrarFincaID(int idfinca) {
		return c.borrarFincaID(idfinca);
	}

	public FincaVO BuscarFinca(int idfinca) {
		return c.BuscarFinca(idfinca);
	}

	public HashSet<FincaVO> mostrarFincas() {
		return c.mostrarFincas();
	}



}
