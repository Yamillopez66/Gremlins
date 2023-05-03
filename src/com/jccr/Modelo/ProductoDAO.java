package com.jccr.Modelo;

import static com.jccr.Modelo.Conexion.getConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO extends Conexion {
    
    public boolean insertar(Producto pro) {
        PreparedStatement ps = null;
        Connection con = getConection();
        String sql = "INSERT INTO producto (idProducto,Descripcion,Proveedor,NID_Proveedor,Marca,Precio_Compra,Precio_Venta,Cantidad)"
                + "values(?,?,?,?,?,?,?,?)";
        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getidProducto());
            ps.setString(2, pro.getDescripcion());
            ps.setString(3, pro.getProveedor());
            ps.setInt(4, pro.getNID_Proveedor());
            ps.setString(5,pro.getMarca());
            ps.setInt(6, pro.getPrecio_Compra());
            ps.setInt(7, pro.getPrecio_Venta());
            ps.setInt(8, pro.getCantidad());

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
    public boolean modificar(Producto pro) {
        PreparedStatement ps = null;
        Connection con = getConection();
        String sql = "UPDATE Producto set idProducto = ?, Descripcion=?, Proveedor=?, NID_Proveedor=?, Marca=?, Precio_Compra=?, Precio_Venta=?, Cantidad=? "
                + "WHERE idProducto = ?";
        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getidProducto());
            ps.setString(2, pro.getDescripcion());
            ps.setString(3, pro.getProveedor());
            ps.setInt(4, pro.getNID_Proveedor());
            ps.setString(5, pro.getMarca());
            ps.setInt(6, pro.getPrecio_Compra());
            ps.setInt(7, pro.getPrecio_Venta());
            ps.setInt(8, pro.getCantidad());
            
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
    public boolean eliminar(Producto pro) {
        PreparedStatement ps = null;
        Connection con = getConection();
        String sql = "DELETE FROM Producto WHERE idProducto =?";
        try {

            ps = con.prepareStatement(sql);
           
            ps.setInt(1, pro.getidProducto());

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
    public boolean buscar(Producto pro) {
        PreparedStatement ps = null;
        Connection con = getConection();
        ResultSet rs = null;
        String sql = "SELECT * FROM Producto WHERE idProducto = ?";
        try {

            ps = con.prepareStatement(sql);
           
            ps.setInt(1,pro.getidProducto());

            rs = ps.executeQuery();
            
            if (rs.next())
            {
                pro.setidProducto(Integer.parseInt(rs.getString("idProducto")));
                pro.setDescripcion(rs.getString("Descripcion"));
                pro.setProveedor(rs.getString("Proveedor"));
                pro.setNID_Proveedor(Integer.parseInt(rs.getString("NID_Proveedor")));
                pro.setMarca(rs.getString("Marca"));
                pro.setPrecio_Compra(Integer.parseInt(rs.getString("Precio_Compra")));
                pro.setPrecio_Venta(Integer.parseInt(rs.getString("Precio_Venta")));
                pro.setCantidad(Integer.parseInt(rs.getString("Cantidad")));
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
