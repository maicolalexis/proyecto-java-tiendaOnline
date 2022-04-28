/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beens;

/**
 *
 * @author varga
 */
public class BeensCarrito {
    int item;
    int id;
    String nombres;
    String descripcion;
    float Costo;
    int cantidad;
    double subTotal;

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCosto() {
        return Costo;
    }

    public void setCosto(float Costo) {
        this.Costo = Costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
    public BeensCarrito() {
    }

    public BeensCarrito(int item, int id, String nombres, String descripcion, float Costo, int cantidad, double subTotal) {
        this.item = item;
        this.id = id;
        this.nombres = nombres;
        this.descripcion = descripcion;
        this.Costo = Costo;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }
    

}