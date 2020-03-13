package com.dawes.servlet;

import java.util.List;

public class ServicioUsuarioImpl implements ServicioUsuario {

	private MySQLFactory factoria;
	private UsuarioDAOImpl servicio;
	
	
	
	public ServicioUsuarioImpl() {
		factoria = MySQLFactory.getFactory();
		servicio = factoria.getUsuarios();
	}
	
	@Override
	public int insertarUsuario(UsuarioVO usuario) {
		return servicio.insertar(usuario);
	}

	@Override
	public List<UsuarioVO> mostrarUsuarios() {
		return servicio.mostrar();
	}

}
