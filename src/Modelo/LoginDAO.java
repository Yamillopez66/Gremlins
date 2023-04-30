
package Modelo;

import static Modelo.Conexion.getConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO extends Conexion{
    
   public boolean Insertar(Login log) {
        
        
        PreparedStatement ps = null;
        Connection con = getConection();
        ResultSet rs = null;
        String sql = "SELECT * FROM usuario WHERE Numero_Identificacion = ? and Pass = ? ";
        try {

            ps = con.prepareStatement(sql);
           
            ps.setInt(1, log.getUsuario());
            ps.setString(2, log.getPass());

            rs = ps.executeQuery();
            
            if (rs.next())
            {
                log.setUsuario(Integer.parseInt(rs.getString("Numero_Identificacion")));
                log.setPass(rs.getString("Pass"));
                log.setCargo(rs.getString("Rol"));
                return true;
            }

            return false;

        } catch (SQLException e) {

            System.err.println(e);
            return false;

        } finally {
            try {

                con.close();
            } catch (SQLException e) {

                System.err.println(e);
                return false;
            }

        }
    }

}
