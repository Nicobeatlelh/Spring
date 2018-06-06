package newProject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import newProject.a.Cliente;

@Component("clientDao")
public class ClienteDaoImpl implements InterfazGenerics<Cliente> {

	private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate((javax.sql.DataSource) dataSource);
	}
	
	public boolean save(Cliente admin) {
		// TODO Auto-generated method stub
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);
		
		return jdbcTemplate.update("insert into Clientes (nom_cli,tel_cli,deuda_cli) values (:nom_cli,:tel_cli,:deuda_cli)", paramMap) == 1;
	}


	public List<Cliente> buscarTodos() {
		return jdbcTemplate.query("Select * from Clientes", new RowMapper<Cliente>() {

			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cliente admin = new Cliente();
				admin.setId_cli(rs.getInt("id_cli"));
				admin.setNom_cli(rs.getString("nom_cli"));
				admin.setTel_cli(rs.getString("tel_cli"));
				admin.setDeuda_cli(rs.getInt("deuda_cli"));
				return admin;
			}
		});
	}

	public Cliente buscarXId(int id) {
		//return jdbcTemplate.query("Select * from Admin where idad = :idAd", new MapSqlParameterSource("idAd",id),new AdminRowMapper());
		return jdbcTemplate.queryForObject("Select * from Clientes where id_cli = :id_cli", new MapSqlParameterSource("id_cli",id),new ClienteRowMapper());
	}

	public List<Cliente> buscarXNombre(String nombre) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("Select * from Clientes where nom_cli like :nom_cli",new MapSqlParameterSource("nom_cli", "%" + nombre + "%"), new ClienteRowMapper());
	}

	public boolean actualizar(Cliente admin) {
		// BeanPropertySqlParameterSource, porque los campos de nuestra tabla son identicos al de nuestra clase
		return jdbcTemplate.update("Update Clientes set nom_cli:nom_cli, tel_cli:tel_cli, deuda_cli:deuda_cli where id_cli=:id_cli ", 
				new BeanPropertySqlParameterSource(admin)) == 1;
	}

	public boolean borrar(int idAd) {
		// MapSqlParameterSource porque solo enviamos un parametro
		return jdbcTemplate.update("delete from Clientes Where id_cli=id_cli", new MapSqlParameterSource("id_cli",idAd)) == 1;
	}

	public void grabarTodos(List<Cliente> admins) {
		// TODO Auto-generated method stub
		
	}





}
