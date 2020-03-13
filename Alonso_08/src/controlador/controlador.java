package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.NumeroVO;

@WebServlet("/controlador")
public class controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//intentos(variable compartida por todas las peticiones y usuarios)
	private int peticiones;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//obtenemos la sesion anterior
		HttpSession sesion = request.getSession();
		
		//obtenemos el numero del formulario
		int numeroConvertido = 0;
		try {
			numeroConvertido = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			System.out.println("Error ParseInt");
		}
		
		//genermaos el numero aleatorio 
		//SI YA TENEMOS UNO CREADO EN LA SESION NO INTRODUCIMOS NADA
		NumeroVO numeroAleatorio = (NumeroVO) sesion.getAttribute("numeroAleatorio");
		if(numeroAleatorio == null ) {			
			numeroAleatorio = new NumeroVO();
		}
		
		//comparamos los dos numeros
		String comparacion = "";
		if(numeroConvertido > numeroAleatorio.getNumero()) {
			comparacion = "Tu numero supera al generado";
		}else if(numeroConvertido == numeroAleatorio.getNumero()) {
			comparacion = "HAS GANADO";
		}else {
			comparacion = "Tu numero es inferior al generado ";
		}

		//aumentamos el numero de peticiones
		peticiones++;
		
		//DATOS JSP ---------------------------------------------
		
		//enviamos los datos al jsp
		request.setAttribute("comparacion", comparacion);
		request.setAttribute("peticiones", peticiones);
		
		//DATOS SESION----------------------------------------------------
		
		//el numero generado lo guardamos en sesion para que sea propio de cada persona
		//tambien guardamos los intentos DEL PROPIO USUARIO
		sesion.setAttribute("numeroAleatorio", numeroAleatorio);
		
		//la primera vez que ejecutamos la sesion creamos el intento
		Integer intento = (Integer) sesion.getAttribute("intentos");//cojemos los valores de la sesion anterior y le sumamos uno
		if(intento == null) {
			intento = 0;
		}
		sesion.setAttribute("intentos", intento.intValue() + 1 );
		
		
		//REINICIAR LA SESION------------------------------------------------
		if(request.getParameter("reiniciarSesion") != null && request.getParameter("reiniciarSesion").equals("reiniciar")) {
			sesion.setAttribute("intentos", 0);//reinicio los intentos
			sesion.setAttribute("numeroAleatorio", new NumeroVO());//genero un nuevo numero
		}
		
		
		//reenviamos la informacion al jsp
		RequestDispatcher rd = request.getRequestDispatcher("/pagina.jsp");
		rd.forward(request, response);
	}


}
