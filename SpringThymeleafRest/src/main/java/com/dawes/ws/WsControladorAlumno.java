package com.dawes.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.modelo.LineaVO;
import com.dawes.servicios.ServicioLineaImpl;

@RestController
@RequestMapping("/lineas")
public class WsControladorAlumno {
	 @Autowired
	 ServicioLineaImpl s;
	 
	 @GetMapping
	 public Iterable<LineaVO> listaLineas(){
		 return s.findAll();
	 }/*devuelve directamente el contenido en vez de una pagina*/

	 @PostMapping
	 public void insertar(@RequestBody LineaVO linea){
		 s.save(linea);
	 }/*solo se puede probar con postman*/
	 //RequestBody permite cojer un objeto en JSON y pasarlo
	 
	 @DeleteMapping(value="/{id}")//Pathvariable notacion donde englobamos la variable a capturar
	 public void borrar(@PathVariable("id") Integer id){
		 s.deleteById(id);
	 }
}
