
package com.jccr.Controlador;

import com.jccr.Modelo.Producto;
import com.jccr.Modelo.ProductoDAO;
import com.jccr.Vista.IFormProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ProductoControl implements ActionListener {

    private final Producto mod; 
    private final ProductoDAO modC;
    private final IFormProductos frm;
    
    public ProductoControl(Producto mod, ProductoDAO modC, IFormProductos frm)
    {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.jbtInsertar.addActionListener(this);
        this.frm.jbtModificar.addActionListener(this);
        this.frm.jbtEliminar.addActionListener(this);
        this.frm.jbtBuscar.addActionListener(this);
        this.frm.jbtLimpiar.addActionListener(this);
    }
    
    public void iniciar ()
    {
        frm.setTitle("Producto");
        frm.setLocationRelativeTo(null);
        frm.txtidProducto.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == frm.jbtInsertar) {

            mod.setidProducto(Integer.parseInt(frm.txtidProducto.getText));
            mod.setDescripcion(frm.txtDescripcion.getText());
            mod.setProveedor(frm.txtProveedor.getText());
            mod.setNID_Proveedor(Integer.parseInt(frm.txtNID_Proveedor.getText));
            mod.setMarca(frm.txtMarca.getText());
            mod.setPrecio_Compra(Integer.parseInt(frm.txtPrecio_Compra.getText));
            mod.setPrecio_Venta(Integer.parseInt(frm.txtPrecio_Venta.getText));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText));         
            

            if (modC.insertar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }

        }
        
         if (e.getSource() == frm.jbtModificar) {

            mod.setidProducto(Integer.parseInt(frm.txtidProducto.getText));
            mod.setDescripcion(frm.txtDescripcion.getText());
            mod.setProveedor(frm.txtProveedor.getText());
            mod.setNID_Proveedor(Integer.parseInt(frm.txtNID_Proveedor.getText));
            mod.setMarca(frm.txtMarca.getText());
            mod.setPrecio_Compra(Integer.parseInt(frm.txtPrecio_Compra.getText));
            mod.setPrecio_Venta(Integer.parseInt(frm.txtPrecio_Venta.getText));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText));

            if (modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }

        }
         if (e.getSource() == frm.jbtEliminar) {

            mod.setidProducto(Integer.parseInt(frm.txtidProducto.getText()));
            
            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }

        }
         if (e.getSource() == frm.jbtBuscar) {

            mod.setidProducto(Integer.parseInt(frm.txtidProducto.getText()));
           
            
            if (modC.buscar(mod)) {
                
                frm.txtidProducto.setText(String.valueOf(mod.getidProducto()));
                frm.txtDescripcion.setText(mod.getDescripcion());
                frm.txtProveedor.setText(mod.getProveedor());
                frm.txtNID_Proveedor.setText(String.valueOf(mod.getNID_Proveedor()));
                frm.txtMarca.setText(mod.getMarca());
                frm.txtPrecio_Compra.setText(String.valueOf(mod.getPrecio_Compra()));
                frm.txtPrecio_Venta.setText(String.valueOf(mod.getPrecio_Venta()));
                frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));
               
            } else {
                JOptionPane.showMessageDialog(null, "No Existen Registros");
                limpiar();
            }

        }
         if (e.getSource() == frm.jbtLimpiar) {
             limpiar();
         }
    }
    
    public void limpiar(){
            frm.txtidProducto.setText(null);            
            frm.txtDescripcion.setText(null);
            frm.txtProveedor.setText(null);
            frm.txtNID_Proveedor.setText(null);
            frm.txtMarca.setText(null);
            frm.txtPrecio_Compra.setText(null);
            frm.txtPrecio_Venta.setText(null);
            frm.txtCantidad.setText(null);

                    }
    public String registrarProductoBD(int idProd, String nombreProducto.toUpperCase(), int precioCompra,int  precioVenta, int cantActual){
       
    }
}

