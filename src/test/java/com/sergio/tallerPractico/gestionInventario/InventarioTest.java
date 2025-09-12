package com.sergio.tallerPractico.gestionInventario;

import GestionInventario.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

public class InventarioTest {

    private HashMap<String, Producto> inventarioProductos;
    private Producto lavadora;
    private Inventario inventario;

    @BeforeEach
    public void setUp() {
        inventarioProductos = new HashMap<>();
        inventario = new Inventario();
        lavadora = new Producto("Lavadora", 1350.9, 5, "Electrodomésticos");
    }

    @Test
    public void agregarInventarioTest() {
        inventario.agregarProducto(lavadora);
        Producto televisor = new Producto("Televisor", 800.0, 10, "Electrodomésticos");
        inventario.agregarProducto(televisor);
        assertEquals(2, inventario.getInventarioProductos().size());
    }

    @Test
    public void actualizarInventarioProductoTest() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inventario.modificarCantidadProducto("lavadora", 3);
        });
        Producto televisor = new Producto("Televisor", 800.0, 10, "Electrodomésticos");
        inventario.agregarProducto(televisor);
        inventario.modificarCantidadProducto("Televisor", -5);
        assertEquals("Producto no encontrado en el inventario", exception.getMessage());
        assertEquals(5, inventario.getCantidadProductos("Televisor"));
    }
}
