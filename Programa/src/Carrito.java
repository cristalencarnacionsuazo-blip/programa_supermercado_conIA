import java.util.*;

public class Carrito {
    private Map<Integer, Integer> items; // id -> quantity
    private List<Producto> productos;

    public Carrito(List<Producto> productos) {
        this.items = new HashMap<>();
        this.productos = productos;
    }

    public void agregarItem(int id, int cantidad) {
        if (cantidad > 0) {
            items.put(id, items.getOrDefault(id, 0) + cantidad);
            System.out.println("Agregado " + cantidad + " de producto ID " + id);
        }
    }

    public void removerItem(int id, int cantidad) {
        items.put(id, Math.max(0, items.getOrDefault(id, 0) - cantidad));
        if (items.get(id) == 0) {
            items.remove(id);
        }
        System.out.println("Removido " + cantidad + " de producto ID " + id);
    }

    public double calcularTotal() {
        double total = 0;
        for (Map.Entry<Integer, Integer> entry : items.entrySet()) {
            int id = entry.getKey();
            int qty = entry.getValue();
            Producto p = productos.stream().filter(prod -> prod.getId() == id).findFirst().orElse(null);
            if (p != null) {
                total += p.getPrecio() * qty;
            }
        }
        return total;
    }

    public void mostrarItems() {
        if (items.isEmpty()) {
            System.out.println("Carrito vacío.");
            return;
        }
        System.out.println("\n--- CARRITO ---");
        for (Map.Entry<Integer, Integer> entry : items.entrySet()) {
            int id = entry.getKey();
            int qty = entry.getValue();
            Producto p = productos.stream().filter(prod -> prod.getId() == id).findFirst().orElse(null);
            if (p != null) {
                System.out.println(p.getNombre() + " (ID:" + id + ") x" + qty + " = $" + (p.getPrecio() * qty));
            }
        }
        System.out.printf("TOTAL: $%.2f%n", calcularTotal());
    }

    public Map<Integer, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
