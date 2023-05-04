package com.jccr.Modelo;

import Complementos.BaseDeDatos;
import java.util.ArrayList;

public class ProductoDAO extends Conexion {
    Producto myProducto;

    public ProductoDAO(Producto p) {
        this.myProducto=p;
        
    }
    
    /**
     * Metodo para registrar producto en la BD
     * @param bd
     * @return 
     */    
    public boolean registrarProductoBD(BaseDeDatos bd){
        String sql = "INSERT INTO PRODUCTO (Descripcion, Proveedor, Marca, Precio_Compra, Precio_Venta, Cantidad) VALUES('"+
                myProducto.getDescripcion()+"', '"+
                myProducto.getProveedor()+"', '"+
                myProducto.getMarca()+"', '"+
                myProducto.getPrecio_Compra()+"', '"+
                myProducto.getPrecio_Venta()+"', '"+
                myProducto.getCantidad()+"')";
         
            return bd.ejecutarActualizacionSQL(sql);
    }
    
    /**
     * Metodo para editar usuario en BD
     * @param bd
     * @return 
     */
    public boolean editarProductoBD(BaseDeDatos bd){
        String sql = "UPDATE Producto SET "
                + "idProducto = '"+myProducto.getIdProducto()+"', " 
                + "Descripcion = '"+myProducto.getDescripcion()+"', " 
                + "Proveedor = '"+myProducto.getProveedor()+"', "
                + "Marca = '"+myProducto.getMarca()+"', "
                + "Precio_Compra = '"+myProducto.getPrecio_Compra()+"', "
                + "Precio_Venta = '"+myProducto.getPrecio_Venta()+"', "
                + "Cantidad = '"+myProducto.getCantidad()+"' " +
                "WHERE idProducto = '"+myProducto.getIdProducto()+"'";
        return bd.ejecutarActualizacionSQL(sql);
    }
    
    /**
     * Metodo para eliminar producto en BD
     * @param bd
     * @return 
     */
    public boolean eliminarProductoBD (BaseDeDatos bd) {
        String sql = "DELETE FROM PRODUCTO WHERE idProducto = '"+myProducto.getIdProducto()+"'";
        return bd.ejecutarActualizacionSQL(sql);

    }
    
    /**
     * Metodo para buscar producto en BD
     * @param idProducto
     * @param bd
     * @return 
     */
    public Producto buscarProductoBD(int idProducto, BaseDeDatos bd) {
        Producto pro = new Producto();
        String sql = "SELECT * FROM Producto "
                + "WHERE idProducto = '" + idProducto + "'";
        ArrayList<String> consulta;
        consulta = bd.getConsultaSQL(sql);
        if (consulta.isEmpty()) {
            return null;
        }
        for (String registro : consulta) {
            String datos[] = registro.split("#_");
            String Descripcion = datos[1];
            String Proveedor = datos[2];
            String Marca = datos[3];
            int Precio_Compra = Integer.parseInt(datos[4]);
            int Precio_Venta = Integer.parseInt(datos[5]);
            int Cantidad = Integer.parseInt(datos[6]);
            
            pro = new Producto(idProducto, Descripcion, Proveedor, Marca, Precio_Compra, Precio_Venta, Cantidad);
        }
        return pro;
    }
    
}
