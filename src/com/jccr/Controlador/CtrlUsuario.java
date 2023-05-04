package com.jccr.Controlador;

import Complementos.BaseDeDatos;
import com.jccr.Modelo.Usuario;
import com.jccr.Modelo.UsuarioDAO;
import com.jccr.Vista.IFormUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrlUsuario implements ActionListener {

    private final Usuario mod;
    private final UsuarioDAO modC;
    private final IFormUsuario frm;

    //atributo que representa la conexion a la base de datos
    private BaseDeDatos myBaseDeDatos;

    public CtrlUsuario(Usuario mod, UsuarioDAO modC, IFormUsuario frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.jbtInsertar.addActionListener(this);
        this.frm.jbtModificar.addActionListener(this);
        this.frm.jbtEliminar.addActionListener(this);
        this.frm.jbtBuscar.addActionListener(this);
        this.frm.jbtLimpiar.addActionListener(this);
        
        try {
            myBaseDeDatos = new BaseDeDatos();
            //myBaseDeDatos = new BaseDeDatos(true);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void iniciar() {
        frm.setTitle("Usuarios");
        frm.txtIdusuario.setVisible(false);
    }

    
    
    /**
     * Verifica si este usuario existe en la base de datos
     *
     * @param Correo un String con el nombre de usuario.
     * @param clave un String con la clave del usuario.
     * @return un boolean true si la identificacion del usuario es correcta.
     */
    public boolean verificarUsuario(String Correo, String clave){
        boolean ver = false;
        String sql = "SELECT * FROM USUARIO WHERE PASSWORD = '"+clave+"' AND Correo = '"+Correo+"'";
        ArrayList<String> consulta;
        consulta = myBaseDeDatos.getConsultaSQL(sql);
        System.err.println("Consulta"+consulta);
        if (consulta == null) {
            return ver;
        } else {
            for (String registro : consulta) {
                String datos[] = registro.split("#_");
                String usu = datos[6];
                String cla = datos[9];
                if (usu.equalsIgnoreCase(Correo) && cla.equalsIgnoreCase(clave)) {
                    ver = true;
                }
            }
            return ver;
        }
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
