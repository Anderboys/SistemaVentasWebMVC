package interfaces;

import java.util.List;

import modelo.Cliente;

public interface ClienteCRUD {
	
	public Cliente buscar(String dni);
	
	
	//*******Operaciones CRUD***************//
	public List listar();	
	public int agregar(Cliente em);
	public int actualizar(Cliente em);
	public Cliente listarId(int id);
	public void delete(int id);

}
