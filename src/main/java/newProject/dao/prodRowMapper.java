package newProject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import newProject.a.Cliente;
import newProject.a.Producto;

public class prodRowMapper implements RowMapper<Producto>{


		public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
			Producto admin = new Producto();
			admin.setPeso(rs.getString("peso"));
			admin.setPrecio_c(rs.getFloat("precio_c"));
			admin.setPrecio_v(rs.getFloat("precio_v"));
			admin.setProd_nom(rs.getString("prod_nom"));
			admin.setStock(rs.getInt("stock"));
			return admin;
		}

}
