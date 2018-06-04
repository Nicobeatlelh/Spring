package newProject.a;



import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import newProject.dao.AdminDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		AdminDao admindao = (AdminDao) applicationContext.getBean("adminDao"); 
		Timestamp ts = new Timestamp(new Date(05/05/2018).getTime());
		Cliente cli1 = new Cliente();
		cli1.setNom_cli("Jaime");
		cli1.setTel_cli("4567-1264");
		cli1.setDeuda_cli(4520);
		try {
			admindao.save(cli1);
			System.out.println("Registro salvado exitosamente");
			List<Cliente> admins = admindao.buscarTodos();
			for (Cliente admin2 : admins) {
				System.out.println(admin2);
			}
		}catch(CannotGetJdbcConnectionException ex){
			ex.printStackTrace();
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
		((ClassPathXmlApplicationContext)applicationContext).close();
    }
}
