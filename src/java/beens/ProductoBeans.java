/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beens;

import java.io.InputStream;



/**
 *
 * @author SENA
 */
public class ProductoBeans {
    private int id;
    private String nombre;
    private InputStream imagen;
    private float costo;
    
    private String descripcion;
    private int cantidad;
    private int estado;
    private int categoria;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public ProductoBeans() {
    }

    public ProductoBeans(int id, String nombre, InputStream imagen, float costo,  String descripcion, int cantidad, int estado, int categoria) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.costo = costo;
        
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.estado = estado;
        this.categoria = categoria;
    }

   
    
}
