/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beens;

import java.io.InputStream;

/**
 *
 * @author User1
 */
public class carritoBeens {
    int id;
    String nombre;
    InputStream imagen;
    float costo;
    float costoTotal;

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

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public carritoBeens() {
    }

    public carritoBeens(int id, String nombre, InputStream imagen, float costo, float costoTotal) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.costo = costo;
        this.costoTotal = costoTotal;
    }
    
    
    
}
