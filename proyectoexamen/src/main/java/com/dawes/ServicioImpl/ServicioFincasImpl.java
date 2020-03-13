package com.dawes.ServicioImpl;

import com.dawes.DAO.FincasDAO;
import com.dawes.Servicio.ServicioFincas;
import com.dawes.modelos.FincasVO;
import com.dawes.util.MySqlFactory;

public class ServicioFincasImpl implements ServicioFincas{
	
	private MySqlFactory f;
	private FincasDAO cd;


	public ServicioFincasImpl() {
		f = MySqlFactory.getDAO();
		cd = f.getFincas();
	}

	public int insertar(FincasVO fincas) {
		return cd.insertar(fincas);
	}

	public int borrar(FincasVO finca) {
		return cd.borrar(finca);
	}

	public int modificar(FincasVO finca) {
		return cd.modificar(finca);
	}

}
