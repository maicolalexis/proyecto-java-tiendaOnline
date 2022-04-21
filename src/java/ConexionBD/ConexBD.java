/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SENA-WS-H50-1
 */
//ESTA CLASE TIENE TODA 
//LA CONEXION CON LA BASE DE DATOS ESTA NOS AYUDA A CONOCER LA CONEXION A LA BASE DE DATOS
public class ConexBD {
        Connection cnx;
    
    String url="jdbc:mysql://localhost/inventario";
    String usr="root";
    String pass="";
    
    public Connection ConexBD(){
        
          
         try {
            //se carga el driver mysql
              Class.forName("com.mysql.jdbc.Driver");
            //se hace la autentificacion de la bd
         cnx= (Connection) DriverManager.getConnection(url, usr, pass);
         if(cnx != null)
            {
                System.out.println("Conexión establecida");
                return cnx;
            }
         } 
           
         catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
        
    }
    public static void main(String[] args){
    ConexBD miCone = new ConexBD();
    miCone.ConexBD();
    }
    
}
