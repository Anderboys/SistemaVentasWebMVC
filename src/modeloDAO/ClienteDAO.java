package modeloDAO;
import modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;
import interfaces.ClienteCRUD;

public class ClienteDAO implements ClienteCRUD {
	
	Conexion cn = new Conexion();
	Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

	@Override
	public Cliente buscar(String dni) {
        Cliente c=new Cliente();
        String sql="Select * from cliente where Dni="+dni;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDirec(rs.getString(4));                
                c.setEstado(rs.getString(5));                
            }
        } catch (Exception e) {
        }
        return c;
    }

	@Override
	public List listar() {    	
    	String sql2="select * from cliente";
    	List<Cliente> lista = new ArrayList<Cliente>();
    	try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			while(rs.next()) {
				
                Cliente em=new Cliente();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setDirec(rs.getString(4));
                em.setEstado(rs.getString(5));               
                lista.add(em);
            }			
		} catch (Exception e) {			
		}      	   	
    	System.out.println("From ClienteDAO Method -> List listar() ");
    	for (int i = 0; i < lista.size(); i++) {
    		System.out.println( lista.get(i).getNom());
    		}   	
    	
    	
    	return lista;
    }

	@Override
	public int agregar(Cliente cl) { 
        String sql="insert into cliente(Dni, Nombres, Direccion,Estado)values(?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNom());
            ps.setString(3, cl.getDirec());
            ps.setString(4, cl.getEstado());           
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return resp;
        
    }
	
	@Override
	public Cliente listarId(int id) {
        Cliente cli=new Cliente();
        String sql="select * from cliente where IdCliente="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDirec(rs.getString(4));
                cli.setEstado(rs.getString(5));              
            }
        } catch (Exception e) {
        }
        return cli;
    }

	@Override
	public int actualizar(Cliente em) {
        String sql="update cliente set Dni=?, Nombres=?, Direccion=?,Estado=? where IdCliente=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getDirec());
            ps.setString(4, em.getEstado());           
            ps.setInt(5, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return resp;
    }



	@Override
	public void delete(int id) {
        String sql="delete from cliente where IdCliente="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }





}
