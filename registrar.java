/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_detei;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hussein y maley
 */
public class registrar {
    String nomb,ape,usua,contra,cor,dir,tel;
    public registrar( String nombre, String apellido,String usuario, String contraseña, String correo, String direccion, String telefono){
        nomb = nombre;
        ape = apellido;
        usua = usuario;
        contra = contraseña;
        cor = correo;
        dir = direccion;
        tel = telefono;
    }
    public void insertar() throws SQLException{
        try{
            conectar con = new conectar();
            Connection reg= con.getConnection();
            PreparedStatement pps = reg.prepareStatement("INSERT INTO usuarios(nombre,apellido,usuario,contraseña,correo,direccion,telefono) VALUES(?,?,?,?,?,?,?)");
            pps.setString(1,nomb);
            pps.setString(2,ape);
            pps.setString(3,usua);
            pps.setString(4,contra);
            pps.setString(5,cor);
            pps.setString(6,dir);
            pps.setString(7,tel);
            pps.executeUpdate();
            con.desconectar();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"fallo de conexion "+e);
        }
            
        JOptionPane.showMessageDialog(null,"datos guardados");
    }
}
