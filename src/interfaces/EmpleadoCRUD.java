package interfaces;

import java.util.List;

import modelo.Empleado;

public interface EmpleadoCRUD {
	
	public Empleado validar(String user, String dni);
	public List listar();	
	public int agregar(Empleado em);
	public int actualizar(Empleado em);
	public Empleado listarId(int id);
	public void delete(int id);
}
