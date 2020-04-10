package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Empleado;
import modeloDAO.EmpleadoDAO;

@WebServlet("/Validar")
public class Validar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	EmpleadoDAO edao = new EmpleadoDAO();
	Empleado emp = new Empleado();	
	
//	doGet
//	doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
//		doGet(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// nombre del botoon q esta realizando la accion =
     //	        input type="submit"  -> name="accion" <-   
//		                       <button  name="accion" value="Ingresar"  -> name="accion" <-
		String action = request.getParameter("accion");
		// el valor del bottom es ingresar --> value="Ingresar"
		
		if(action.equalsIgnoreCase("Ingresar")) {
			
			String usu= request.getParameter("txtuser");
			String pass= request.getParameter("txtpass");
			
			emp = edao.validar(usu, pass);	
			
			
			if(emp.getUser()!= null) {				
				// enviar datos Attribute = usuario + objeto = emp
				request.setAttribute("usuario", emp);				
				request.getRequestDispatcher("Controlador?menu=Principalxx").forward(request, response);
//				request.getRequestDispatcher("principal.jsp").forward(request, response);	
			}else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
				
	}
	
	 
	 	

	
	

}
