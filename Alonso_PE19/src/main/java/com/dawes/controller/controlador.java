package com.dawes.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.repositorio.AlumnoCursoRepository;
import com.dawes.repositorio.AlumnoRepository;

@Controller
@RequestMapping("/")
public class controlador {
	
	@Autowired
	AlumnoCursoRepository acr;

	@RequestMapping("desmatricularAlumnos")
	public String desmatricularAlumnos(@RequestParam String fechaInicial,@RequestParam String fechaFinal,Model modelo) {
		
		LocalDate parsefechaInicial = LocalDate.parse(fechaInicial);
		LocalDate parsefechaFinal= LocalDate.parse(fechaFinal);
		
		
		//borramos las matriculas entre dichas fechas
		acr.deleteByFechaBetween(parsefechaInicial, parsefechaFinal);
		
		//pasamos toda la lista de usuarios a la pagina
		modelo.addAttribute("listaMatriculas",acr.findAll());
		
		return "mostrarMatriculas";	
	}
	
	@Autowired
	AlumnoRepository ar;
	
	@RequestMapping("consultarAlumnos")
	public String consultarAlumnos(@RequestParam String nombre,Model modelo) {
		
		//cojemos la lista de alumnos que cumplan dicho criterio
		modelo.addAttribute("listaAlumnos", ar.findByNombre(nombre));
		 
		return "consultaAlumnos";
	}
	
}
