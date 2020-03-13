package com.dawes.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.dao.AlumnoRepository;
import com.dawes.modelo.AlumnoVO;

//para que Spring sepa que hay que inyectarle el entitymanager
//(igual que como haciamos nosotros)

@Service
public class ServicioAlumnoImpl {

	//1- queremos que se autoinstancia el dao
	
	@Autowired
	AlumnoRepository ar;

	//2- genereamos los metodos delegados
	
	public AlumnoVO findByNombre(String nombre) {
		return ar.findByNombre(nombre);
	}

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
	
	
}
