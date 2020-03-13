package com.dawes.serviciosImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.dao.UsuarioDAO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.servicios.UsuariosServicios;
@Service
public class UsuarioServiciosImpl implements UsuariosServicios {

	@Autowired
	UsuarioDAO ud;

	@Override
	public <S extends UsuarioVO> S save(S entity) {
		return ud.save(entity);
	}

	@Override
	public Optional<UsuarioVO> findById(Integer id) {
		return ud.findById(id);
	}

	@Override
	public Iterable<UsuarioVO> findAll() {
		return ud.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		ud.deleteById(id);
	}

	@Override
	public void delete(UsuarioVO entity) {
		ud.delete(entity);
	}

	@Override
	public void deleteAll() {
		ud.deleteAll();
	}

	@Override
	public UsuarioVO findByUserName(String userName) {
		return ud.findByUserName(userName);
	}
	
	
	
}
