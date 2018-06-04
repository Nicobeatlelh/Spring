package newProject.a;

import java.sql.Timestamp;

public class Cliente {
	private int id_cli;
	private String nom_cli;
	private String tel_cli;
	private int deuda_cli;
	private int prod_pref;
	
	
	public int getId_cli() {
		return id_cli;
	}


	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}


	public String getNom_cli() {
		return nom_cli;
	}


	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}


	public String getTel_cli() {
		return tel_cli;
	}


	public void setTel_cli(String tel_cli) {
		this.tel_cli = tel_cli;
	}


	public int getDeuda_cli() {
		return deuda_cli;
	}


	public void setDeuda_cli(int deuda_cli) {
		this.deuda_cli = deuda_cli;
	}


	public int getProd_pref() {
		return prod_pref;
	}


	public void setProd_pref(int prod_pref) {
		this.prod_pref = prod_pref;
	}
	
	

	@Override
	public String toString() {
		return "Cliente [id_cli=" + id_cli + ", nom_cli=" + nom_cli + ", tel_cli=" + tel_cli + ", deuda_cli="
				+ deuda_cli + ", prod_pref=" + prod_pref + "]";
	}


	public Cliente(int id_cli, String nom_cli, String tel_cli, int deuda_cli, int prod_pref) {
		super();
		this.id_cli = id_cli;
		this.nom_cli = nom_cli;
		this.tel_cli = tel_cli;
		this.deuda_cli = deuda_cli;
		this.prod_pref = prod_pref;
	}

	
	public Cliente() {
	}
	
	
}
