package com.dawes.serviciosImpl;

import java.util.HashSet;

import com.dawes.DAO.RelacionDAO;
import com.dawes.DAOImpl.RelacionDAOImpl;
import com.dawes.DAOImpl.TratamientosDAOImpl;
import com.dawes.modelos.RelacionVO;
import com.dawes.servicios.ServicioRelacion;
import com.dawes.util.MySQLFactory;

public class ServicioRelacionImpl implements ServicioRelacion {
	
	private MySQLFactory DAO;
	private RelacionDAOImpl c;
	
	public ServicioRelacionImpl(){
		DAO = MySQLFactory.getDAO();
		c= DAO.getRelacion();
		
	}

	public int insertarRelacion(RelacionVO relacion) {
		return c.insertarRelacion(relacion);
	}

	public int actualizarRelacion(RelacionVO relacion) {
		return c.actualizarRelacion(relacion);
	}

	public int borrarRelacion(RelacionVO relacion) {
		return c.borrarRelacion(relacion);
	}

	public int borrarRelacionID(int idRelacion) {
		return c.borrarRelacionID(idRelacion);
	}

	public RelacionVO BuscarRelacion(int idRelacion) {
		return c.BuscarRelacion(idRelacion);
	}

	public HashSet<RelacionVO> mostrarRelaciones() {
		return c.mostrarRelaciones();
	}

 
}
