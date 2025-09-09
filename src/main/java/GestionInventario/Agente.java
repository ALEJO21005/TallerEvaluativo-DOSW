package GestionInventario;

public interface Agente {

    public void notificarModificacionInventario(String producto, int cantidad);
    public void advertenciaBajoStock(String producto, int cantidad);
}
