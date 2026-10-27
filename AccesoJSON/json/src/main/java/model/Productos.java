package model;

import java.io.Serializable;

public class Productos implements Serializable{
    
    public int id;
    public String nombre;
    public double precio;
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
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public Productos() {
    }
    public Productos(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override 
    public String toString(){
        return Integer.toString(this.id) + this.nombre + Double.toString(precio);
    }
    
}