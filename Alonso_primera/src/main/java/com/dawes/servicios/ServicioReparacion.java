package com.dawes.servicios;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import com.dawes.modelo.CocheVO;
import com.dawes.modelo.ReparacionVO;

public interface ServicioReparacion {
	
	//De momento solo necesitamos el metodo de insertar reparaciones
	int insertar(ReparacionVO reparacion);
	
	//BUSCA LAS REPACIONES QUE TENGAN DICHA FECHA (puede haer varias con la misma)
	List<ReparacionVO> buscarPorFecha(LocalDate fecha);
	
	List<ReparacionVO> obtenerTodos();
}
