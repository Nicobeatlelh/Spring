package newProject.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import newProject.a.App;
import newProject.a.Cliente;
import newProject.dao.AdminDao;
import newProject.dao.InterfazGenerics;

/**
 * Servlet implementation class ClientesServlet
 */
public class ClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nombre");
		String tel = request.getParameter("telefono");
		int deu = Integer.parseInt(request.getParameter("deuda"));
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		InterfazGenerics clientdao = (InterfazGenerics) applicationContext.getBean("clientDao");
		Cliente cli1 = new Cliente();
		cli1.setNom_cli(nom);
		cli1.setTel_cli(tel);
		cli1.setDeuda_cli(deu);
		try {
			clientdao.save(cli1);
			System.out.println("Registro salvado exitosamente");
			List<Cliente> admins = clientdao.buscarTodos();
			for (Cliente admin2 : admins) {
				System.out.println(admin2);
			}
		} catch (CannotGetJdbcConnectionException ex) {
			ex.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		((ClassPathXmlApplicationContext) applicationContext).close();
	}
}
