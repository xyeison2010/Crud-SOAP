package cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.interfaces.Cliente;

@WebServlet(name = "ServletControlador", urlPatterns = { "/ServletControlador" })
public class TestWeb extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Test test = new Test();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Realizar una determinada accion
		String accion = req.getParameter("accion");
		if (accion != null) {
			switch (accion) {
			case "editar":
				this.editarCliente(req, resp);
				break;
			case "eliminar":
				this.eliminarCliente(req, resp);
				break;

			default:
				this.accionDefault(req, resp);
			}

		} else {
			this.accionDefault(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Realizar una determinada accion
		String accion = req.getParameter("accion");
		if (accion != null) {
			switch (accion) {
			case "insertar":
				this.insertarCliente(req, resp);
				break;
			case "modificar":
				this.modificarCliente(req, resp);
				break;
			case "eliminar":
				this.eliminarCliente(req, resp);
				break;

			default:
				this.accionDefault(req, resp);
			}

		} else {
			this.accionDefault(req, resp);
		}

	}
	protected void accionDefault(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cliente[] clientes = test.getServicioListar();
		System.out.println("clientes = " + clientes);
		HttpSession sesion = req.getSession();
		sesion.setAttribute("clientes", clientes);
		sesion.setAttribute("totalClientes", clientes.length);
		sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
		resp.sendRedirect("clientes.jsp");
	}

	private double calcularSaldoTotal(Cliente[] clientes) {
		double saldoTotal = 0;
		for (Cliente cliente : clientes) {
			saldoTotal += cliente.getSaldo();
		}

		return saldoTotal;
	}

	protected void insertarCliente(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String email = req.getParameter("email");
		String telefono = req.getParameter("telefono");
		double saldo = 0;
		String saldoString = req.getParameter("saldo");
		if (saldoString != null && !"".equals(saldoString))
			saldo = Double.parseDouble(saldoString);
		Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
		int resgistrosModificados = test.getServicioInsertar(cliente);
		this.accionDefault(req, resp);
	}

	protected void modificarCliente(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String email = req.getParameter("email");
		String telefono = req.getParameter("telefono");
		double saldo = 0;
		String saldoString = req.getParameter("saldo");
		if (saldoString != null && !"".equals(saldoString))
			saldo = Double.parseDouble(saldoString);
		Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
		int resgistrosModificados = test.getServicioActualizar(cliente);
		this.accionDefault(req, resp);
	}

	protected void eliminarCliente(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		Cliente cliente = new Cliente(idCliente);
		int registrosModificados = test.getServicioEliminar(cliente);
		this.accionDefault(req, resp);
	}
	
	protected void editarCliente(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  int idCliente=Integer.parseInt(req.getParameter("idCliente"));
		  Cliente cliente = test.getServicioBuscar(new Cliente(idCliente));
		  
		  System.out.println("* Cliente: "+ cliente.getIdCliente()+" "+cliente.getNombre()+" "+cliente.getApellido()+" "+cliente.getSaldo());
		  
		  req.setAttribute("cliente", cliente);
		  String jspEditar="/WEB-INF/paginas/cliente/editarCliente.jsp";
		  req.getRequestDispatcher(jspEditar).forward(req, resp);
	}
		


}
