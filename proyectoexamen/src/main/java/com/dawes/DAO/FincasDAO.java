package com.dawes.DAO;

import com.dawes.modelos.FincasVO;

public interface FincasDAO {
	int insertar(FincasVO fincas);
	int borrar(FincasVO finca);
	int modificar(FincasVO finca);

}
