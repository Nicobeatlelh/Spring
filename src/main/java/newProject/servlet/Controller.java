package newProject.servlet;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import newProject.a.Cliente;

@RestController
public class Controller {

	private static final String template = "Hola, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/clientes")
    public Cliente impr(@RequestParam(value="nombre", defaultValue="World") String name,
    		@RequestParam(value="telefono", defaultValue="4231") String tel,
    		@RequestParam(value="deuda") int deu){
        return new Cliente(String.format(template, name), tel, deu);
    }
}


