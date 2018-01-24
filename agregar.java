/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_detei;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hussein y maley
 */
public class agregar {
    String nombre,rfc,direccion,telefono;
    File ruta;
    
    public agregar(String nom, File rut, String rf, String direc, String tel){
        nombre= nom;
        ruta = rut;
        rfc = rf;
        direccion = direc;
        telefono = tel;
    }
    public void nuevo() throws SQLException{
        byte[] icono = new byte[(int) ruta.length()];
        try{
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
        }catch(Exception ex){
            
        }
        try{
                conectar con = new conectar();
                Connection reg= con.getConnection();
                PreparedStatement pps = reg.prepareStatement("INSERT INTO clientes(nombre,foto,rfc,direccion,telefono) VALUES(?,?,?,?,?)");
                pps.setString(1,nombre);
                pps.setBytes(2,icono);
                pps.setString(3,rfc);
                pps.setString(4,direccion);
                pps.setString(5,telefono);
                pps.executeUpdate();
                con.desconectar();
             }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"fallo de conexion "+e);
        }
            
        JOptionPane.showMessageDialog(null,"datos guardados");
    }
}
