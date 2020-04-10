package interfaces;

import java.util.List;

import modelo.Producto;

public interface ProductoCRUD {
	
	
	public List listar();	
	public void agregar(Producto pro);
	public void actualizar(Producto pro);
	public Producto listarId(int id);
	public void delete(int id);

}
