package newProject.a;

public class Producto {
	private int id_prod;
	private String nombre;
	private int id_tp;
	public int getId_prod() {
		return id_prod;
	}
	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId_tp() {
		return id_tp;
	}
	public void setId_tp(int id_tp) {
		this.id_tp = id_tp;
	}
	@Override
	public String toString() {
		return "Producto [id_prod=" + id_prod + ", nombre=" + nombre + ", id_tp=" + id_tp + "]";
	}
	public Producto() {
		super();
	}
	public Producto(int id_prod, String nombre, int id_tp) {
		super();
		this.id_prod = id_prod;
		this.nombre = nombre;
		this.id_tp = id_tp;
	}
	public Producto(String nombre, int id_tp) {
		super();
		this.nombre = nombre;
		this.id_tp = id_tp;
	}
	
}
