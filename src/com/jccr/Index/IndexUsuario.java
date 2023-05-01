
package com.jccr.Index;

import com.jccr.Controlador.CtrlUsuario;
import com.jccr.Modelo.UsuarioDAO;
import com.jccr.Modelo.Usuario;
import com.jccr.Vista.FormUsuario;


public class IndexUsuario {

  
    public static void main() {
        
        Usuario mod = new Usuario();
        UsuarioDAO modC = new UsuarioDAO();
        FormUsuario frm = new FormUsuario();
        
        CtrlUsuario ctrl = new CtrlUsuario(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
        
        
    }
    
}
