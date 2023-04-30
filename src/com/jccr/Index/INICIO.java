
package com.jccr.Index;

import com.jccr.Controlador.CtrlLogin;
import com.jccr.Modelo.Login;
import com.jccr.Modelo.LoginDAO;
import com.jccr.Vista.frmLogin;


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
