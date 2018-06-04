package newProject.dao;

import java.util.List;

import newProject.a.Cliente;

public interface AdminDao {

	public boolean save(Cliente admin);
	public List<Cliente> buscarTodos();
	public Cliente buscarXId(int id);
	public List<Cliente> buscarXNombre(String nombre);
	public boolean actualizar(Cliente admin);
	public boolean borrar(int idAd);
	public void grabarTodos(List<Cliente> admins);
}
