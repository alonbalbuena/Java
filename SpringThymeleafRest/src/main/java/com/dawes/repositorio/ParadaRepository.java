package com.dawes.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ParadaVO;

@Repository
public interface ParadaRepository extends CrudRepository<ParadaVO, Integer>{

	ParadaVO findByDenominacion(String denominacion);
	@Query("select p from ParadaVO p where p.idparada not in (select lp.parada.idparada from LineaParadaVO lp where lp.linea.idlinea = :idlinea)")
	List<ParadaVO> getParadasNoAñadidas(@Param("idlinea") Integer idlinea);
	
}
