package newProject.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import newProject.a.Producto;
import newProject.dao.InterfazGenerics;

/**
 * Servlet implementation class ProductosServlet
 */
public class ProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String peso = request.getParameter("peso");
		String nom = request.getParameter("nombre");
		String stockS = request.getParameter("stock");
		int stock = Integer.parseInt(stockS);
		String precio_cS = request.getParameter("precio_c");
		float precio_c = Float.parseFloat(precio_cS);
		String precio_vS = request.getParameter("precio_v");
		float precio_v = Float.parseFloat(precio_vS);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		InterfazGenerics proddao = (InterfazGenerics) applicationContext.getBean("prodDao");
		Producto prod = new Producto(peso,nom,stock,precio_c,precio_v);
		try {
			proddao.save(prod);
			System.out.println("Registro salvado exitosamente");
//			List<Producto> admins = proddao.buscarTodos();
//			for (Producto admin2 : admins) {
//				System.out.println(admin2);
//			}
		} catch (CannotGetJdbcConnectionException ex) {
			ex.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		((ClassPathXmlApplicationContext) applicationContext).close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
