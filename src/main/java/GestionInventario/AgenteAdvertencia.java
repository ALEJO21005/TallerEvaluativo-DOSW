package GestionInventario;

public class AgenteAdvertencia implements Agente {

    @Override
    public void notificarModificacionInventario(String producto, int cantidad) {

    }

    @Override
    public void advertenciaBajoStock(String producto, int cantidad) {
        System.out.println("Alerta !!! El stock del producto: " + producto + " es muy bajo, solo quedan " + cantidad + " unidades disponibles.");
    }
}
