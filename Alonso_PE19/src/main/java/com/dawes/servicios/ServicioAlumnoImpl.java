package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.AlumnoVO;
import com.dawes.repositorio.AlumnoRepository;

@Service
public class ServicioAlumnoImpl {

	@Autowired
	AlumnoRepository ar;

	public <S extends AlumnoVO> S save(S entity) {
		return ar.save(entity);
	}

	public Optional<AlumnoVO> findById(Integer id) {
		return ar.findById(id);
	}

	public Iterable<AlumnoVO> findAll() {
		return ar.findAll();
	}

	public void delete(AlumnoVO entity) {
		ar.delete(entity);
	}

	public List<AlumnoVO> findByNombre(String nombre) {
		return ar.findByNombre(nombre);
	}

	
	
	
 
}
