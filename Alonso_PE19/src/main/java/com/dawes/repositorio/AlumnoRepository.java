package com.dawes.repositorio;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.AlumnoVO;

@Repository
public interface AlumnoRepository extends CrudRepository<AlumnoVO, Integer> {

	List<AlumnoVO> findByNombre(String nombre);
	
}
