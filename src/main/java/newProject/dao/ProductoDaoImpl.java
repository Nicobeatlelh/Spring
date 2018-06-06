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
		
		return jdbcTemplate.update("insert into Producto (nombre,id_tp) values (:nombre,:id_tp)", paramMap) == 1;
	}


	public List<Producto> buscarTodosSinJoin() {
		return jdbcTemplate.query("Select * from Producto", new RowMapper<Producto>() {

			public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Producto prod = new Producto();
				prod.setId_prod(rs.getInt("id_prod"));
				prod.setNombre(rs.getString("nombre"));
				prod.setId_tp(rs.getInt("id_tp"));
				return prod;
			}
		});
	}
	public List<Producto> buscarTodos() {
		return jdbcTemplate.query("select p.nombre, t.stock,t.precio_c,t.precio_v,t.fua, t.img_tp " + 
				"from Producto as p " + 
				"inner join Tipo_prod as t " + 
				"on t.id_tp=p.id_tp", new RowMapper<Producto>() {

			public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Producto prod = new Producto();
				prod.setNombre(rs.getString("nombre"));
				prod.setStock(rs.getInt("stock"));
				prod.setPrecio_c(rs.getInt("precio_c"));
				prod.setPrecio_v(rs.getInt("precio_v"));
				prod.setFua(rs.getDate("fua"));
				prod.setImg_tp(rs.getString("img_tp"));
				return prod;
			}
		});
	}

	public Producto buscarXId(int id) {
		//return jdbcTemplate.query("Select * from prod where idad = :idAd", new MapSqlParameterSource("idAd",id),new prodRowMapper());
		//return jdbcTemplate.queryForObject("Select * from Clientes where id_cli = :id_cli", new MapSqlParameterSource("id_cli",id),new ClienteRowMapper());
		return null;
	}

	public List<Producto> buscarXNombre(String nombre) {
		// TODO Auto-generated method stub
		//return jdbcTemplate.query("Select * from Clientes where nom_cli like :nom_cli",new MapSqlParameterSource("nom_cli", "%" + nombre + "%"), new ClienteRowMapper());
		return null;
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

	
}
