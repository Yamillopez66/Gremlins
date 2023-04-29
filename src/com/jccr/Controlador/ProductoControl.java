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
public class ProductoControl {

    //atributo que representa una lista de Producto
    private ArrayList<Producto> myProducto;

    //atributo que representa la conexion a la base de datos
    private BaseDeDatos myBaseDeDatos;


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1CB94D85-AE30-BECA-715D-B6562E8357C3]
    // </editor-fold> 
    //Constructor
    public ProductoControl() {
        this.myProducto = new ArrayList<>();
        try {
            myBaseDeDatos = new BaseDeDatos();
            //myBaseDeDatos = new BaseDeDatos(true);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * Metodo getProducto() Retorna una lista de Producto con su respectiva
     * informacion
     *
     * @return myProducto un ArrayList<> con la informacion de los Productos.
     */
    public ArrayList<Producto> getMyProducto() {
        return myProducto;
    }

    /**
     * Metodo setProducto Actualiza la lista de los Productos
     *
     * @param myProducto un ArrayList<> con la informacion de los Productos.
     */
    public void setMyProducto(ArrayList<Producto> myProducto) {
        this.myProducto = myProducto;
    }

    public BaseDeDatos getBd() {
        return myBaseDeDatos;
    }

    public void setBd(BaseDeDatos myBaseDeDatos) {
        this.myBaseDeDatos = myBaseDeDatos;
    }

    /**
     * Metodo getNumRegistroProducto retorna el numero del Producto a registrar
     *
     * @return un int con el numero del Producto
     */
    public int getNumRegistroProducto() {
        String sql = "SELECT MAX(Usuid) FROM usuario";
        int idProducto = this.getIdRegistro(sql);
        return idProducto;
    }
    
    /**
     * Metodo eliminarProducto 
     * Elimina un Producto
     *
     * @param idProducto un int que representa el id del usuario
     * @return msg un String indicando si el usuario fue eliminado
     */
    public String eliminarProducto(int idProducto) {
        String msg = "Este usuario no se eliminó por estar asociado a procesos en el programa.";
        Producto u = this.buscarProductoIdBD(idProducto);
        usuarioDAO usuDao = new usuarioDAO(u);
            if (usuDao.eliminarProductoBD(myBaseDeDatos)) {
                msg = "usuario eliminado Correctamente.";
            }
        return msg;
    }
 
    /**
     * Metodo cargarProductos llena un arreglo de Productos .
     *
     * @param where
     */
    public void cargarProductos(String where) {
        this.myProducto.clear();
        Producto f;
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
            f = new Producto(idUsu, usuNom, usuIdent, usuClavePass, usuEstado);
            this.myProducto.add(f);
        }
    }

    /**
     * Metodo registrarProductoBD 
     * Registra un usuario en la Base de Datos
     *
     * @param usuNom un String que representa el nombre del usuario
     * @param usuIdent un String que representa la identificación del usuario
     * @param usuClavePass un String que representa la clave de ingreso al sistema
     * @param usuEstado un int representa si el usuario esta activo 1 o 0 inactivo
     * @return
     */
    public boolean registrarProductoBD(String usuNom, String usuIdent, String usuClavePass, int usuEstado) {
        int id = this.getNumRegistroProducto();
        Producto usu = new Producto(id, usuNom, usuIdent, usuClavePass, usuEstado);
        usuarioDAO usuDao = new usuarioDAO(usu);
        return usuDao.registrarProductoBD(myBaseDeDatos);
    }

    /**
     * Metodo editarProductoBD registra un Producto en la Base de Datos
     *
     * @param usuId un int que representa el id del usuario
     * @param usuNom un String que representa el nombre del usuario
     * @param usuIdent un String que representa la identificación del usuario
     * @param usuClavePass un String que representa la clave de ingreso al sistema
     * @param usuEstado un int representa si el usuario esta activo 1 o 0 inactivo
     * @return
     */
    public boolean editarProductoBD(int usuId, String usuNom, String usuIdent, String usuClavePass, int usuEstado) {
        Producto usu = new Producto(usuId, usuNom, usuIdent, usuClavePass, usuEstado);
        usuarioDAO usuDao = new usuarioDAO(usu);
        return usuDao.editarProductoBD(myBaseDeDatos);
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
     * Metodo buscarNombreProducto
     *
     * @param idUsu un int con el id del Producto
     * @return nombre un String con el nombre del Producto
     */
    public String buscarNombreProducto(int idUsu) {
        Producto usu = this.buscarProductoIdBD(idUsu);
        if (usu == null) {
            return "No existe este Producto.";
        }
        return usu.getUsuNom();
    }

    /**
     * Metodo buscarIdentProducto
     *
     * @param idUsu un int con el id del Producto
     * @return Ident un String con la Identificacion del Producto
     */
    public String buscarIdentProducto(int idUsu) {
        Producto usu = this.buscarProductoIdBD(idUsu);
        if (usu == null) {
            return "No existe este Producto.";
        }
        return usu.getUsuIdent();
    }

    /**
     * Metodo buscarProductoIdBD 
     * Retorna un Producto de la base de datos
     *
     * @param usuId un int con el id del Producto
     * @return u un Producto de la base de datos
     */
    public Producto buscarProductoIdBD(int usuId) {
        usuarioDAO usuDao = new usuarioDAO();
        return usuDao.buscarProductoIdBD(usuId, myBaseDeDatos);
    }

    /**
     * Metodo buscarContrasenaProducto
     *
     * @param idUsu un int con el id del Producto
     * @return clave un String con la contraseña del Producto
     */
    public String buscarContrasenaProducto(int idUsu) {
        Producto usu = this.buscarProductoIdBD(idUsu);
        if (usu == null) {
            return "No existe este Producto.";
        }
        return usu.getUsuClavePass();
    }

    /**
     * Metodo buscarEstadoProducto
     *
     * @param idUsu un int con el id del Producto
     * @return estado un int con la contraseña del Producto
     */
    public int buscarEstadoProducto(int idUsu) {
        Producto usu = this.buscarProductoIdBD(idUsu);
        return usu.getUsuEstado();
    }
    
   
}
