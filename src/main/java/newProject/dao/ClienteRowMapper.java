package newProject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import newProject.a.Cliente;


public class ClienteRowMapper implements RowMapper<Cliente> {

	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente admin = new Cliente();
		admin.setId_cli(rs.getInt("id_cli"));
		admin.setNom_cli(rs.getString("nom_cli"));
		admin.setTel_cli(rs.getString("tel_cli"));
		admin.setDeuda_cli(rs.getInt("deuda_cli"));
		return admin;
	}

}
