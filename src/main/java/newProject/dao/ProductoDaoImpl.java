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
import newProject.a.Producto;

@Component("prodDao")
public class ProductoDaoImpl implements InterfazGenerics<Producto>{
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate((javax.sql.DataSource) dataSource);
	}
	
	public boolean save(Producto prod) {
		// TODO Auto-generated method stub
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(prod);
		
		return jdbcTemplate.update("insert into Producto (peso,prod_nom,stock,precio_c,precio_v) values (:peso,:prod_nom,:stock,:precio_c,:precio_v)", paramMap) == 1;
	}


	public List<Producto> buscarTodos() {
		return jdbcTemplate.query("Select * from Producto", new RowMapper<Producto>() {

			public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Producto prod = new Producto();
				prod.setPeso(rs.getString("peso"));
				prod.setPrecio_c(rs.getFloat("precio_c"));
				prod.setPrecio_v(rs.getFloat("precio_v"));
				prod.setProd_nom(rs.getString("prod_nom"));
				prod.setStock(rs.getInt("stock"));
				return prod;
			}
		});
	}

	public Producto buscarXId(int id) {
		//return jdbcTemplate.query("Select * from prod where idad = :idAd", new MapSqlParameterSource("idAd",id),new prodRowMapper());
		//return jdbcTemplate.queryForObject("Select * from Producto where id_cli = :id_cli", new MapSqlParameterSource("id_cli",id),new prodRowMapper());
		return null;
	}

	public List<Producto> buscarXNombre(String nombre) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("Select * from Producto where prod_nom = :prod_nom",new MapSqlParameterSource("prod_nom", "%" + nombre + "%"), new prodRowMapper());

	}


	public boolean actualizar(Producto prod) {
		// BeanPropertySqlParameterSource, porque los campos de nuestra tabla son identicos al de nuestra clase
		return jdbcTemplate.update("Update Clientes set nom_cli:nom_cli, tel_cli:tel_cli, deuda_cli:deuda_cli where id_cli=:id_cli ", 
				new BeanPropertySqlParameterSource(prod)) == 1;
	}

	public boolean borrar(int idAd) {
		// MapSqlParameterSource porque solo enviamos un parametro
		return jdbcTemplate.update("delete from Clientes Where id_cli=id_cli", new MapSqlParameterSource("id_cli",idAd)) == 1;
	}

	public void grabarTodos(List<Producto> prods) {
		// TODO Auto-generated method stub
		
	}

	public Producto buscarXNombreYPeso(String nombre, String peso) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from Producto where prod_nom = :prod_nom and peso = :peso",new MapSqlParameterSource("prod_nom", nombre).addValue("peso", peso), new prodRowMapper());
	}

	
}
