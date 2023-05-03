/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jccr.Modelo;

/**
 *
 * @author P
 */
public class Producto {
    private int idProducto;
    private String Descripcion;
    private String Proveedor;
    private int NID_Proveedor;
    private String Marca;
    private int Precio_Compra;
    private int Precio_Venta;
    private int Cantidad;

    public int getNID_Proveedor() {
        return NID_Proveedor;
    }

    public void setNID_Proveedor(int NID_Proveedor) {
        this.NID_Proveedor = NID_Proveedor;
    }

    public int getidProducto() {
        return idProducto;
    }

    public void setidProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getPrecio_Compra() {
        return Precio_Compra;
    }

    public void setPrecio_Compra(int Precio_Compra) {
        this.Precio_Compra = Precio_Compra;
    }

    public int getPrecio_Venta() {
        return Precio_Venta;
    }

    public void setPrecio_Venta(int Precio_Venta) {
        this.Precio_Venta = Precio_Venta;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    
    
}
