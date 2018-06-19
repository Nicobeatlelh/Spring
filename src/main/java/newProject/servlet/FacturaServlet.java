package newProject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import newProject.a.Cliente2;
import newProject.dao.InterfazGenerics;

/**
 * Servlet implementation class FacturaServlet
 */
public class FacturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacturaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		InterfazGenerics clientdao = (InterfazGenerics) applicationContext.getBean("clientDao");
		String id= request.getParameter("idCliente");
		if(id!="") {
		int id_cliente = Integer.parseInt(id);
		Cliente2 c = (Cliente2) clientdao.buscarXId(id_cliente);
		request.setAttribute("cliente", c);
		
		}
//		String nombre= request.getParameter("nombreCliente");
//		String telefono= request.getParameter("telefonoCliente");
//		String deuda= request.getParameter("deudaCliente");
//		String prod_pref_prod = request.getParameter("prod_pref_prod");
//		String prod_pref_peso = request.getParameter("prod_pref_peso");
//		String imgCliente = request.getParameter("imgCliente");
		
		
		
		
		
		
		request.getRequestDispatcher("Fac.jsp").forward(request, response);
//String redirect = response.encodeRedirectURL(request.getContextPath() + "/Fac.jsp");
//response.sendRedirect(redirect);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
