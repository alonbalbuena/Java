package com.dawes.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.UsuarioVO;

@Repository
public interface UsuarioDAO extends CrudRepository<UsuarioVO, Integer> {
	UsuarioVO findByUserName(String userName);
}
