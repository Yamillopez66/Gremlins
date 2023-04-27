
package Complementos;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * permite abstraer cualquier
 *conexion JDBC.
*/
public class JDBCMiddler{
    /**
     *Una cadena con la ubicacion del controlador JDBC, en la forma 
     *<I>paquete.subpaquetes.DriverClass</I>
     *Por defecto toma el valor sun.jdbc.odbc.JdbcOdbcDriver.
    */
    protected String controlador = "sun.jdbc.odbc.JdbcOdbcDriver";

    /**Una cadena con la ubicacion del recurso de base de datos en la forma
     *<I>protocolo:subprotocolo:nombrerecurso</I>. El protocolo por lo general
     *es jdbc.fabricante, el subprotocolo depende del controlador e igualmente
     *nombrederecurso.
    */
    protected String url = "jdbc.odbc.default";

    /**Una referencia al objeto Connection de la base de datos*/
    protected Connection conexion;

    /**Una cadena con el nombre de usuario(Login)*/
    protected String usuario;

    /**Una cadena con la clave (password)*/
    protected String clave = new String();

    /**Una cadena SQL*/
    protected String SQL;

    /**
     *Crea un objeto JDBCMiddler vacio sin parametros
     *de conexion. Constructor por defecto.
    */
    protected JDBCMiddler(){
        System.out.println("new EJB["+this.hashCode()+"]");
    }//Fin Constructor Default JDBCMiddler
	
    /**
     *Crea un objeto JDBCMiddler, que encapsula toda la informacion
     *y metodos de acceso a una base de datos dentro de una aplicacion
     *en el contexto JDBC.
     *@param	controlador		Una cadena con el controlador JDBC a emplear
     *@param	url			Una cadena de conexion JDBC a la Base de Datos	 
     *@param 	usuario			Una cadena con el login
     *@param	clave			Una cadena con la clave de acceso
    */
    protected JDBCMiddler(String controlador, String url, String usuario, String clave){
        this.controlador = controlador;
        this.url=url;
        this.usuario=usuario;
        this.clave=clave;
    }//Fin Constructor JDBCMiddler

    /**
     *Averigua si la conexion con la Base de Datos esta  disponible.
     *@return	Regresa verdadero (true) si la conexion esta disponible.
     *La conexion esta disponible cuando conexion != null y
     * !conexi n.isClosed()
    */
    protected boolean hayConexion(){
        return this.conexion != null;
    }//Fin hayConexion	

    /**
     *Establece una conexion con la base de datos.Si existen parametros de conexion los usa y se conecta de la manera tradicional.
     * @return Regresa verdadero (true) si pudo establecer la conexion
     * de lo contrario regresa falso (false).
     * @throws java.lang.Exception
    */
    protected boolean conectar() throws Exception{
        if(!hayConexion()){
            return conectar(this.usuario, this.clave);
        }
        else{     
            return true;
        }
    }//Fin conectar

    /**
     *Se conecta a un servicio JDBC usando java.naming.
     *Los parametros de configuracion se manejan para
     *el contexto de la aplicacion, permitiendo un 
     *pool de conexiones persistentes disponibles
     *para toda la aplicacion. Tomcat proporciona este
     *servicio configurandolo en el archivo web.xml
     *o server.xml
     *@param servicio Una cadena como "java:comp/env/servicio"
     *
     */

    /**
     * Cierra la conexion con la base de datos
     * @throws java.lang.Exception
     */
    protected void desconectar() throws Exception{
        if(this.hayConexion()){
            this.conexion.close();
            this.conexion = null;
        }
    }//Fin desconectar
    
    protected boolean ejecutarActualizacionSQL(String comandoSQL) throws Exception{
        boolean ok;
        if(this.conectar()){   
            try ( //La consulta es preparada porque requiere de parametros
            //por ejemplo:
            //delete from producto where precio=?
            //insert into producto values (?,?,?,?,?)
            //los ? indican parametros ordenados por posicion
                    PreparedStatement sql = this.conexion.prepareStatement(comandoSQL)) {
                ok = sql.executeUpdate()!=0;
                //importante cerrar la conexion
            }
            this.desconectar();

            return ok;
        }
        else return false;
    }//Fin ejecutarSQL
    
    
    
    /**
     *Establece una conexion con la base de datos, usando el usuario
     *y clave especificados.Si ya hay una conexi n, esta es cerrada.
     *@param usuario Una cadena con el nombre de usuario
     *@param clave	Una cadena con la clave
     *@return Regresa verdadero (true) si pudo establecer la conexion
     *de lo contrario regresa falso (false).
     * @throws java.lang.Exception
    */
    protected boolean conectar(String usuario, String clave) throws Exception{
	//Registra el controlador de manera implicita
        Class.forName(controlador).newInstance();
        //System.err.println("Conectado. ");
	//Obtiene la conexion
	//System.out.println(url+","+usuario+","+clave+":OK!!!");
	this.conexion = DriverManager.getConnection(url,usuario,clave);
	//Actualiza usuario y clave del middler
	this.usuario = usuario;
	this.clave = clave;
        return this.conexion != null;
    }//Fin conectar
    
