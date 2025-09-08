package com.sergio.tallerPractico.gestionInventario;

import GestionInventario.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class ProductoTest {

    private Producto producto;
    private ArrayList<Producto> productos;

    @BeforeEach
    public void setUp() {
        producto = new Producto("Laptop", 1500.0, 10, "Electrónica");
        productos = new ArrayList<>();
        productos.add(producto);
    }

    @Test
    public void agregarProductoTest() {
        Producto telefono = new Producto("Smartphone", 800.0, 20, "Electrónica");
        productos.add(telefono);
        assertEquals(2, productos.size());
        assertTrue(productos.contains(telefono));
    }

    @Test
    public void agregarProductoCantNegativaTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Producto tablet = new Producto("Tablet", 300.0, -5, "Electrónica");
            productos.add(tablet);
        });
        String expectedMessage = "La cantidad no puede ser negativa";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void actualizarStockTest() {
        producto.setCantidad(5);
        assertEquals(15, producto.getCantidad());
    }
}
