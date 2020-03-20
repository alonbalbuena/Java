package com.dawes.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.modelo.LineaVO;
import com.dawes.modelo.Resultado;
import com.dawes.servicios.ServicioLineaImpl;
import com.google.gson.Gson;

@RestController
@RequestMapping("/lineas")
public class WsControladorAlumno {
	@Autowired
	ServicioLineaImpl s;

	@GetMapping
	public Resultado listaLineas() {

		/*
		 * try { PROBAMOS UNA HTTP REQUEST HttpURLConnection conexion =
		 * (HttpURLConnection) new URL("https://jsonplaceholder.typicode.com/albums")
		 * .openConnection(); conexion.setRequestMethod("GET");
		 * conexion.setConnectTimeout(5000); conexion.setReadTimeout(5000);
		 * 
		 * int status = conexion.getResponseCode(); System.out.println(status); // el
		 * input stream devuelve en bits // el input stream reader lee esos bits en
		 * caracteres // el buffered reader permite leer lineas enteras como si de
		 * paquetes fuese BufferedReader stream = new BufferedReader(new
		 * InputStreamReader(conexion.getInputStream())); StringBuffer documento = new
		 * StringBuffer(); while(!stream.readLine().isBlank())//mientras no esta vacio
		 * el documento documento.append(stream.readLine()); stream.close(); devolvemos
		 * en texto plano System.out.println(documento); conexion.disconnect(); } catch
		 * (ProtocolException e) { e.printStackTrace(); } catch (MalformedURLException
		 * e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		 */

		// creamos el objeto para pasar de texto plano a json
		Gson gson = new Gson();

		/* probamos con la version de JAVA 11 */
		HttpClient cliente = HttpClient.newHttpClient();
		/* URI.create(usado si sabemos que la Url no da error) vs new URL */
		HttpRequest peticion = HttpRequest
				.newBuilder(URI.create(
						"https://raw.githubusercontent.com/BlankerL/DXY-COVID-19-Data/master/json/DXYArea.json"))
				.build();
		/*
		 * enviamos la peticion de forma asincrona rollo JS al servidor desde el cliente
		 * creado
		 */
		return cliente.sendAsync(peticion, HttpResponse.BodyHandlers.ofString())// send devuelve una respuesta
				// le pasamos la peticion y como queremos que nos pase la respuesta(en este caso
				// en String),
				// SENDASYNC devuelve un objeto COmpletableFuture que es para la programacion
				// asincrona (como las promesas de JS)
				.thenApply(respuesta -> respuesta.body())
				//nos devuelve el json al completo
				.thenApply(body -> (Resultado) gson.fromJson(body,Resultado.class))
				//pero lo convertiremos a otro json con los datos que nos interesen(los puestos en las clases)
				.join();// devueve el resultado

		//return s.findAll();
	}/* devuelve directamente el contenido en vez de una pagina */

	@PostMapping
	public void insertar(@RequestBody LineaVO linea) {
		s.save(linea);
	}/* solo se puede probar con postman */
	// RequestBody permite cojer un objeto en JSON y pasarlo

	@DeleteMapping(value = "/{id}") // Pathvariable notacion donde englobamos la variable a capturar
	public void borrar(@PathVariable("id") Integer id) {
		s.deleteById(id);
	}
}
