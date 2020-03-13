package com.dawes.DAO;

import java.util.HashSet;

import com.dawes.modelos.RelacionVO;

public interface RelacionDAO {
	
	int insertarRelacion(RelacionVO relacion);
	int actualizarRelacion (RelacionVO relacion);
	int borrarRelacion(RelacionVO relacion);
	int borrarRelacionID(int idRelacion);
	RelacionVO BuscarRelacion (int idRelacion);
	HashSet<RelacionVO> mostrarRelaciones();


}
