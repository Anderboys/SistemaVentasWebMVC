package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import modelo.Empleado;
import modelo.Producto;
import modeloDAO.ClienteDAO;
import modeloDAO.EmpleadoDAO;
import modeloDAO.ProductoDAO;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Empleado em = new Empleado();
	EmpleadoDAO edao = new EmpleadoDAO();
	int idemp;

	Cliente cli = new Cliente();
	ClienteDAO clidao = new ClienteDAO();
	int idcli;

	Producto pro = new Producto();
	ProductoDAO pdao = new ProductoDAO();
	int idpro;

	public Controlador() {
		super();
		// TODO Auto-generated constructor stub
	}

//	doGet
//	doPost

//    service
//    @Override

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//	response.getWriter().append("Served at: ").append(request.getContextPath());

		String menu = request.getParameter("menu");
		String accion = request.getParameter("accion");

		System.out.println("valor de menu ->> " + menu);
		System.out.println("valor de accion ->> " + accion);

		if (menu.equals("Principalxx")) {
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		}

		if (menu.equals("Producto")) {

			switch (accion) {
			case "Listar":
				List lista = pdao.listar();
				// enviar datos Attribute = empleados + objeto = emp
				request.setAttribute("productos", lista);
				break;

			case "Agregar":

				String nom = request.getParameter("txtNombres");
				Double pre = Double.parseDouble(request.getParameter("txtPre"));
				Integer stock = Integer.parseInt(request.getParameter("txtStock"));
				String estado = request.getParameter("txtEstado");
				System.out.println(nom + " " + pre + " " + stock + " " + estado);
				pro.setNom(nom);
				pro.setPre(pre);
				pro.setStock(stock);
				pro.setEstado(estado);
				pdao.agregar(pro);

//				 Redirecciona el Listar
				request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

				break;

			case "ListarByID":
				idpro = Integer.parseInt(request.getParameter("id"));
				pro = pdao.listarId(idpro);
				request.setAttribute("productoXD", pro);
				// Redirecciona el Listar
				request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
				break;

			case "Actualizar":

				String nom1 = request.getParameter("txtNombres");
				Double pre1 = Double.parseDouble(request.getParameter("txtPre"));
				Integer stock1 = Integer.parseInt(request.getParameter("txtStock"));
				String estado1 = request.getParameter("txtEstado");

				pro.setNom(nom1);
				pro.setPre(pre1);
				pro.setStock(stock1);
				pro.setEstado(estado1);
				pro.setId(idpro);
				pdao.actualizar(pro);

//				 Redirecciona el Listar
				request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

				break;

			case "Delete":
				idpro = Integer.parseInt(request.getParameter("id"));
				pdao.delete(idpro);
//				 Redirecciona el Listar
				request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

				break;

			default:
				throw new AssertionError();
			}

			request.getRequestDispatcher("producto.jsp").forward(request, response);
		}

		if (menu.equalsIgnoreCase("Empleado")) {

			switch (accion) {
			case "Listar":
				List lista = edao.listar();
				// enviar datos Attribute = empleados + objeto = emp
				request.setAttribute("empleados", lista);
				break;

			case "Agregar":

				String dni = request.getParameter("txtDni");
				String nom = request.getParameter("txtNombre");
				String tel = request.getParameter("txtTel");
				String estado = request.getParameter("txtEstado");
				String user = request.getParameter("txtUser");

				System.out.println(dni + " " + nom + " " + tel + " " + estado + " " + user);

				em.setDni(dni);
				em.setNom(nom);
				em.setTel(tel);
				em.setEstado(estado);
				em.setUser(user);
				edao.agregar(em);

				// Redirecciona el Listar
				request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

				break;
			case "Editar":
				idemp = Integer.parseInt(request.getParameter("id"));
				Empleado e = edao.listarId(idemp);
				request.setAttribute("empleado", e);
				// Redirecciona el Listar
				request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
				break;

			case "Actualizar":

				String dni2 = request.getParameter("txtDni");
				String nom2 = request.getParameter("txtNombre");
				String tel2 = request.getParameter("txtTel");
				String estado2 = request.getParameter("txtEstado");
				String user2 = request.getParameter("txtUser");
				System.out.println("Actualizar");
				System.out.println(dni2 + " " + nom2 + " " + tel2 + " " + estado2 + " " + user2);

				em.setDni(dni2);
				em.setNom(nom2);
				em.setTel(tel2);
				em.setEstado(estado2);
				em.setUser(user2);
				// id selecionado captura cuando presionan Editar
				em.setId(idemp);
				edao.actualizar(em);

				// Redirecciona el Listar
				request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
				break;
			case "Delete":
				idemp = Integer.parseInt(request.getParameter("id"));
				edao.delete(idemp);
				// Redirecciona el Listar
				request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
				break;

			default:
				throw new AssertionError();
			}

			request.getRequestDispatcher("empleado.jsp").forward(request, response);

		}

		if (menu.equals("Cliente")) {

			switch (accion) {
			case "Listar":
				List lista = clidao.listar();
				// enviar datos Attribute = empleados + objeto = emp
				request.setAttribute("clientes", lista);
				break;
			case "Agregar":
				String dni = request.getParameter("txtDni");
				String nom = request.getParameter("txtNombres");
				String tel = request.getParameter("txtTel");
				String est = request.getParameter("txtEstado");

				cli.setDni(dni);
				cli.setNom(nom);
				cli.setDirec(tel);
				cli.setEstado(est);
				clidao.agregar(cli);
				request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
				break;
			case "Editar":
				idcli = Integer.parseInt(request.getParameter("id"));
				Cliente cl = clidao.listarId(idcli);
				request.setAttribute("cliente", cl);
				request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
				break;
			case "Actualizar":
				String dni1 = request.getParameter("txtDni");
				String nom1 = request.getParameter("txtNombres");
				String tel1 = request.getParameter("txtTel");
				String est1 = request.getParameter("txtEstado");

				cli.setDni(dni1);
				cli.setNom(nom1);
				cli.setDirec(tel1);
				cli.setEstado(est1);
				cli.setId(idcli);
				clidao.actualizar(cli);
				request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
				break;
			case "Delete":
				idcli = Integer.parseInt(request.getParameter("id"));
				clidao.delete(idcli);
				request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
				break;

			default:
				throw new AssertionError();
			}

			request.getRequestDispatcher("cliente.jsp").forward(request, response);

		}

		if (menu.equals("NuevaVenta")) {
			request.getRequestDispatcher("registrarVenta.jsp").forward(request, response);
		}
	}

}
