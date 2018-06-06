package newProject.dao;

import java.util.List;

public interface InterfazGenerics<E> {
	
	public boolean save(E o);
	public boolean actualizar(E o);
	public boolean borrar(int id);
	public E buscarXId(int id);
	public List<E> buscarTodos();
	public List<E> buscarXNombre(String n);
}
