/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexionBD.ConexBD;
import beens.registroBeens;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SENA-WS-H50-1
 */
//SE HACEN LAS CONSULTAS DE LA BASE DE DATOS



//se instancia la clase conexBD para poder obtener los datos de esta por medio de la conexion
public class registroDAO {

    ConexBD con = new ConexBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    int resultado;

    public int insertar(registroBeens r) {
        //aca va a consultar el nombre y la contraseña, etc esten localizadas en la base de datos
         //String consulta guardara eso. 
        String sql = "insert into registro(Nombres,Contacto,Correo,Password)"
                + "values(?,?,?,?)";
        try {
            
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);

            ps.setString(1, r.getNombre());
            ps.setString(2, r.getContact());
            ps.setString(3, r.getEmail());
            ps.setString(4, r.getPass());
            //esta diciendo aca que el parametro 1 es el usuario y el parametro 2 es la contraseña
            ps.executeUpdate();
            //Ejecuta la sentencia
        } catch (Exception e) {
        }
        //y si se ejecuta bien la sentencia retorna un valor entero
        return resultado;
    } 
    public registroBeens validar(String usr, String pss) {
        //instancia la clase de registro beens ya que tiene constructores y getters and setters
        registroBeens miRegistro = new registroBeens();
        
        String sql = "Select * from registro where Nombres=? and Password=?";
        
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            ps.setString(1, usr);
            ps.setString(2, pss);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                //aca no es necesario las demas cosas que no son nombres y password
                //ya que en "select * from etc " solamente se necesita nombres y password claramente
                
                miRegistro.setId(rs.getInt("id"));
                miRegistro.setNombre(rs.getString("Nombres"));
                miRegistro.setContact(rs.getString("Contacto"));
                miRegistro.setEmail(rs.getString("Correo"));
                miRegistro.setPass(rs.getString("Password"));
                miRegistro.setRol(rs.getString("Rol"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(registroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miRegistro;
    }

    public List getAll() {
        
        String sql = "select * from registro";
        
        List<registroBeens> lista = new ArrayList<>();

        try {
            

            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
          
            while (rs.next()) {
                registroBeens regM = new registroBeens();
                regM.setId(rs.getInt("id"));
                regM.setNombre(rs.getString("Nombres"));
                regM.setContact(rs.getString("Contacto"));
                regM.setEmail(rs.getString("Correo"));
                regM.setRol(rs.getString("Rol"));

                lista.add(regM);
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(registroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean eliminar(int id) {
        String sql = "delete from registro where id=" + id;

        try {
            cnx = con.ConexBD();
            Statement st = cnx.createStatement();
            int estado = st.executeUpdate(sql);
            if (estado > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(registroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public registroBeens cargar(int id) {
        registroBeens miRegisB = new registroBeens();
        String sql = "select * from registro where id=" + id;
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                miRegisB.setId(rs.getInt(1));
                miRegisB.setNombre(rs.getString(2));
                miRegisB.setContact(rs.getString(3));
                miRegisB.setEmail(rs.getString(4));
                miRegisB.setPass(rs.getString(5));
                miRegisB.setRol(rs.getString(6));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(registroBeens.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miRegisB;
    }
   

   public int modificar(registroBeens r) {

        String sql = "UPDATE registro SET Nombres=?,Contacto=?,Correo=?" + " WHERE id=?";
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            
            ps.setString(1, r.getNombre());
            ps.setString(2, r.getContact());
            ps.setString(3, r.getEmail());
            ps.setString(4, r.getPass());
            //aca es necesario agregar el id ya que vamos a modificar mediante el id
            ps.setInt(4, r.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(registroBeens.class.getName()).log(Level.SEVERE, null, e);

        }
        return resultado;
    } 
   public List getAl() {
        
        String sql = "select * from registro where id";
        
        List<registroBeens> lista = new ArrayList<>();
        
        

        try {
            

            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
          
            while (rs.next()) {
                registroBeens regM = new registroBeens();
                regM.setId(rs.getInt("id"));
                regM.setNombre(rs.getString("Nombres"));
                regM.setContact(rs.getString("Contacto"));
                regM.setEmail(rs.getString("Correo"));
                regM.setRol(rs.getString("Rol"));

                lista.add(regM);
                
               
       
        }
            
            
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(registroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

 
    }

        

     
