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
import javax.swing.JOptionPane;

/**
 *
 * @author hussein y maley
 */
public class borrar {
    String rfc,sql;
     ResultSet res;
     PreparedStatement us;
    public borrar( String rf){
        rfc = rf;
    }
    public void bor() throws SQLException{
        try{
                conectar con = new conectar();
                Connection reg= con.getConnection();
                PreparedStatement pps = reg.prepareStatement("DELETE FROM clientes WHERE rfc= ?");
                pps.setString(1,rfc);
                pps.executeUpdate();
                con.desconectar();
             }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"fallo de conexion "+e);
        }
        JOptionPane.showMessageDialog(null, "archivo eliminado");
    }
}
