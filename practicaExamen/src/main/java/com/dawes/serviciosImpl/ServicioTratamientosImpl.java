package com.dawes.serviciosImpl;

import java.util.HashSet;

 
import com.dawes.DAOImpl.TratamientosDAOImpl;
import com.dawes.modelos.TratamientosVO;
import com.dawes.servicios.ServicioTratamientos;
import com.dawes.util.MySQLFactory;

public class ServicioTratamientosImpl implements ServicioTratamientos  {
	
	private MySQLFactory DAO;
	private TratamientosDAOImpl c;
	
	public ServicioTratamientosImpl(){
		DAO = MySQLFactory.getDAO();
		c= DAO.getTratamientos();
		
	}

	public int insertarTratamientos(TratamientosVO tratamientos) {
		return c.insertarTratamientos(tratamientos);
	}

	public int actualizarTratamientos(TratamientosVO tratamientos) {
		return c.actualizarTratamientos(tratamientos);
	}

	public int borrarTratamientos(TratamientosVO tratamientos) {
		return c.borrarTratamientos(tratamientos);
	}

	public int borrarTratamientosID(int idtratamientos) {
		return c.borrarTratamientosID(idtratamientos);
	}

	public TratamientosVO BuscarTratamientos(int idtratamientos) {
		return c.BuscarTratamientos(idtratamientos);
	}

	public HashSet<TratamientosVO> mostrarTratamientos() {
		return c.mostrarTratamientos();
	}

	 
	}


