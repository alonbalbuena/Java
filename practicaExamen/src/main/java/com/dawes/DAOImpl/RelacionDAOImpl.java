package com.dawes.DAOImpl;

import java.sql.Connection;
import java.util.HashSet;

import com.dawes.DAO.RelacionDAO;
import com.dawes.modelos.RelacionVO;

public class RelacionDAOImpl implements RelacionDAO {
	private Connection con;
	public RelacionDAOImpl(Connection con) {
		this.con=con;
	}

	public int insertarRelacion(RelacionVO relacion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int actualizarRelacion(RelacionVO relacion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int borrarRelacion(RelacionVO relacion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int borrarRelacionID(int idRelacion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public RelacionVO BuscarRelacion(int idRelacion) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashSet<RelacionVO> mostrarRelaciones() {
		// TODO Auto-generated method stub
		return null;
	}

}
