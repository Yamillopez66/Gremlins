
package crudmvc;

import Controlador.CtrlUsuario;
import Modelo.UsuarioDAO;
import Modelo.Usuario;
import Vista.frmUsuario;


public class IndexUsuario {

  
    public static void main() {
        
        Usuario mod = new Usuario();
        UsuarioDAO modC = new UsuarioDAO();
        frmUsuario frm = new frmUsuario();
        
        CtrlUsuario ctrl = new CtrlUsuario(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
        
        
    }
    
}
