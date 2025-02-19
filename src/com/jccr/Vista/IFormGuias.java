/*
 * IFormGuias.java
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jccr.Vista;

import Complementos.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Formulario de Guias de envios de productos
 * @author Grupo 4 Plataformas de Desarrollo de Software
 * Version 1.0
 */
public final class IFormGuias extends javax.swing.JInternalFrame {

    private final FormPrincipal myPrincipalForm;
    private JDialogFichaGuia myJDialogFichaGuia;
    private DefaultTableModel dtm_Guias;
    private final DefaultTableCellRenderer modeloCentrar = new DefaultTableCellRenderer();
    private final DefaultTableCellRenderer modeloAlinearDerecha = new DefaultTableCellRenderer();
    
    /** 
     * Creates new form IFormGuias
     * @param p 
     */
    public IFormGuias(FormPrincipal p) {
        initComponents();
        this.myPrincipalForm = p;
        this.cargarTablaGuias("");
        this.modeloCentrar.setHorizontalAlignment(SwingConstants.CENTER);
        this.modeloAlinearDerecha.setHorizontalAlignment(SwingConstants.RIGHT);
        this.setLocation();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotonBuscar = new javax.swing.ButtonGroup();
        jPanelProductos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGuias = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        cmdEditar = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        cmdEliminar = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        cmdPrint = new javax.swing.JButton();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        cmdSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Guias");

        tablaGuias.setAutoCreateRowSorter(true);
        tablaGuias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaGuias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGuiasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaGuias);

        jToolBar2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar2.setRollover(true);

        cmdEditar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmdEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/4. Modificar.png"))); // NOI18N
        cmdEditar.setMnemonic('E');
        cmdEditar.setToolTipText("Editar Producto");
        cmdEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditarActionPerformed(evt);
            }
        });
        cmdEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmdEditarKeyPressed(evt);
            }
        });
        jToolBar2.add(cmdEditar);
        jToolBar2.add(jSeparator11);

        cmdEliminar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmdEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/6. Cancelar.png"))); // NOI18N
        cmdEliminar.setMnemonic('E');
        cmdEliminar.setToolTipText("Eliminar Producto");
        cmdEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEliminarActionPerformed(evt);
            }
        });
        cmdEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmdEliminarKeyPressed(evt);
            }
        });
        jToolBar2.add(cmdEliminar);
        jToolBar2.add(jSeparator12);

        cmdPrint.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmdPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/9. Imprimir.png"))); // NOI18N
        cmdPrint.setMnemonic('I');
        cmdPrint.setToolTipText("Imprimir");
        cmdPrint.setFocusable(false);
        cmdPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPrintActionPerformed(evt);
            }
        });
        cmdPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmdPrintKeyPressed(evt);
            }
        });
        jToolBar2.add(cmdPrint);
        jToolBar2.add(jSeparator14);

        cmdSalir.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmdSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/10. Salir.png"))); // NOI18N
        cmdSalir.setMnemonic('S');
        cmdSalir.setToolTipText("Salir");
        cmdSalir.setFocusable(false);
        cmdSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSalirActionPerformed(evt);
            }
        });
        cmdSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmdSalirKeyPressed(evt);
            }
        });
        jToolBar2.add(cmdSalir);

        javax.swing.GroupLayout jPanelProductosLayout = new javax.swing.GroupLayout(jPanelProductos);
        jPanelProductos.setLayout(jPanelProductosLayout);
        jPanelProductosLayout.setHorizontalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelProductosLayout.setVerticalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

public void setLocation(){
    int height = (this.myPrincipalForm.getjdpHeight());
    int width = (this.myPrincipalForm.getjdpWidth());
    this.setLocation ((width - this.getWidth ()) / 2,(height - this.getHeight ()) / 2);
}

