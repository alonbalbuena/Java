package com.dawes.DAOImpl;

import java.sql.Connection;
import java.util.HashSet;

import com.dawes.DAO.TratamientosDAO;
import com.dawes.modelos.TratamientosVO;

public class TratamientosDAOImpl implements TratamientosDAO {
	private Connection con;
	public TratamientosDAOImpl(Connection con) {
		this.con=con;
	}

	public int insertarTratamientos(TratamientosVO tratamientos) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int actualizarTratamientos(TratamientosVO tratamientos) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int borrarTratamientos(TratamientosVO tratamientos) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int borrarTratamientosID(int idtratamientos) {
		// TODO Auto-generated method stub
		return 0;
	}

	public TratamientosVO BuscarTratamientos(int idtratamientos) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashSet<TratamientosVO> mostrarTratamientos() {
		// TODO Auto-generated method stub
		return null;
	}

}
