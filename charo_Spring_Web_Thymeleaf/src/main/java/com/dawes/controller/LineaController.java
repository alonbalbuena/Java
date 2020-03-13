package com.dawes.controller;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.dawes.modelo.LineaParadaVO;
import com.dawes.modelo.LineaVO;
import com.dawes.servicios.ServicioLinea;
import com.dawes.servicios.ServicioLineaParada;
import com.dawes.servicios.ServicioParada;

@Controller
@RequestMapping("/linea")
public class LineaController {

	@Autowired
	ServicioLinea sl;

	@Autowired
	ServicioParada sp;

	@Autowired
	ServicioLineaParada slp;

	@RequestMapping("/listaLinea")
	public String listaLinea(Model modelo) {
		modelo.addAttribute("listaLinea", sl.findAll());
		return "/linea/listaLinea";
	}

	@RequestMapping("/formInsertaLinea")
	public String formInsertaLinea(Model modelo) {
		modelo.addAttribute("linea", new LineaVO());
		return "/linea/formInsertaLinea";
	}

	@RequestMapping("/insertaLinea")
	public String insertaLinea(@ModelAttribute LineaVO linea, Model modelo) {
		sl.save(linea);
		modelo.addAttribute("listaLinea", sl.findAll());
		return "/linea/listaLinea";
	}

	@RequestMapping("/eliminaLinea")
	public String eliminaLinea(@RequestParam int idlinea, Model modelo) {
		sl.delete(sl.findById(idlinea).get());
		modelo.addAttribute("listaLinea", sl.findAll());
		return "/linea/listaLinea";
	}

	@RequestMapping("/modificaLinea")
	public String modificaLinea(@RequestParam int idlinea, Model modelo) {
		modelo.addAttribute("linea", sl.findById(idlinea).get());
		return "linea/formModificaLinea";
	}

	@RequestMapping("/guardaLinea")
	public String guardaLinea(@ModelAttribute LineaVO linea, Model modelo) {
		sl.save(linea);
		modelo.addAttribute("listaLinea", sl.findAll());
		return "/linea/listaLinea";
	}

	@RequestMapping("/verParada")
	public String verParada(@RequestParam int idlinea, Model modelo) {
		modelo.addAttribute("linea", sl.findById(idlinea).get());
		return "/linea/paradaLinea";
	}

	/*
	 * Metodo para asignar una parada a una linea
	 */
	@RequestMapping("/insertarParadaEnLinea")
	public String insertarParadaEnLinea(@RequestParam int idlinea, Model modelo) {

		// almacenano en el modelo las paradas de esa linea, utilizando una consulta
		// declarada
		// en el repositorio que busca la coleccion de paradas de la linea utilizando
		// una query
		// con reunión externa izquierda, LETF OUTER JOIN. La carga de la colección en
		// la clase
		// LineaVO es perezosa (fecht=fectchType.LAZY

		modelo.addAttribute("linea", sl.buscarParadasDeLinea(idlinea));

		// como voy a insertar un objeto nuevo del tipo LineaParadaVO, guardo en el
		// modelo
		// un objeto vacío de la clase LineaParadaVO, antes de pasar el control de la
		// navegación
		// al formulario donde lo inserto
		modelo.addAttribute("lineaparada", new LineaParadaVO());

		// almaceno en el modelo todas las paradas que existen, salvo las que ya están
		// añadidas
		modelo.addAttribute("allparadas", sp.getParadasNoAñadidas(idlinea));

		// paso el control de la navegación al formulario donde inserto una nueva
		// LineaParadaVO
		return ("/linea/insertarParadasDeLinea");

	}

	@RequestMapping("/asignarParada")
	public String asignarParada(@ModelAttribute LineaParadaVO lp, @RequestParam int idlinea, Model modelo) {

		// Recupero de la request la información almacenada en la clase LineaParadaVO
		// que son: la marquesina, la idlinea y la idparada
		// A partir de la información anterior, completo el objeto LineaParadaVO con los
		// objetos linea y parada

		lp.setLinea(sl.findById(idlinea).get());
		lp.setParada(sp.findById(lp.getParada().getIdparada()).get());

		// persisto directamente el objeto LineaParadaVO en la tabla intermedia
		slp.save(lp);

		// recargo la información de la linea, ,para mostrar todas las paradas de la
		// linea, incluida la que acabo de crear
		modelo.addAttribute("linea", sl.findById(idlinea).get());

		return "/linea/paradaLinea";
	}

	@RequestMapping("eliminarParadaEnLinea")
	public String eliminarParadaEnLinea(@RequestParam int idlineaparada, int idlinea, Model modelo) {
		slp.deleteById(idlineaparada);
		modelo.addAttribute("linea", sl.findById(idlinea).get());
		return "/linea/paradaLinea";
	}

	/* API REST SIN TENER QUE CREAR UNA CLASE A PARTE */
	@RequestMapping("/consumoJson")
	public String consumoJson(Model modelo) {

		RestTemplate plantilla = new RestTemplate();

		modelo.addAttribute("lista",
				Arrays.stream(plantilla.getForObject("http://localhost:8080/lineas", LineaVO[].class))
						.collect(Collectors.toList()));

		return "/consumoJson";
	}
}
