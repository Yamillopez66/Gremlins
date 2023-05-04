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
public class CtrlProducto {

    //atributo que representa una lista de Producto
    private ArrayList<Producto> myProducto;

    //atributo que representa la conexion a la base de datos
    private BaseDeDatos myBaseDeDatos;


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1CB94D85-AE30-BECA-715D-B6562E8357C3]
    // </editor-fold> 
    //Constructor
    public CtrlProducto() {
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
     * Metodo eliminarProducto 
     * Elimina un Producto
     *
     * @param idProducto un int que representa el id del producto
     * @return msg un String indicando si el producto fue eliminado
     */
    public String eliminarProducto(int idProducto) {
        String msg = "Este Producto no se eliminó por estar asociado a procesos en el programa.";
        Producto pro = this.buscarProductoBD(idProducto);
        ProductoDAO proDao = new ProductoDAO(pro);
            if (proDao.eliminarProductoBD(myBaseDeDatos)) {
                msg = "Producto eliminado Correctamente.";
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
        Producto pro;
        String sql = "SELECT * FROM  Producto " + where + " ORDER BY idProducto";
        ArrayList<String> consulta = this.myBaseDeDatos.getConsultaSQL(sql);
        if (consulta.isEmpty()) {
            return;
        }
        for (String registro : consulta) {
            String datos[] = registro.split("#_");
            int idProducto = Integer.parseInt(datos[0]);
            String descripcion = datos[1];
            String proveedor = datos[2];
            String marca = datos[3];
            int precioCompra = Integer.parseInt(datos[4]);
            int precioVenta = Integer.parseInt(datos[5]);
            int cantidad = Integer.parseInt(datos[6]);
            pro = new Producto (idProducto,descripcion,proveedor,marca,precioCompra,precioVenta,cantidad);
            this.myProducto.add(pro);
        }
    }

    /**
     * Metodo para registrar
     * @param idProducto
     * @param Descripcion
     * @param Proveedor
     * @param Marca
     * @param Precio_Compra
     * @param Precio_Venta
     * @param Cantidad
     * @return 
     */
    public boolean registrarProductoBD (int idProducto, String Descripcion, String Proveedor, String Marca, int Precio_Compra, int Precio_Venta, int Cantidad) {
        Producto pro = new Producto(idProducto, Descripcion, Proveedor, Marca, Precio_Compra, Precio_Venta, Cantidad);
        ProductoDAO proDao = new ProductoDAO(pro);
        return proDao.registrarProductoBD(myBaseDeDatos);
    }

    /**
     * Metodo para editar producto en BD
     * @param idProducto
     * @param Descripcion
     * @param Proveedor
     * @param Marca
     * @param Precio_Compra
     * @param Precio_Venta
     * @param Cantidad
     * @return 
     */
    public boolean editarProductoBD(int idProducto, String Descripcion, String Proveedor, String Marca, int Precio_Compra, int Precio_Venta, int Cantidad) {
        Producto pro = new Producto(idProducto, Descripcion, Proveedor, Marca, Precio_Compra, Precio_Venta, Cantidad);
        ProductoDAO proDao = new ProductoDAO(pro);
        return proDao.editarProductoBD(myBaseDeDatos);
    }

    
    /**
     * Metodo para buscar nombre de producto en BD
     * @param idProducto
     * @return 
     */
    public String buscarNombreProducto(int idProducto) {
        Producto pro = this.buscarProductoBD(idProducto);
        if (pro == null) {
            return "No existe este Producto.";
        }
        return pro.getDescripcion();
    }
    
    public String buscarProveedor(int idProducto) {
        Producto pro = this.buscarProductoBD(idProducto);
        if (pro == null) {
            return "No existe este Producto.";
        }
        return pro.getProveedor();
    }
    
    public String buscarMarca(int idProducto) {
        Producto pro = this.buscarProductoBD(idProducto);
        if (pro == null) {
            return "No existe este Producto.";
        }
        return pro.getMarca();
        
    }
    
    public int buscarPrecio_Venta(int idProducto) {
        Producto pro = this.buscarProductoBD(idProducto);
        if (pro == null) {
            return 0;
        }
        return pro.getPrecio_Venta();
    }
    
    public int buscarCantidad (int idProducto) {
        Producto pro = this.buscarProductoBD(idProducto);
        if (pro == null) {
            return 0;
        }
        return pro.getCantidad();
        
        }

    /**
     * Metodo para buscar producto en BD
     * @param idProducto
     * @return 
     */
        public Producto buscarProductoBD(int idProducto) {
        Producto pro = new Producto();
        ProductoDAO proDao = new ProductoDAO(pro);
        return proDao.buscarProductoBD(idProducto, myBaseDeDatos);
    }   
   
}
