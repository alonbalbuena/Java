package com.dawes.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.LineaVO;

@Repository
public interface LineaRepository extends CrudRepository<LineaVO, Integer>{

	LineaVO findByDencorta(String dencorta);
	LineaVO findByDenlarga(String denlarga);
	@Query("SELECT l FROM LineaVO l left outer join l.paradas p where l.idlinea=:idlinea")
	LineaVO buscarParadasDeLinea(int idlinea);
	
}

