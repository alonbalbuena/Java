

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Proceso
 */
@WebServlet("/Proceso")
public class Proceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//recogida de datos q queremos mostrar
		 HttpSession sesion = request.getSession();
		
		 sesion.setAttribute("nombre", request.getParameter("nombre"));
		 sesion.setAttribute("mail", request.getParameter("mail"));
		 
		 
		 //reenviar informacion a jsp
		 RequestDispatcher dispacher = request.getRequestDispatcher("mostrar.jsp");
		 dispacher.forward(request, response);
	
		 
	
	
	}
}
	


		


