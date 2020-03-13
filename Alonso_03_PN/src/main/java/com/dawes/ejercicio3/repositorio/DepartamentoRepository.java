package com.dawes.ejercicio3.repositorio;

import java.util.ArrayList;

import com.dawes.ejercicio2.Departamentos;

public interface DepartamentoRepository {

	//todos los metodos de INterfaces son publicos
	int insertar(Departamentos departamento);
	int eliminar(Departamentos departamento);
	int modificar(Departamentos departamento);
	Departamentos leerIgual(String denominacion);
	ArrayList<Departamentos> leerTodos();
}
