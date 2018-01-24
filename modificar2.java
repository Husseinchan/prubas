/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_detei;

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
public class modificar2 {
    String nom,rf,dir,tel;
    public modificar2(String nombre, String rfc, String direccion, String tele){
        nom = nombre;
        rf = rfc;
        dir= direccion;
        tel = tele;
    }
    public void mod2(){
        try{
                conectar con = new conectar();
                Connection reg= con.getConnection();
                PreparedStatement pps = reg.prepareStatement("UPDATE clientes SET(nombre='?',rfc='?',direccion='?',telefono='?') WHERE rfc = "+ rf+"");
                pps.setString(1,nom);
                pps.setString(2,rf);
                pps.setString(3,dir);
                pps.setString(4,tel);
                pps.executeUpdate();
                con.desconectar();
             }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"fallo de conexion "+e);
        }
            
        JOptionPane.showMessageDialog(null,"datos guardados");
    }
}