    /**
     * 
     * @param procedimiento
     * @return 
     */
    protected boolean ejecutarProcedimientoOracle(String procedimiento){
        boolean ejecutado = false;
        try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = this.conexion.prepareCall(procedimiento);
            ejecutado = cst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCMiddler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ejecutado;
    }
    
    protected ArrayList<String> getSQL(String SQL) throws Exception{
        StringBuffer html = new StringBuffer();
        ArrayList<String> v = new ArrayList<String>();
        if(conectar()){
            ResultSet rs = ejecutarSQL(SQL);
            ResultSetMetaData rsm = rs.getMetaData();
            while(rs.next()){
                String r = "";
                for(int i=1; i <= rsm.getColumnCount(); i++){
                    if(i<rsm.getColumnCount())
                        r+=rs.getString(i)+"#_";
                    else
                        r+=rs.getString(i);
                }
            v.add(r);
            }	 
            desconectar();
        }
        return v;
    }//Fin getSQL
    
	
    /**
     *Ejecuta una sentencia SQL y regresa como resultado un objeto ResultSet
     *@param	consultaSQL	Cadena que contiene una sentencia de 
     *consulta SQL: SELECT listaCampos FROM listaTablas WHERE listaCondiciones
     *@return	Regresa un objeto ResulSet con el resultado de la consulta
    */

    protected ResultSet ejecutarSQL(String consultaSQL) throws Exception{
        if(this.conectar()){
            Statement sql= this.conexion.createStatement();
            return sql.executeQuery(consultaSQL);
        }
        else return null;
    }//Fin ejecutarSQL
    
    

/*-METODOS DE ACCESO-*/	
	
    /**Metodo de acceso a la propiedad usuari
     * @return o
     */
    protected String getUsuario(){
        return this.usuario;
    }//fin getUsuario

    /**Metodo de acceso a la propiedad clav
     * @return e*/
    protected String getClave(){
        return this.clave;
    }//fin getClave

    /**Metodo de acceso a la propiedad ur
     * @return l*/
    protected String getUrl(){
        return this.url;
    }//fin getUrl

    /**Metodo de acceso a la propiedad controlado
     * @return r*/
    protected String getControlador(){
        return this.controlador;
    }//fin getControlador
	
/*-METODOS DE MODIFICACION-*/
	
    /**Metodo de modificacion a la propiedad usuari
     * @param usuario
     */
    protected void setUsuario(String usuario){
     this.usuario=usuario;
    }//fin setUsuario

    /**Metodo de modificacion a la propiedad clav
     * @param clave
     */
    protected void setClave(String clave){
     this.clave = clave;
    }//fin setClave

    /**
     * Metodo de modificacion a la propiedad url
     * @param url
     */
    protected void setUrl(String url){
     this.url=url;
    }//fin setUrl

    /**Metodo de modificacion a la propiedad controlador
     * @param controlador
     */
    protected void setControlador(String controlador){
     this.controlador = controlador;
    }//fin setControlador

    /**Metodo de modificacion a la propiedad consult
     * @param SQL a
     */
    protected void setSQL(String SQL){
     this.SQL = SQL;
    }//fin setSQL

    
    /**
     *Metodo de prueba
     *Recibe como argumento el nombre del archivo de 
     *configuracion.Para usarlo:
     * java JDBCMiddler archivo.conf
     * @param args
     * @throws java.lang.Exception
    */
    protected static void main(String args[]) throws Exception{
	 //Se recibe como argumento del main el archivo de 
	 //configuracion que contiene el driver
	 //la url, el login y la clave
	 String parametros[] = leerParametros(args[0]);
	 int n = 1;
	 JDBCMiddler middler = new JDBCMiddler(parametros[0], parametros[1], parametros[2], parametros[3]);
	 if(middler.conectar()){
	     System.out.println(parametros[4]);
             ResultSet rs = middler.ejecutarSQL(parametros[4]);
	     while(rs.next()){
                 ResultSetMetaData rsm = rs.getMetaData();
                 System.out.println("****************************");
                 System.out.println("Registro: "+(n++));
                 for(int i=1;i<=rsm.getColumnCount();i++){
                     System.out.print(rsm.getColumnName(i)+": ");
                     System.out.println(rs.getString(i));
                 }
             }	 
             middler.desconectar();
             System.out.println("todo bien");
	}
    }//fin main
	
    /**
    *Servicio que permite Leer los parametros de entrada
    */   
    protected static String [] leerParametros (String rutaArchivo) throws Exception{
  	 String [] parametros = new String[5];
  	 java.io.BufferedReader flujoE = new java.io.BufferedReader(new java.io.FileReader (rutaArchivo));
  	 parametros[0] = flujoE.readLine();
  	 parametros[1] = flujoE.readLine();
  	 parametros[2] = flujoE.readLine();
  	 parametros[3] = flujoE.readLine();
  	 parametros[4] = flujoE.readLine();
  	 flujoE.close();
  	 return parametros;
    }//fin leerParametros
    	
}//Fin JDBCMiddler