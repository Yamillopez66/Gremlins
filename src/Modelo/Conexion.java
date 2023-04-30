/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Conexion {
    public static final String url = "jdbc:mysql://localhost:3306/db_gremlins";
    public static final String user = "root";
    public static final String password = "1234";
   
    public static Connection getConection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            //JOptionPane.showMessageDialog(null, "Conexion Exitosa");

        } catch (SQLException e) {

            System.out.println(e);

        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;

    }
}
