package newProject.a;

import org.springframework.beans.factory.annotation.Autowired;

public class Administrador {
	
	private int idAd;
	private String nombre;
	
	@Autowired
	private Direccion direc;
	
	public void setDireccion(Direccion direc) {
		this.direc = direc;
	}
		
	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Administrador(int idAd, String nombre) {
		
		this.idAd = idAd;
		this.nombre = nombre;
	}

	public Administrador() {
		
	}

	



	@Override
	public String toString() {
		return "Administrador [idAd=" + idAd + ", nombre=" + nombre + ", direc=" + direc + "]";
	}

	public void imprimirDireccion() {
		System.out.println("Clase de TGV");
	}
}
