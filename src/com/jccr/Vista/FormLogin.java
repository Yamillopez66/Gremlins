/*
 * FormLogin.java
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jccr.Vista;

import Complementos.Ventana;
import com.jccr.Controlador.CtrlUsuario;
import com.jccr.Modelo.Usuario;
import com.jccr.Modelo.UsuarioDAO;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.logging.Level;
import javax.swing.ImageIcon;

/**
 * Formulario para ingreso a la aplicación
 * @author Grupo 4 Plataformas de Desarrollo de Software
 * Version 1.0
 */

public class FormLogin extends javax.swing.JFrame {

    //Atributo que representa el formulario Principal.
    private FormPrincipal myFormPrincipal;
    //Atributo que la clase CtrlUsuario.
    private CtrlUsuario myCtrlUsuario;
    private final Usuario mod = new Usuario();
    private final UsuarioDAO modC = new UsuarioDAO();
    private final IFormUsuario frm = new IFormUsuario(this);

    /**
     * Método Constructor vacio
     */
    public FormLogin() {
        initComponents();
        this.myFormPrincipal = new FormPrincipal(this);
        this.myCtrlUsuario = new CtrlUsuario(mod, modC, frm);
        this.txtCorreo.grabFocus();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Iconos/1. Icono Inicio.png")).getImage());
    }
    
    /**
     * Metodo limpiarCampos()
     */
    public void limpiarCampos(){
        this.txtCorreo.setText("");
        this.jPassword.setText("");
        this.txtCorreo.grabFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInicioSesion = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblPassWord = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        btnInicioSesion = new javax.swing.JButton();
        lblIcono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelInicioSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInicioSesion.setOpaque(false);

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblUsuario.setText("Correo");

        txtCorreo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        lblPassWord.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblPassWord.setText("Clave");

        jPassword.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordKeyPressed(evt);
            }
        });

        btnInicioSesion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnInicioSesion.setText("Ingresar");
        btnInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioSesionActionPerformed(evt);
            }
        });
        btnInicioSesion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnInicioSesionKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblUsuario))
                    .addComponent(lblPassWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addComponent(txtCorreo))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(btnInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassWord)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Gremlins.png"))); // NOI18N

        javax.swing.GroupLayout jPanelInicioSesionLayout = new javax.swing.GroupLayout(jPanelInicioSesion);
        jPanelInicioSesion.setLayout(jPanelInicioSesionLayout);
        jPanelInicioSesionLayout.setHorizontalGroup(
            jPanelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicioSesionLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(lblIcono)
                .addContainerGap(135, Short.MAX_VALUE))
            .addGroup(jPanelInicioSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelInicioSesionLayout.setVerticalGroup(
            jPanelInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInicioSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void jPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.btnInicioSesionActionPerformed(null);
        }
    }//GEN-LAST:event_jPasswordKeyPressed

    private void btnInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioSesionActionPerformed
        // TODO add your handling code here:
        String correo = this.txtCorreo.getText().trim();
        String clave = String.valueOf(this.jPassword.getPassword()).trim();
        if(correo.equalsIgnoreCase("") || clave.equalsIgnoreCase("")){
            if(correo.equalsIgnoreCase("")){
                Ventana.warning("Digite el nombre de usuario.", "Verificar Datos.");
                this.txtCorreo.grabFocus();
            }
            if(clave.equalsIgnoreCase("")){
                Ventana.warning("Digite la clave de usuario.", "Verificar Datos.");
                this.jPassword.grabFocus();
            }
        }
        else{
           if(this.myCtrlUsuario.verificarUsuario(correo, clave)){
               this.myFormPrincipal = new FormPrincipal(this);
               this.myFormPrincipal.setVisible(true);
               this.dispose();
            }
            else{
                //this.intentos = this.intentos - 1;
                Ventana.imp("Revise los datos ingresados.", "Verificar Usuario");
                this.limpiarCampos();
            }
        }
    }//GEN-LAST:event_btnInicioSesionActionPerformed

    private void btnInicioSesionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnInicioSesionKeyPressed
        // TODO add your handling code here:
        int t = (int) evt.getKeyChar();
        if(t == 10){
            this.btnInicioSesionActionPerformed(null);
        }
    }//GEN-LAST:event_btnInicioSesionKeyPressed

   
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicioSesion;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelInicioSesion;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblPassWord;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
