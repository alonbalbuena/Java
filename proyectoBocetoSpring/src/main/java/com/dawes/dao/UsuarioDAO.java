package com.dawes.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dawes.modelo.UsuarioVO;


//para decirle a Spring que esta clase se encarga de la persistencia
@Repository
public interface UsuarioDAO extends CrudRepository<UsuarioVO, Integer>{
	//este metodo lo genereamos nosotros(creando la programacion Spring) ademas de los ya existenes	
		UsuarioVO findByNombre(String nombre);
		//sintaxis para buscar findBy<Campo>...And<Campo>
}
