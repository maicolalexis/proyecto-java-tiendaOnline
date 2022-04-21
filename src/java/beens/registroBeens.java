/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beens;

/**
 *
 * @author SENA-WS-H50-1
 */
public class registroBeens {
    private int id;
 private String nombre;
 private String email;
 private String contact;
 private String pass;
 private String rol;

    public registroBeens() {
    }

    public registroBeens(int id, String nombre, String email, String contact, String pass, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contact = contact;
        this.pass = pass;
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
 
 
 
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

  
  
 
}
