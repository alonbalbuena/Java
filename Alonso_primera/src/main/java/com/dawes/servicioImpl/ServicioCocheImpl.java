package com.dawes.servicioImpl;

import java.util.List;

import com.dawes.DAOImpl.CocheDAOImpl;
import com.dawes.modelo.CocheVO;
import com.dawes.servicios.ServicioCoche;
import com.dawes.util.MySQLFactory;

public class ServicioCocheImpl implements ServicioCoche {

	private MySQLFactory f;
	private CocheDAOImpl cd;
	
	//UTILIZAMOS EL PATRON SINGLETON PARA REALIZAR LA CONEXION
	//ademas cojemos la tabla solo que necesitamos para poder usar los metodos
	//expuesto mas abajo
	public ServicioCocheImpl() {
		f = MySQLFactory.getDAO();
		cd = f.getCoche();
	}
	
	
	//USAMOS LOS METODOS PROGRAMADOS EN EL DAOIMPL
	public CocheVO buscarPorMatricula(String matricula) {
		return cd.buscarPorMatricula(matricula);
	}
	public int insertar(CocheVO coche) {
		return cd.insertar(coche);
	}

	public int actualizarPorMatricula(CocheVO coche) {
		return cd.actualizarPorMatricula(coche);
	}

	public List<CocheVO> obtenerTodos(){
		return cd.obtenerTodos();
	}
	
	public List<Object[]> cocheDia(){
		return cd.cocheDia();
	}
}
