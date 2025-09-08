package GestionInventario;

public class AgenteLog implements Agente {

    @Override
    public void notificarModificacionInventario(String producto, int cantidad) {
        System.out.println("Producto: " + producto + " -> " + cantidad + " unidades disponibles.");
    }

    @Override
    public void advertenciaBajoStock(String producto, int cantidad) {

    }
}
