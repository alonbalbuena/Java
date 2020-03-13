package com.dawes.servicioImpl;

import com.dawes.DAOImpl.CocheDAOImpl;
import com.dawes.DAOImpl.ReparacionDAOImpl;
import com.dawes.modelo.ReparacionVO;
import com.dawes.servicios.ServicioReparacion;
import com.dawes.util.MySQLFactory;

public class ServicioReparacionImpl implements ServicioReparacion {

	private MySQLFactory f;
	private ReparacionDAOImpl cd;
	
	//UTILIZAMOS EL PATRON SINGLETON PARA REALIZAR LA CONEXION AL LLAMAR AL CONSTRUCTOR
	//solo que necesitamos para poder usar los metodos
	//expuesto mas abajo
	public ServicioReparacionImpl() {
		f = MySQLFactory.getDAO();
		cd = f.getReparacion();
	}
	
	
	//USAMOS LOS METODOS PROGRAMados en el DAOIMPL
	public int insertar(ReparacionVO reparacion) {
		return cd.insertar(reparacion);
	}

}
