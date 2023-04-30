
package Controlador;

import Modelo.Login;
import Modelo.LoginDAO;
import Vista.FrmAdministrador;
import Vista.frmLogin;
import crudmvc.IndexUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlLogin implements ActionListener {

    private final Login mod;
    private final LoginDAO modC;
    private final frmLogin frm;

    public CtrlLogin(Login mod, LoginDAO modC, frmLogin frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.jbtInsertarLogin.addActionListener(this);

    }

    public void iniciar() {
        frm.setTitle("Login Usuarios");
        frm.setLocationRelativeTo(null);
        frm.jTextCargo.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frm.jbtInsertarLogin) {

            mod.setUsuario(Integer.parseInt(frm.jTextUsuario.getText()));
            String Contra = "";
            char[] password = frm.jPasswordLogin.getPassword();
            for (int x = 0; x < password.length; x++) {
                Contra += password[x];
            }
            mod.setPass(Contra);
            if (modC.Insertar(mod)) {

                frm.jPasswordLogin.setText(mod.getPass());
                frm.jTextUsuario.setText(String.valueOf(mod.getUsuario()));
                frm.jTextCargo.setText(mod.getCargo());

                this.frm.dispose();
                JOptionPane.showMessageDialog(null, "Bienvenido");

                //Se valida el rol del usuario para seleccionar el formulario que puede modificar
                String Rol = "";
                Rol = mod.getCargo();
                if ("Administrador".equals(Rol)) {
                    FrmAdministrador Adminis = new FrmAdministrador();
                    new FrmAdministrador().setVisible(true);
                } else {
                    if ("Empleado".equals(Rol)) {
                        IndexUsuario.main();
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "No Existen Registros");

            }

        }

    }

}
