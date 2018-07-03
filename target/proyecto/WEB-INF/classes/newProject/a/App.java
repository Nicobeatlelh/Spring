package newProject.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		Administrador administrador = (Administrador) applicationContext.getBean("admin"); 
		administrador.imprimirDireccion();
		System.out.println(administrador.toString());
		((ClassPathXmlApplicationContext)applicationContext).close();
    }
}
