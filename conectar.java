/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_detei;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author hussein y maley
 */
public class conectar {
    private static Connection conn;
    private static final String driver= "com.mysql.jdbc.Driver";
    private static final String user= "root";
    private static final String pass= "";
    private static final String url= "jdbc:mysql://localhost:3306/detei";
    
    public conectar(){
        conn= null;
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,pass);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"error de conexion" + e);
        }    
    }
    public Connection getConnection(){
        return conn;
    }
    
    public void desconectar(){
        conn = null;
    }
}
