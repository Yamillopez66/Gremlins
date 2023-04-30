
package com.jccr.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class UsuarioDAO extends Conexion {

    public boolean insertar(Usuario usu) {
        PreparedStatement ps = null;
        Connection con = getConection();
        String sql = "INSERT INTO usuario (Numero_Identificacion, Nombre, Apellido, Telefono,"
                + "Direccion, Correo, Cargo, Rol, Pass)"
                + "values(?,?,?,?,?,?,?,?,?)";
        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, usu.getNumero_Identificacion());
            ps.setString(2,usu.getNombre());
            ps.setString(3, usu.getApellido());
            ps.setInt(4, usu.getTelefono());
            ps.setString(5, usu.getDireccion());
            ps.setString(6, usu.getCorreo());
            ps.setString(7, usu.getCargo());
            ps.setString(8, usu.getRol());
            ps.setString(9, usu.getPassword());
            

            ps.execute();

            return true;

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
    public boolean modificar(Usuario usu) {
        PreparedStatement ps = null;
        Connection con = getConection();
        String sql = "UPDATE usuario set "
                + "Numero_Identificacion = ? ,"
                + "Nombre = ?, "
                + "Apellido = ?,"
                + "Telefono = ? ,"
                + "Direccion = ?,"
                + "Correo = ?,"
                + "Cargo = ?,"
                + "Rol = ?,"
                + "Pass = ?"
                + "WHERE idUsuario = ?";
        try {

            ps = con.prepareStatement(sql);
            
            
            ps.setInt(1, usu.getNumero_Identificacion());
            ps.setString(2, usu.getNombre());
            ps.setString(3, usu.getApellido());
            ps.setInt(4, usu.getTelefono());
            ps.setString(5, usu.getDireccion());
            ps.setString(6, usu.getCorreo());
            ps.setString(7, usu.getCargo());
            ps.setString(8, usu.getRol());
            ps.setString(9, usu.getPassword());
            ps.setInt(10, usu.getIdUsuario());

            ps.execute();

            return true;

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
    public boolean eliminar(Usuario usu) {
        PreparedStatement ps = null;
        Connection con = getConection();
        String sql = "DELETE FROM usuario WHERE idUsuario =?";
        try {

            ps = con.prepareStatement(sql);
           
            ps.setInt(1, usu.getIdUsuario());

            ps.execute();

            return true;

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
    public boolean buscar(Usuario usu) {
        PreparedStatement ps = null;
        Connection con = getConection();
        ResultSet rs = null;
        String sql = "SELECT * FROM usuario WHERE Numero_Identificacion = ?";
        try {

            ps = con.prepareStatement(sql);
           
            ps.setInt(1, usu.getNumero_Identificacion());

            rs = ps.executeQuery();
            
            if (rs.next())
            {
                usu.setIdUsuario(Integer.parseInt(rs.getString("idUsuario")));
                usu.setNumero_Identificacion(Integer.parseInt(rs.getString("Numero_Identificacion")));
                usu.setNombre(rs.getString("Nombre"));
                usu.setApellido(rs.getString("Apellido"));
                usu.setTelefono(Integer.parseInt(rs.getString("Telefono")));
                usu.setDireccion(rs.getString("Direccion"));
                usu.setCorreo(rs.getString("Correo"));
                usu.setCargo(rs.getString("Cargo"));
                usu.setRol(rs.getString("Rol"));
                usu.setPassword(rs.getString("Pass"));
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



    
