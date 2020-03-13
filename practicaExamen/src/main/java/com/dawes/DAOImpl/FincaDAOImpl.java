package com.dawes.DAOImpl;

import java.sql.Connection;
import java.util.HashSet;

import com.dawes.DAO.FincaDAO;
import com.dawes.modelos.FincaVO;
import com.dawes.util.MySQLFactory;

public class FincaDAOImpl implements FincaDAO {

	private Connection con;
	public FincaDAOImpl(Connection con) {
		this.con=con;
	}
	
	public int insertarFinca(FincaVO finca) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int actualizarFinca(FincaVO finca) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int borrarFinca(FincaVO finca) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int borrarFincaID(int idfinca) {
		// TODO Auto-generated method stub
		return 0;
	}

	public FincaVO BuscarFinca(int idfinca) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashSet<FincaVO> mostrarFincas() {
		// TODO Auto-generated method stub
		return null;
	}

}
