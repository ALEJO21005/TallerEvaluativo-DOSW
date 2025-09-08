package com.sergio.tallerPractico.gestionInventario;

import GestionInventario.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
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
        assertEquals(1, inventario.getInventarioProductos().size());
        assertTrue(inventario.getInventarioProductos().containsKey("Lavadora"));
    }

    @Test
    public void actualizarInventarioProductoTest() {
        inventario.modificarCantidadProducto("lavadora", 3);
        Producto televisor = new Producto("Televisor", 800.0, 10, "Electrodomésticos");
        inventario.agregarProducto(televisor);
        inventario.modificarCantidadProducto("Televisor", -5);
        assertEquals(5, inventario.getInventarioProductos().size());
        assertEquals(8, inventario.getCantidadProductos().get("Lavadora").getCantidad());
    }
}
