package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;
import config.Conexion;
import interfaces.EmpleadoCRUD;

public class EmpleadoDAO implements EmpleadoCRUD {
	
	Conexion cn = new Conexion();
	Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public Empleado validar(String user, String dni) {
    	
    	System.out.println("From EmpleadoDAO Method Empleado validar(String "+user+", String "+dni+")");
    	
        Empleado em = new Empleado();
        String sql = "select * from empleado where User=? and Dni=?";
        try {
//            con = cn.Conexion();
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
        } catch (Exception e) {
        }      
        
        return em;
    }
    
    
    public List listar() {    	
    	String sql2="select * from empleado";
    	List<Empleado> lista = new ArrayList<Empleado>();
    	try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			while(rs.next()) {
                Empleado em=new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
//	                em.setId(rs.getInt("IdEmpleado"));
//	                em.setDni(rs.getString("Dni"));
//	                em.setNom(rs.getString("Nombres"));
//	                em.setTel(rs.getString("Telefono"));
//	                em.setEstado(rs.getString("Estado"));
//	                em.setUser(rs.getString("User"));
                lista.add(em);
            }			
		} catch (Exception e) {			
		}      	   	
    	System.out.println("From EmpleadoDAO Method -> List listar() ");
    	for (int i = 0; i < lista.size(); i++) {
    		System.out.println( lista.get(i).getNom());
    		}   	
    	
    	
    	return lista;
    }
    
    public int agregar(Empleado em) {    	
    	
        String sql="insert into empleado(Dni, Nombres, Telefono,Estado,User)values(?,?,?,?,?)";
        
        System.out.println("From EmpleadoDAO Method -> int agregar(Empleado em) ");
        System.out.println(sql);
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);            
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
        System.out.println("respuesta: " +resp);
        return resp;
        
    }        
    
	@Override
	public Empleado listarId(int id) {
        Empleado emp=new Empleado();
        String sql="select * from empleado where IdEmpleado="+id;
        try {
        	con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()) {
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
            
        } catch (Exception e) {
        }
        return emp;
    }
	
    public int actualizar(Empleado em) {
        String sql="update empleado set Dni=?, Nombres=?, Telefono=?,Estado=?,User=? where IdEmpleado=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return resp;
    }
    public void delete(int id) {
        String sql="delete from empleado where IdEmpleado="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }



    
}
