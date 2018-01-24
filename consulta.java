/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_detei;

import java.sql.*;

/**
 *
 * @author hussein y maley
 */
public class consulta {
    String consul,sql;
    ResultSet res;
     PreparedStatement us;
    public consulta(String consulta){
        consul = consulta;
    }
    public void setFilas() throws SQLException{
        conectar con= new conectar();
        Connection pps = con.getConnection();
        if(consul.equals("")){
            sql = "SELECT * FROM clientes";    
            us = pps.prepareStatement(sql);
        }else{
        sql = "SELECT * FROM clientes WHERE nombre =? OR rfc = ?";
        us = pps.prepareStatement(sql);
        us.setString(1,consul);
        us.setString(2, consul);
        }
        res = us.executeQuery();
    }
    public Object res(){
        return res;
    }
}
