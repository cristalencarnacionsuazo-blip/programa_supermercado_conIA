import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Supermercado superM = new Supermercado();
        Carrito carrito = superM.getCarrito();

        System.out.println("=== SISTEMA DE SUPERMERCADO ===");
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (opcion) {
                case 1:
                    superM.mostrarProductos();
                    break;
                case 2:
                    System.out.print("ID del producto: ");
                    int id = scanner.nextInt();
                    System.out.print("Cantidad: ");
                    int cant = scanner.nextInt();
                    carrito.agregarItem(id, cant);
                    break;
                case 3:
                    carrito.mostrarItems();
                    break;
                case 4:
                    System.out.print("ID del producto: ");
                    id = scanner.nextInt();
                    System.out.print("Cantidad: ");
                    cant = scanner.nextInt();
                    carrito.removerItem(id, cant);
                    break;
                case 5:
                    carrito.mostrarItems();
                    System.out.printf("TOTAL A PAGAR: $%.2f%n", carrito.calcularTotal());
                    break;
                case 6:
                    carrito = new Carrito(superM.getInventario()); // reset cart
                    System.out.println("Carrito vaciado.");
                    break;
                case 0:
                    System.out.println("¡Gracias por su compra!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n1. Ver productos");
        System.out.println("2. Agregar al carrito");
        System.out.println("3. Ver carrito");
        System.out.println("4. Remover del carrito");
        System.out.println("5. Checkout (total)");
        System.out.println("6. Vaciar carrito");
        System.out.println("0. Salir");
        System.out.print("Elige opción: ");
    }
}
