package GestionInventario;

import java.util.ArrayList;

public class Producto {

    private String nombre;
    private double precio;
    private int cantidad;
    private String categoria;
    private Inventario inventario = new Inventario();

    public Producto(String nombre, double precio, int cantidad, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        if (cantidad < 0) {throw new IllegalArgumentException("La cantidad no puede ser negativa");}
        else {this.cantidad = cantidad;}
        this.categoria = categoria;

    }

    public int getCantidad() {return cantidad;}
    public String getNombre() {return nombre;}


    public void setCantidad(int cantidad) {
        int nuevaCantidad = this.cantidad + cantidad;
        if (nuevaCantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        this.cantidad = nuevaCantidad;
    }



}