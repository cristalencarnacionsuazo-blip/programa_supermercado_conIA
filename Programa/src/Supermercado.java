import java.util.*;

public class Supermercado {
    private List<Producto> inventario;
    private Carrito carrito;

    public Supermercado() {
        inventario = new ArrayList<>();
        inicializarInventario();
        carrito = new Carrito(inventario);
    }

    private void inicializarInventario() {
        inventario.add(new Producto(1, "Leche", 1.5, 50));
        inventario.add(new Producto(2, "Pan", 0.8, 100));
        inventario.add(new Producto(3, "Huevos (docena)", 2.2, 30));
        inventario.add(new Producto(4, "Manzanas (kg)", 1.2, 20));
        inventario.add(new Producto(5, "Arroz (kg)", 1.0, 40));
        System.out.println("Inventario inicializado con 5 productos.");
    }

    public void mostrarProductos() {
        System.out.println("\n--- PRODUCTOS DISPONIBLES ---");
        for (Producto p : inventario) {
            System.out.println(p);
        }
    }

    public Producto buscarProducto(int id) {
        return inventario.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public List<Producto> getInventario() {
        return inventario;
    }
}
