package com.jccr.Controlador;

import com.jccr.Modelo.Usuario;
import com.jccr.Modelo.UsuarioDAO;
import com.jccr.Vista.frmUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlUsuario implements ActionListener {

    private final Usuario mod;
    private final UsuarioDAO modC;
    private final frmUsuario frm;

    public CtrlUsuario(Usuario mod, UsuarioDAO modC, frmUsuario frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.jbtInsertar.addActionListener(this);
        this.frm.jbtModificar.addActionListener(this);
        this.frm.jbtEliminar.addActionListener(this);
        this.frm.jbtBuscar.addActionListener(this);
        this.frm.jbtLimpiar.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Usuarios");
        frm.setLocationRelativeTo(null);
        frm.txtIdusuario.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.jbtInsertar) {

            mod.setNumero_Identificacion(Integer.parseInt(frm.txtNumeroid.getText()));
            mod.setNombre(frm.txtNombre1.getText());
            mod.setApellido(frm.txtApellido.getText());
            mod.setTelefono(Integer.parseInt(frm.txtTelefono.getText()));
            mod.setDireccion(frm.txtDireccion.getText());
            mod.setCorreo(frm.txtCorreo.getText());
            mod.setCargo(frm.txtCargo.getText());
            mod.setRol(frm.txtRol.getText());
            String Contra = "";
            char[] password = frm.JPasswordUsuario.getPassword();
            for (int x = 0; x < password.length; x++) {
                Contra += password[x];
            }
            mod.setPassword(Contra);

            if (modC.insertar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }

        }

        if (e.getSource() == frm.jbtModificar) {

            mod.setIdUsuario(Integer.parseInt(frm.txtIdusuario.getText()));
            mod.setNumero_Identificacion(Integer.parseInt(frm.txtNumeroid.getText()));
            mod.setNombre(frm.txtNombre1.getText());
            mod.setApellido(frm.txtApellido.getText());
            mod.setTelefono(Integer.parseInt(frm.txtTelefono.getText()));
            mod.setDireccion(frm.txtDireccion.getText());
            mod.setCorreo(frm.txtCorreo.getText());
            mod.setCargo(frm.txtCargo.getText());
            mod.setRol(frm.txtRol.getText());
            String Contra = "";
            char[] password = frm.JPasswordUsuario.getPassword();
            for (int x = 0; x < password.length; x++) {
                Contra += password[x];
            }
            mod.setPassword(Contra);

            if (modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }

        }
        if (e.getSource() == frm.jbtEliminar) {

            mod.setIdUsuario(Integer.parseInt(frm.txtIdusuario.getText()));

            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }

        }
        if (e.getSource() == frm.jbtBuscar) {

            mod.setNumero_Identificacion((Integer.parseInt(frm.txtNumeroid.getText())));

            if (modC.buscar(mod)) {

                frm.txtIdusuario.setText(String.valueOf(mod.getIdUsuario()));
                frm.txtNumeroid.setText(String.valueOf(mod.getNumero_Identificacion()));
                frm.txtNombre1.setText(mod.getNombre());
                frm.txtApellido.setText(mod.getApellido());
                frm.txtTelefono.setText(String.valueOf(mod.getTelefono()));
                frm.txtDireccion.setText(mod.getDireccion());
                frm.txtCorreo.setText(mod.getCorreo());
                frm.txtCargo.setText(mod.getCargo());
                frm.txtRol.setText(mod.getRol());
                frm.JPasswordUsuario.setText(mod.getPassword());

            } else {
                JOptionPane.showMessageDialog(null, "No Existen Registros");
                limpiar();
            }

        }
        if (e.getSource() == frm.jbtLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        frm.txtIdusuario.setText(null);
        frm.txtNumeroid.setText(null);
        frm.txtNombre1.setText(null);
        frm.txtApellido.setText(null);
        frm.txtTelefono.setText(null);
        frm.txtDireccion.setText(null);
        frm.txtCorreo.setText(null);
        frm.txtCargo.setText(null);
        frm.txtRol.setText(null);
        frm.JPasswordUsuario.setText(null);

    }

}
