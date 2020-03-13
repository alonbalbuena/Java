package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.CursoVO;

@Repository
public interface CursoRepository extends CrudRepository<CursoVO, Integer> {
}
