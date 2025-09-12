package GestionInventario;
import java.util.*;


public class Inventario {

    private HashMap<String, Producto> inventarioProductos;
    private List<Agente> agentes;

    public Inventario() {
        inventarioProductos = new HashMap<>();
        agentes = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        inventarioProductos.put(producto.getNombre().toLowerCase(), producto);
        notificarModificacion(producto.getNombre(), producto.getCantidad());
    }

    public void registrarAgente(Agente agente) {
        agentes.add(agente);
    }

    public void  modificarCantidadProducto(String nombre, int cantidad) {

        Producto producto = inventarioProductos.get(nombre.toLowerCase());
        if (producto != null) {
            producto.setCantidad(cantidad);
            notificarModificacion(nombre, producto.getCantidad());
            if (producto.getCantidad() < 5) {
                notificarAdvertencia(nombre, producto.getCantidad());
            }
        } else {
            throw new IllegalArgumentException("Producto no encontrado en el inventario");
        }
    }

    public int getCantidadProductos(String nombreProducto) {

        Producto producto = inventarioProductos.get(nombreProducto.toLowerCase());
        if (producto != null) {
            return producto.getCantidad();
        } else {
            throw new IllegalArgumentException("Producto no encontrado en el inventario");
        }
    }

    public HashMap<String, Producto> getInventarioProductos() {return inventarioProductos;}

    public void notificarModificacion(String nombre, int cantidad) {
        for (Agente agente : agentes) {
            agente.notificarModificacionInventario(nombre, cantidad);
        }
    }

    public void notificarAdvertencia(String nombre, int cantidad) {
        for (Agente agente : agentes) {
            agente.advertenciaBajoStock(nombre, cantidad);
        }
    }

}
