package com.dawes.ServicioImpl;

import com.dawes.DAO.FincasTratamientoDAO;
import com.dawes.DAOImpl.FincasTratamientoDAOImpl;
import com.dawes.Servicio.ServicioFincasTratamiento;
import com.dawes.modelos.FincasTratamientoVO;
import com.dawes.util.MySqlFactory;

public class ServicioFincasTratamientoImpl implements ServicioFincasTratamiento{

	private MySqlFactory f;
	private FincasTratamientoDAO cd;


	public ServicioFincasTratamientoImpl() {
		f = MySqlFactory.getDAO();
		cd = f.getFincasTratamiento();
	}
	
	public int insertar(FincasTratamientoVO fincastratamiento) {
		return cd.insertar(fincastratamiento);
	}

	public int borrar(FincasTratamientoVO fincastratamiento) {
		return cd.borrar(fincastratamiento);
	}

	public int modificar(FincasTratamientoVO fincastratamiento) {
		return cd.modificar(fincastratamiento);
	}

}
