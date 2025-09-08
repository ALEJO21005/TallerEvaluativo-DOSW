package GestionInventario;

import java.util.ArrayList;

public class Producto {

    private String nombre;
    private double precio;
    private int cantidad;
    private String categoria;
    private ArrayList<Producto> productos;

    public Producto(String nombre, double precio, int cantidad, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        if (cantidad < 0) {throw new IllegalArgumentException("La cantidad no puede ser negativa");}
        else {this.cantidad = cantidad;}
        this.categoria = categoria;
        this.productos = new ArrayList<>();
    }

    public int getCantidad() {return cantidad;}

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {throw new IllegalArgumentException("La cantidad no puede ser negativa");}
        this.cantidad += cantidad;
    }



}