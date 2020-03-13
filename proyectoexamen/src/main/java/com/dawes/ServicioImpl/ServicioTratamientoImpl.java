package com.dawes.ServicioImpl;

import com.dawes.DAOImpl.TratamientoDAOImpl;
import com.dawes.Servicio.ServicioTratamiento;
import com.dawes.modelos.TratamientoVO;
import com.dawes.util.MySqlFactory;

public class ServicioTratamientoImpl implements ServicioTratamiento {

	private MySqlFactory f;
	private TratamientoDAOImpl cd;


	public ServicioTratamientoImpl() {
		f = MySqlFactory.getDAO();
		cd = f.getTratamiento();
	}
	
	
	public int insertar(TratamientoVO tratamiento) {
		return cd.insertar(tratamiento);
	}

	public int borrar(TratamientoVO tratamiento) {
		return cd.borrar(tratamiento);
	}

	public int modificar(TratamientoVO tratamiento) {
		return cd.modificar(tratamiento);
	}

}
