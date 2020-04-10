package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import config.Conexion;
import interfaces.ProductoCRUD;

import modelo.Producto;

public class ProductoDAO implements ProductoCRUD {

	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;	
	
    int resp;	

	@Override
	public List listar() {    	
    	String sql2="select * from producto";
    	List<Producto> lista = new ArrayList<Producto>();
    	try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			while(rs.next()) {
				
                Producto pro=new Producto();
                pro.setId(rs.getInt(1));
                pro.setNom(rs.getString(2));
                pro.setPre(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));
                               
                lista.add(pro);
            }			
		} catch (Exception e) {			
		}      	   	
    	System.out.println("From ProductoDAO Method -> List listar() ");
    	for (int i = 0; i < lista.size(); i++) {
    		System.out.println( lista.get(i).getNom());
    		}   	
    	    	
    	return lista;
    }

	@Override
	public void agregar(Producto pro) { 
		
        String sql="insert into producto(Nombres, Precio,Stock,Estado)values(?,?,?,?)";
        System.out.println(sql); 
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getNom());
            ps.setDouble(2, pro.getPre());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());        
            ps.executeUpdate();
        } catch (Exception e) {
        }        
        
        System.out.println("From ProductoDAO Method -> agregar(Producto pro) ");
        System.out.println("respuesta: " +resp);
//        return resp;
        
    }

	
	@Override
	public Producto listarId(int id) {
        Producto pr=new Producto();
        String sql="select * from producto where IdProducto="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                pr.setId(rs.getInt(1));
                pr.setNom(rs.getString(2));               
                pr.setPre(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getString(5));  
            }
        } catch (Exception e) {
        }
        
        System.out.println("From ProductoDAO Method -> listarId(int id) ");
        return pr;
    }
	
	
	@Override
	public void actualizar(Producto pro) {
		String sql="update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        System.out.println(sql); 
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getNom());
            ps.setDouble(2, pro.getPre());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado()); 
            ps.setInt(5, pro.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }        
        
        System.out.println("From ProductoDAO Method -> actualizar(Producto pro) ");      
        
	}



	@Override
	public void delete(int id) {
        String sql="delete from producto where IdProducto="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
        System.out.println("From ProductoDAO Method -> delete(int id) ");  
    }

}
