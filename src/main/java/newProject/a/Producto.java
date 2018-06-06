package newProject.a;

import java.sql.Date;

public class Producto {
	private int id_prod;
	private String nombre;
	private int id_tp;
	private int stock;
	private int precio_c;
	private int precio_v;
	private Date fua;
	private String img_tp;
	
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrecio_c() {
		return precio_c;
	}
	public void setPrecio_c(int precio_c) {
		this.precio_c = precio_c;
	}
	public int getPrecio_v() {
		return precio_v;
	}
	public void setPrecio_v(int precio_v) {
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
	public Producto(String nombre, int stock, int precio_c, int precio_v, Date fua, String img_tp) {
		super();
		this.nombre = nombre;
		this.stock = stock;
		this.precio_c = precio_c;
		this.precio_v = precio_v;
		this.fua = fua;
		this.img_tp = img_tp;
	}
	public Producto(int id_prod, String nombre, int id_tp, int stock, int precio_c, int precio_v, Date fua,
			String img_tp) {
		super();
		this.id_prod = id_prod;
		this.nombre = nombre;
		this.id_tp = id_tp;
		this.stock = stock;
		this.precio_c = precio_c;
		this.precio_v = precio_v;
		this.fua = fua;
		this.img_tp = img_tp;
	}
	
}
