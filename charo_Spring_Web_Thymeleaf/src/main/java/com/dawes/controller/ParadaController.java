package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.ParadaVO;
import com.dawes.servicios.ServicioParada;

@Controller
@RequestMapping("/parada")
public class ParadaController {

	@Autowired
	ServicioParada sp;
	
	@RequestMapping("/listaParada")
	public String listaParada(Model modelo) {
		modelo.addAttribute("listaParada", sp.findAll());
		return "/parada/listaParada";
	}
	
	@RequestMapping("/formInsertaParada")
	public String formInsertaParada(Model modelo) {
		modelo.addAttribute("parada", new ParadaVO());
		return "/parada/formInsertaParada";
	}
	
	@RequestMapping("/insertaParada")
	public String insertaParada(@ModelAttribute ParadaVO parada, Model modelo) {
		sp.save(parada);
		modelo.addAttribute("listaParada", sp.findAll());
		return "/parada/listaParada";
	}
	
	@RequestMapping("/eliminaParada")
	public String eliminaParada(@RequestParam int idparada, Model modelo) {
		sp.delete(sp.findById(idparada).get());
		modelo.addAttribute("listaParada", sp.findAll());
		return "/parada/listaParada";
	}
}
