package com.dawes.controller;

import com.dawes.repositorio.LineaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/consultas")
public class ConsultasController {

	@Autowired
	LineaRepository servicio;

	// TODOS DEVUELVEN LA INFORMACION A LA MISMA PAGINA

	@RequestMapping("/1")
	public String consulta1(String marquesina, String parada, Model modelo) {

		//CONSULTA
		servicio.buscarParadasDeLinea(5);
		//ENVIAMOS
		modelo.addAttribute("",2);

		return "consultas";
	}

	@RequestMapping("/2")
	public String consulta2() {
		return "consultas";
	}

	@RequestMapping("/3")
	public String consulta3() {
		return "consultas";
	}

}
