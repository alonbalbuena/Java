package com.dawes.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.AlumnoVO;

//para decirle a Spring que esta clase se encarga de la persistencia
@Repository
public interface AlumnoRepository extends CrudRepository<AlumnoVO, Integer>{

//este metodo lo genereamos nosotros(creando la programacion Spring) ademas de los ya existenes	
	AlumnoVO findByNombre(String nombre);
	//sintaxis para buscar findBy<Campo>...And<Campo>
}
