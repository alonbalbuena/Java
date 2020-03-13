package com.dawes.ejercicio3.repositorio;

import java.util.ArrayList;

import com.dawes.ejercicio2.Empleados;

public interface EmpleadoRepository {

	int insertar(Empleados empleado);
	int eliminar(Empleados empleado);
	int modificar(Empleados empleado);
	Empleados leerIgual(String dni);
	ArrayList<Empleados> leerTodos();
	
}
