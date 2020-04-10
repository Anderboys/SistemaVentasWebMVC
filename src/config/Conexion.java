package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
//	 Connection con;
//	    String url="jdbc:mysql://localhost:3306/bd_ventas";
//	    String user="root";
//	    String pass="";
//	    public Connection Conexion(){
//	        try {
//	            Class.forName("com.mysql.jdbc.Driver");
//	            con=DriverManager.getConnection(url,user,pass);
//	        } catch (Exception e) {
//	        }
//	        return con;
//	    }
	   private static Connection con;
	    private static final String driver="com.mysql.cj.jdbc.Driver";
	    private static final String user="root";
	    private static final String password="";
	    private static final String url="jdbc:mysql://localhost:3306/bd_ventas?serverTimezone=UTC";
	    public Conexion(){
	        con = null;
	        try {
	            Class.forName(driver);
	            con= DriverManager.getConnection(url,user,password);
	            if(con!=null){
	                System.out.println("Conexion establecida");
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            System.err.println("Fatality Error Conexion GG "+e);

	        }
	    }

	    public Connection getConnection(){
	        return con;
	    }
}
