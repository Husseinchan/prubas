/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_detei;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hussein y maley
 */
public class modificar {
    String nombre,rfc1,direccion,telefono;
    File ruta;
    
    public modificar(String nom, File rut, String rfc, String dir, String tel){
        nombre = nom;
        ruta = rut;
        rfc1 = rfc;
        direccion = dir;
        telefono = tel;
    }
    public void mod(){
        byte[] icono = new byte[(int) ruta.length()];
        try{
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
        }catch(IOException ex){
            
        }
        try{
                conectar con = new conectar();
                Connection reg= con.getConnection();
                PreparedStatement pps = reg.prepareStatement("UPDATE 'clientes' SET('nombre'=[?],'foto'=[?],'rfc'=[?],'direccion'=[?],'telefono'=[?]) WHERE nombre=? OR foto=? OR rfc = ? OR direccion=? OR telefono = ?");
                pps.setString(1,nombre);
                pps.setBytes(2,icono);
                pps.setString(3,rfc1);
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
