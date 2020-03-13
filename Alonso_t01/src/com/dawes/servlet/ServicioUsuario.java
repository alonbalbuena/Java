package com.dawes.servlet;

import java.util.List;

public interface ServicioUsuario {

	int insertarUsuario(UsuarioVO usuario);
	List<UsuarioVO> mostrarUsuarios();
}
