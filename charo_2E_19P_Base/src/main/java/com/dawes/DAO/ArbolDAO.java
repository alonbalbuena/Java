package com.dawes.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FincaVO;

@Repository
public interface ArbolDAO extends CrudRepository<ArbolVO,Integer>{

	ArbolVO findByFilaAndColumnaAndFinca(Integer fila, Integer columna,Integer finca);
}
