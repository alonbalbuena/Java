package com.dawes.controlador;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dawes.DAO.ArbolDAOImpl;
import com.dawes.DAO.FincaDAOImpl;
import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FincaVO;

@RequestMapping("/")
@Controller
public class controlador {
	
	@Autowired
	FincaDAOImpl servicioFinca;
	@Autowired
	ArbolDAOImpl servicioArbol;

	@RequestMapping("listarArboles")
	public String listarArboles(Model modelo) {
		//desde el indice pasamos por aqui para pasar todas las fincas al formulario
		//para poder crear la lista desplegable
		
		modelo.addAttribute("listaFincas",servicioFinca.findAll());
		
		//pasamos la lista al formulario
		return "formModificar";
	}
	
	@RequestMapping("modificar")
	public String modificarArbol(Model modelo,Integer finca,Integer fila,Integer columna) {
		//seleccionamos el arbol con todas esas condiciones
		ArbolVO arbol =servicioArbol.findByFilaAndColumnaAndFinca(fila, columna, finca);
		
		//lo modificamos
		arbol.setFila(fila);
		arbol.setColumna(columna);
		
		//pasamos la lista al formulario
		return "formModificar";
	}
}
