/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package Complementos;

import java.util.ArrayList;

/**
 * Clase que permite conectar con la Base De datos 
 */
public class BaseDeDatos {
    
    //conexion para instrucion SQL.
    private JDBCMiddler JDBC;
    //propiedades del sistema.
    private static final String DRIVER = "jdbc:mysql";
    //Driver de la Base de datos.
    private static final String HOST = "localhost";
    //Host de la Base de datos.
    private static final String PUERTO = "3306";
    //Host de la Base de datos.
    private static final String BASEDATOS = "gestion_mvc_bd";
    //controlador de la base de datos.
    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    //Usuario de la Base de datos.
    private static final String LOGIN = "root";
    //Clave de la Base de datos.
    private static final String PASSWORD = "b0l1a9.N2C8A3";
    //Direccion de acceso a la Base de datos del servidor.
    private static final String URLLOCAL = DRIVER+"://"+HOST+":"+PUERTO+"/"+BASEDATOS;
    
    /**
     * 
     */
    public BaseDeDatos() {
        this.crear(CONTROLADOR, URLLOCAL, LOGIN, PASSWORD);
    }

    private void crear(String controlador, String url, String login, String pass){
        JDBC = new JDBCMiddler(controlador, url, login, pass);
        try{
            JDBC.conectar();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void desconectar() {
        try{
            JDBC.desconectar();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public boolean ejecutarActualizacionSQL(String comandoSQL){
        System.out.println(comandoSQL);
        try{
            return (JDBC.ejecutarActualizacionSQL(comandoSQL));
        }
        catch(Exception e){
             System.err.println("SQL Error:"+e.getMessage());
                return (false);
        }
    }

    public ArrayList<String>  getConsultaSQL(String sql){
        System.out.println(sql);
        try{
            return (JDBC.getSQL(sql));
        }
        catch(Exception e){
            System.err.println("SQL Error:"+e.getMessage());
            return (null);
        }
    }
}
