package newProject.a;
import java.sql.Date;

public class Producto {

	private String prod_nom;
	private String peso;
	private int stock;
	private float precio_c;
	private float precio_v;
	private Date fua;
	private String img_tp;
	
	
	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getProd_nom() {
		return prod_nom;
	}

	public void setProd_nom(String prod_nom) {
		this.prod_nom = prod_nom;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrecio_c() {
		return precio_c;
	}

	public void setPrecio_c(float precio_c) {
		this.precio_c = precio_c;
	}

	public float getPrecio_v() {
		return precio_v;
	}

	public void setPrecio_v(float precio_v) {
		this.precio_v = precio_v;
	}

	public Date getFua() {
		return fua;
	}

	public void setFua(Date fua) {
		this.fua = fua;
	}

	public String getImg_tp() {
		return img_tp;
	}

	public void setImg_tp(String img_tp) {
		this.img_tp = img_tp;
	}


	public Producto() {
		super();
	}

	public Producto(String peso, String prod_nom, int stock, float precio_c, float precio_v) {
		super();
		this.peso = peso;
		this.prod_nom = prod_nom;
		this.stock = stock;
		this.precio_c = precio_c;
		this.precio_v = precio_v;
	}

	public Producto(String peso, String prod_nom, int stock, float precio_c) {
		super();
		this.peso = peso;
		this.prod_nom = prod_nom;
		this.stock = stock;
		this.precio_c = precio_c;
	}
	
	
	
}
