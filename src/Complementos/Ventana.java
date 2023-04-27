package Complementos;
        
import javax.swing.JOptionPane;

public class Ventana{
    

    public static void imp(String msg1, String msg2){
	JOptionPane.showMessageDialog(null, msg1, msg2, JOptionPane.INFORMATION_MESSAGE);
    }
	
	
    public static void imp(int msg1, String msg2){
        JOptionPane.showMessageDialog(null, Integer.toString(msg1), msg2, JOptionPane.INFORMATION_MESSAGE);
    }
	
    public static void imp(double msg1, String msg2){
	JOptionPane.showMessageDialog(null, Double.toString(msg1), msg2, JOptionPane.INFORMATION_MESSAGE);
    }
	
    public static void imp(byte msg1, String msg2){
	JOptionPane.showMessageDialog(null, Byte.toString(msg1), msg2, JOptionPane.INFORMATION_MESSAGE);
    }
    	
    public static void imp(short msg1, String msg2){
	JOptionPane.showMessageDialog(null, Short.toString(msg1), msg2, JOptionPane.INFORMATION_MESSAGE);
    }
    	
    public static void imp(float msg1, String msg2){
	JOptionPane.showMessageDialog(null, Float.toString(msg1), msg2, JOptionPane.INFORMATION_MESSAGE);
    }
	
    public static void imp(long msg1, String msg2){
	JOptionPane.showMessageDialog(null, Long.toString(msg1), msg2, JOptionPane.INFORMATION_MESSAGE);
    }
	
    public static int leerInt(String msg){
	return(Integer.parseInt(JOptionPane.showInputDialog(msg)));
    }
	
    public static double leerDouble(String msg){
	return(Double.parseDouble(JOptionPane.showInputDialog(msg)));
    }
	
    public static long leerLong(String msg){
        return(Long.parseLong(JOptionPane.showInputDialog(msg)));
    }
		
    public static char leerChar(String msg){
        String a = JOptionPane.showInputDialog(msg);
        char b[] = a.toCharArray();
        return(b[0]);
    }
	
    public static byte leerByte(String msg){
        return(Byte.parseByte(JOptionPane.showInputDialog(msg)));
    }
	
    public static float leerFloat(String msg){	
	return(Float.parseFloat(JOptionPane.showInputDialog(msg)));
    }

    public static String leerCadena(String msg){	
	return(JOptionPane.showInputDialog(msg));
    }
    
    public static int leerOption(String msg){
    	return(JOptionPane.showOptionDialog(null, msg, "ventana", 1, 2, null, null, null));
    }
    
    /**
     * metodo confirmar
     * @param msg un String con el mensaje que aparecera como pregunta.
     * @param msg1 Un String con el titulo de la ventana
     * @return un int 0 si la respuesta es si o 1 si la respuesta es no.
     */
    public static int confirmar(String msg, String msg1){
    	return(JOptionPane.showConfirmDialog(null, msg, msg1, JOptionPane.YES_NO_OPTION));
    }
    
    /**
     * metodo err
     * @param msg un String con el mensaje que aparecera como error.
     * @param msg1 Un String con el titulo de la ventana
     */
    public static void err(String msg, String msg1){
    	JOptionPane.showMessageDialog(null, msg, msg1, JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * metodo ask
     * @param msg un String con el mensaje que aparecera como pregunta.
     * @param msg1 Un String con el titulo de la ventana
     */
    public static void ask(String msg, String msg1){
    	JOptionPane.showMessageDialog(null, msg, msg1, JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * metodo warning
     * @param msg un String con el mensaje que aparecera como advertencia.
     * @param msg1 Un String con el titulo de la ventana
     */
    public static void warning(String msg, String msg1){
    	JOptionPane.showMessageDialog(null, msg, msg1, JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * metodo si_No_Cancel
     * @param msg un String con el mensaje que aparecera como pregunta.
     * @param msg1 Un String con el titulo de la ventana
     * @return un int 0 si la respuesta es si o 1 si la respuesta es no.
     */
    public static int si_No_Cancel(String msg, String msg1){
    	return(JOptionPane.showConfirmDialog(null, msg, msg1, JOptionPane.YES_NO_CANCEL_OPTION));
    }
    
}