package com.dawes.servlet;

import java.util.List;

public interface UsuarioDAO {

	int insertar(UsuarioVO usuario);
	List<UsuarioVO> mostrar();
}