public void cargarTablaGuias(String where){
    // 1. Efectos de Tabla de los Guias registrados
    Object[] NombreColumnas = {"ID GUIA", "PRODUCTO", "COMPRADOR", "ORIGEN", "DESTINO", "ESTADO", "FECHA ENTREGA"};
    this.dtm_Guias = new DefaultTableModel(NombreColumnas, 0){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    this.tablaGuias.setModel(dtm_Guias);
    this.tablaGuias.setForeground(Color.BLACK);
    this.tablaGuias.getColumnModel().getColumn(0).setPreferredWidth(50);
    this.tablaGuias.getColumnModel().getColumn(1).setPreferredWidth(300);
    this.tablaGuias.getColumnModel().getColumn(2).setPreferredWidth(300);
    this.tablaGuias.getColumnModel().getColumn(2).setPreferredWidth(50);
    this.tablaGuias.getColumnModel().getColumn(0).setCellRenderer(this.modeloCentrar);
    this.cargarGuias(where);
}

private void cargarGuias(String where){
    /*this.myPrincipalForm.getmyEmpresaVentas().cargarTodosGuias(where);
    int x = this.myPrincipalForm.getmyEmpresaVentas().getMyGuias().size();
    for(int i = 0; i < x; i++){
        int id = this.myPrincipalForm.getmyEmpresaVentas().getMyGuias().get(i).getId();
        String nom = this.myPrincipalForm.getmyEmpresaVentas().getMyGuias().get(i).getNombre();
        int pre = this.myPrincipalForm.getmyEmpresaVentas().getMyGuias().get(i).getPrecioVenta();
        Object[] nuevaFila = {id, nom, pre};
        this.dtm_Guias.addRow(nuevaFila);
    }
    this.myPrincipalForm.getmyEmpresaVentas().getMyGuias().clear(); */   
}

private void tablaGuiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGuiasMouseClicked
// TODO add your handling code here:
    if(evt.getClickCount() > 1){
        this.cmdEditarActionPerformed(null);
    }
}//GEN-LAST:event_tablaGuiasMouseClicked

private void mostrarFichaGuias(int id){
    this.myJDialogFichaGuia = new JDialogFichaGuia(this.myPrincipalForm, true, 
            this, id, true);
    this.myJDialogFichaGuia.setVisible(true);
}

private void cmdEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditarActionPerformed
// TODO add your handling code here:
    /*if(tablaGuias.getRowCount() > 0 && tablaGuias.getSelectedRowCount() > 0){
        int ind = tablaGuias.getSelectedRow();
        int id = Integer.parseInt(this.dtm_Guias.getValueAt(ind, 0).toString());
    }
    else{
        Ventana.imp("Seleccione una Guia para editar.", "SISTEMA");
    }*/
        this.mostrarFichaGuias(1);
}//GEN-LAST:event_cmdEditarActionPerformed

private void cmdEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdEditarKeyPressed
// TODO add your handling code here:
    int t=(int) evt.getKeyChar();
    if(t==10){
        this.cmdEditarActionPerformed(null);
    }
}//GEN-LAST:event_cmdEditarKeyPressed

private void cmdEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEliminarActionPerformed
// TODO add your handling code here:
    /*if(tablaGuias.getRowCount() > 0 && tablaGuias.getSelectedRowCount() > 0){
        int ind = tablaGuias.getSelectedRow();
        String nom = this.dtm_Guias.getValueAt(ind, 1).toString();
        int id = this.myPrincipalForm.getmyEmpresaVentas().getIdProducto(nom);
        String msg = this.myPrincipalForm.getmyEmpresaVentas().eliminarProducto(id);
        if(msg.equalsIgnoreCase("Producto eliminado Correctamente.")){
            Ventana.imp(msg, "SISTEMA.");
            this.cargarTablaGuias("where activo = '1' ");
        }
        else
            Ventana.imp(msg, "SISTEMA.");
    }
    else{
        Ventana.imp("Seleccione un producto para eliminar.", "SISTEMA");
    }*/
}//GEN-LAST:event_cmdEliminarActionPerformed

private void cmdEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdEliminarKeyPressed
// TODO add your handling code here:
    int t=(int) evt.getKeyChar();
    if(t==10){
        this.cmdEliminarActionPerformed(null);
    }
}//GEN-LAST:event_cmdEliminarKeyPressed

private void cmdSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSalirActionPerformed
// TODO add your handling code here:
    this.dispose();
}//GEN-LAST:event_cmdSalirActionPerformed

private void cmdSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdSalirKeyPressed
// TODO add your handling code here:
     int t=(int) evt.getKeyChar();
    if(t==10){
        this.dispose();
    }
}//GEN-LAST:event_cmdSalirKeyPressed

private void cmdPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPrintActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_cmdPrintActionPerformed

private void cmdPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdPrintKeyPressed
// TODO add your handling code here:
}//GEN-LAST:event_cmdPrintKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdEditar;
    private javax.swing.JButton cmdEliminar;
    private javax.swing.JButton cmdPrint;
    private javax.swing.JButton cmdSalir;
    private javax.swing.ButtonGroup grupoBotonBuscar;
    private javax.swing.JPanel jPanelProductos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTable tablaGuias;
    // End of variables declaration//GEN-END:variables
}
