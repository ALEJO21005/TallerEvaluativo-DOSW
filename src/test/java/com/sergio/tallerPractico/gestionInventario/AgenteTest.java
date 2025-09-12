package com.sergio.tallerPractico.gestionInventario;
import GestionInventario.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AgenteTest {

    @Test
    public void notificarModificacionInventarioTest() {
        Inventario inventario = new Inventario();
        AgenteLog agenteLog = new AgenteLog();

        inventario.registrarAgente(agenteLog);
        Producto televisor = new Producto("Televisor", 1000.0, 10, "Electrodomésticos");
        inventario.agregarProducto(televisor);
        inventario.modificarCantidadProducto("Televisor", 5);
        assertEquals(15, inventario.getCantidadProductos("Televisor"));
    }

    @Test
    public void advertenciaBajoStockTest() {
        Inventario inventario = new Inventario();
        AgenteAdvertencia agenteAdvertencia = new AgenteAdvertencia();

        inventario.registrarAgente(agenteAdvertencia);
        Producto lavadora = new Producto("Lavadora", 1200.0, 6, "Electrodomésticos");
        inventario.agregarProducto(lavadora);
        inventario.modificarCantidadProducto("Lavadora", -2);
        assertEquals(4, inventario.getCantidadProductos("Lavadora"));
    }

    @Test
    public void multiplesAgentesNotificadosTest() {
        Inventario inventario = new Inventario();
        AgenteLog agenteLog = new AgenteLog();
        AgenteAdvertencia agenteAdvertencia = new AgenteAdvertencia();

        inventario.registrarAgente(agenteLog);
        inventario.registrarAgente(agenteAdvertencia);
        Producto nevera = new Producto("Nevera", 2000.0, 3, "Electrodomésticos");
        inventario.agregarProducto(nevera);
        inventario.modificarCantidadProducto("Nevera", -2);
        assertEquals(1, inventario.getCantidadProductos("Nevera"));
    }





}
