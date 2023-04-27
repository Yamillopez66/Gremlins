/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jccr.Modelo;

import Complementos.BaseDeDatos;
import java.util.ArrayList;

/**
 * Esta clase permite manipular un Usuario en la Base de Datos.
 * @author Grupo 4 Plataformas de Desarrollo de Software
 * Version 1.0
 */
public class usuarioDAO {
    
    //Instancia de un objeto usuario
    private Usuario myUsuario;

    /**
     * Constructor vacio
     */
    public usuarioDAO() {
    }

    /**
     * Constructor para crear una instancia del Objeto 
     * @param myUsuario un usuario de la aplicacion
     */
    public usuarioDAO(Usuario myUsuario) {
        this.myUsuario = myUsuario;
    }
          
    /**
     * Metodo registrarUsuarioBD
     * registra un usuario en la Base de Datos
     * @param bd conexion a la base de datos
     * @return un boolean que indica si el registro fue exitoso.
     */
    public boolean  registrarUsuarioBD(BaseDeDatos bd){
        String sql = "INSERT INTO USUARIO VALUES('"+myUsuario.getUsuId()+"', '"+
                myUsuario.getUsuNom()+"', '"+
                myUsuario.getUsuIdent()+"', '"+
                myUsuario.getUsuClavePass()+"', '"+
                myUsuario.getUsuEstado()+"')";
            return bd.ejecutarActualizacionSQL(sql);  
    }
   
    /**
     * Metodo editarUsuarioBD
     * actualiza la informacion de un Usuario en la base de datos
     * @param bd conexion a la base de datos
     * @return un boolean que indica si la actualizacion fue exitosa.
     */
    public boolean editarUsuarioBD(BaseDeDatos bd){
        String sql = "UPDATE USUARIO SET "
                + "usuNom = '"+myUsuario.getUsuNom()+"', " 
                + "usuIdent = '"+myUsuario.getUsuIdent()+"', " 
                + "usuClavePass = '"+myUsuario.getUsuClavePass()+"', "
                + "usuEstado = '"+myUsuario.getUsuEstado()+"' " +
                "WHERE usuId = '"+myUsuario.getUsuId()+"'";
        return bd.ejecutarActualizacionSQL(sql);
    }
    
    /**
     * Metodo eliminarUsuarioBD
     * elimina un usuario de la Base de Datos
     * @param bd conexion a la base de datos
     * @return un boolean que indica si se elimino exitosamente.
     */
    public boolean  eliminarUsuarioBD(BaseDeDatos bd){
        String sql = "DELETE FROM USUARIO WHERE usuId = '"+myUsuario.getUsuId()+"'";
        return bd.ejecutarActualizacionSQL(sql);
    }
    
    /**
     * Metodo inactivarUsuarioBD 
     * INACTIVA un Usuario en la base de datos
     * @param bd conexion a la base de datos
     * @return un boolean que indica si la actualizacion fue exitosa.
     */
    public boolean inactivarUsuarioBD(BaseDeDatos bd){
        String sql = "UPDATE USUARIO SET " +
                "usuEstado = '0' "+
                "WHERE usuId = '"+myUsuario.getUsuId()+"'";
        return bd.ejecutarActualizacionSQL(sql);
    }

    /**
     * Metodo buscarUsuarioIdBD 
     * Retorna un Usuario de la base de datos
     *
     * @param usuId un int que representa el id del usuario
     * @param bd conexion a la base de datos
     * @return u un Usuario de la base de datos
     */
    public Usuario buscarUsuarioIdBD(int usuId, BaseDeDatos bd) {
        Usuario u = new Usuario();
        String sql = "SELECT * FROM usuario "
                + "WHERE usuId = '" + usuId + "'";
        ArrayList<String> consulta;
        consulta = bd.getConsultaSQL(sql);
        if (consulta.isEmpty()) {
            return null;
        }
        for (String registro : consulta) {
            String datos[] = registro.split("#_");
            String usuNom = datos[1];
            String usuIdent = datos[2];
            String usuClavePass = datos[3];
            int usuEstado = Integer.parseInt(datos[4]);
            u = new Usuario(usuId, usuNom, usuIdent, usuClavePass, usuEstado);
        }
        return u;
    }
    
}
