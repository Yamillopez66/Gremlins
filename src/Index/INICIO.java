
package crudmvc;

import Controlador.CtrlLogin;
import Modelo.Login;
import Modelo.LoginDAO;
import Vista.frmLogin;


public class INICIO {

  
    public static void main(String[] args) {
        
        Login mod = new Login();
        LoginDAO modC = new LoginDAO();
        frmLogin frm = new frmLogin();
        
        CtrlLogin ctrl = new CtrlLogin(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
        
        
    }
    
}
