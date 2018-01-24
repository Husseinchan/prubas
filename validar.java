/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_detei;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hussein y maley
 */
public class validar {
    String user,contr,sql;
    ResultSet res;
     PreparedStatement us;
    public validar(String usuario, String contrase){
        user= usuario;
        contr = contrase;
    } 
    public void valido() throws SQLException{
        conectar con= new conectar();
        Connection pps = con.getConnection();
        sql = "SELECT usuario FROM usuarios WHERE usuario =? AND contraseña = ?";
        us = pps.prepareStatement(sql);
        us.setString(1,user);
        us.setString(2,contr);
        res = us.executeQuery();
    }
    public Object res(){
        return res;
    }
}
