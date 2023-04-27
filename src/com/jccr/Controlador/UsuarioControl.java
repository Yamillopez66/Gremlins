/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jccr.Controlador;

import java.util.ArrayList;
import Complementos.BaseDeDatos;
import com.jccr.Modelo.*;

/**
 *
 * @author JUANCARLOS
 */
public class UsuarioControl {

    //atributo que representa una lista de Usuario
    private ArrayList<Usuario> myUsuario;

    //atributo que representa la conexion a la base de datos
    private BaseDeDatos myBaseDeDatos;


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1CB94D85-AE30-BECA-715D-B6562E8357C3]
    // </editor-fold> 
    //Constructor
    public UsuarioControl() {
        this.myUsuario = new ArrayList<>();
        try {
            myBaseDeDatos = new BaseDeDatos();
            //myBaseDeDatos = new BaseDeDatos(true);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * Metodo getUsuario() Retorna una lista de Usuario con su respectiva
     * informacion
     *
     * @return myUsuario un ArrayList<> con la informacion de los Usuarios.
     */
    public ArrayList<Usuario> getMyUsuario() {
        return myUsuario;
    }

    /**
     * Metodo setUsuario Actualiza la lista de los Usuarios
     *
     * @param myUsuario un ArrayList<> con la informacion de los Usuarios.
     */
    public void setMyUsuario(ArrayList<Usuario> myUsuario) {
        this.myUsuario = myUsuario;
    }

    public BaseDeDatos getBd() {
        return myBaseDeDatos;
    }

    public void setBd(BaseDeDatos myBaseDeDatos) {
        this.myBaseDeDatos = myBaseDeDatos;
    }

    /**
     * Metodo getNumRegistroUsuario retorna el numero del Usuario a registrar
     *
     * @return un int con el numero del Usuario
     */
    public int getNumRegistroUsuario() {
        String sql = "SELECT MAX(Usuid) FROM usuario";
        int idUsuario = this.getIdRegistro(sql);
        return idUsuario;
    }
    
    /**
     * Metodo eliminarUsuario 
     * Elimina un Usuario
     *
     * @param idUsuario un int que representa el id del usuario
     * @return msg un String indicando si el usuario fue eliminado
     */
    public String eliminarUsuario(int idUsuario) {
        String msg = "Este usuario no se eliminó por estar asociado a procesos en el programa.";
        Usuario u = this.buscarUsuarioIdBD(idUsuario);
        usuarioDAO usuDao = new usuarioDAO(u);
            if (usuDao.eliminarUsuarioBD(myBaseDeDatos)) {
                msg = "usuario eliminado Correctamente.";
            }
        return msg;
    }
 
    /**
     * Metodo cargarUsuarios llena un arreglo de Usuarios .
     *
     * @param where
     */
    public void cargarUsuarios(String where) {
        this.myUsuario.clear();
        Usuario f;
        String sql = "SELECT * FROM  usuario " + where + " ORDER BY Usuid";
        ArrayList<String> consulta = this.myBaseDeDatos.getConsultaSQL(sql);
        if (consulta.isEmpty()) {
            return;
        }
        for (String registro : consulta) {
            String datos[] = registro.split("#_");
            int idUsu = Integer.parseInt(datos[0]);
            String usuNom = datos[1];
            String usuIdent = datos[2];
            String usuClavePass = datos[3];
            int usuEstado = Integer.parseInt(datos[4]);
            f = new Usuario(idUsu, usuNom, usuIdent, usuClavePass, usuEstado);
            this.myUsuario.add(f);
        }
    }

    /**
     * Metodo registrarUsuarioBD 
     * Registra un usuario en la Base de Datos
     *
     * @param usuNom un String que representa el nombre del usuario
     * @param usuIdent un String que representa la identificación del usuario
     * @param usuClavePass un String que representa la clave de ingreso al sistema
     * @param usuEstado un int representa si el usuario esta activo 1 o 0 inactivo
     * @return
     */
    public boolean registrarUsuarioBD(String usuNom, String usuIdent, String usuClavePass, int usuEstado) {
        int id = this.getNumRegistroUsuario();
        Usuario usu = new Usuario(id, usuNom, usuIdent, usuClavePass, usuEstado);
        usuarioDAO usuDao = new usuarioDAO(usu);
        return usuDao.registrarUsuarioBD(myBaseDeDatos);
    }

    /**
     * Metodo editarUsuarioBD registra un Usuario en la Base de Datos
     *
     * @param usuId un int que representa el id del usuario
     * @param usuNom un String que representa el nombre del usuario
     * @param usuIdent un String que representa la identificación del usuario
     * @param usuClavePass un String que representa la clave de ingreso al sistema
     * @param usuEstado un int representa si el usuario esta activo 1 o 0 inactivo
     * @return
     */
    public boolean editarUsuarioBD(int usuId, String usuNom, String usuIdent, String usuClavePass, int usuEstado) {
        Usuario usu = new Usuario(usuId, usuNom, usuIdent, usuClavePass, usuEstado);
        usuarioDAO usuDao = new usuarioDAO(usu);
        return usuDao.editarUsuarioBD(myBaseDeDatos);
    }

    /**
     * Metodo getIdRegistro retorna el numero id a registrar
     *
     * @param sql un String con la consulta sql
     * @return un int con el numero id a registrar
     */
    public int getIdRegistro(String sql) {
        int idReg = 0;
        ArrayList<String> consulta = this.myBaseDeDatos.getConsultaSQL(sql);
        for (String registro : consulta) {
            String datos[] = registro.split("#_");
            if (!datos[0].equalsIgnoreCase("null")) {
                idReg = Integer.parseInt(datos[0]);
            }
        }
        return idReg + 1;
    }

    /**
     * Metodo buscarNombreUsuario
     *
     * @param idUsu un int con el id del Usuario
     * @return nombre un String con el nombre del Usuario
     */
    public String buscarNombreUsuario(int idUsu) {
        Usuario usu = this.buscarUsuarioIdBD(idUsu);
        if (usu == null) {
            return "No existe este Usuario.";
        }
        return usu.getUsuNom();
    }

    /**
     * Metodo buscarIdentUsuario
     *
     * @param idUsu un int con el id del Usuario
     * @return Ident un String con la Identificacion del Usuario
     */
    public String buscarIdentUsuario(int idUsu) {
        Usuario usu = this.buscarUsuarioIdBD(idUsu);
        if (usu == null) {
            return "No existe este Usuario.";
        }
        return usu.getUsuIdent();
    }

    /**
     * Metodo buscarUsuarioIdBD 
     * Retorna un Usuario de la base de datos
     *
     * @param usuId un int con el id del Usuario
     * @return u un Usuario de la base de datos
     */
    public Usuario buscarUsuarioIdBD(int usuId) {
        usuarioDAO usuDao = new usuarioDAO();
        return usuDao.buscarUsuarioIdBD(usuId, myBaseDeDatos);
    }

    /**
     * Metodo buscarContrasenaUsuario
     *
     * @param idUsu un int con el id del Usuario
     * @return clave un String con la contraseña del Usuario
     */
    public String buscarContrasenaUsuario(int idUsu) {
        Usuario usu = this.buscarUsuarioIdBD(idUsu);
        if (usu == null) {
            return "No existe este Usuario.";
        }
        return usu.getUsuClavePass();
    }

    /**
     * Metodo buscarEstadoUsuario
     *
     * @param idUsu un int con el id del Usuario
     * @return estado un int con la contraseña del Usuario
     */
    public int buscarEstadoUsuario(int idUsu) {
        Usuario usu = this.buscarUsuarioIdBD(idUsu);
        return usu.getUsuEstado();
    }
    
   
}
