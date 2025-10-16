package crudpoo;

import java.util.ArrayList;
import java.util.Scanner;

public class CrudPedidos {
    private ArrayList<Pedido> pedidos;
    private ArrayList<Producto> productos;
    private CrudUsuarios crudUsuarios;
    public final Scanner scanner = new Scanner(System.in);

    public CrudPedidos(ArrayList<Pedido> pedidos, ArrayList<Producto> productos, CrudUsuarios crudUsuarios) {
        this.pedidos = pedidos;
        this.productos = productos;
        this.crudUsuarios = crudUsuarios;
    }

    public void mostrarOpciones() {
        System.out.println("\n=== CRUD de Pedidos ===");
        System.out.println("1) Crear pedido");
        System.out.println("2) Listar pedidos");
        System.out.println("3) Ver detalle de pedido");
        System.out.println("4) Eliminar pedido");
        System.out.println("0) Volver");
        System.out.print("Opción: ");
    }

    public void crear() {
        if (productos.isEmpty()) {
            System.out.println(" No hay productos disponibles para crear un pedido.");
            return;
        }
        if (crudUsuarios == null) {
            System.out.println(" No se puede crear pedido sin usuarios registrados.");
            return;
        }

        crudUsuarios.listar();
        System.out.print("Ingrese el ID del usuario para este pedido: ");
        int idUsuario = leerEntero();
        Usuario usuario = crudUsuarios.buscarPorId(idUsuario);
        if (usuario == null) {
            System.out.println(" Usuario no encontrado.");
            return;
        }

        Pedido pedido = new Pedido(usuario);

        boolean seguir = true;
        while (seguir) {
            listarProductosDisponibles();
            System.out.print("Ingrese ID del producto a agregar (0 para finalizar): ");
            int idProd = leerEntero();
            if (idProd == 0) break;

            Producto p = buscarProductoPorId(idProd);
            if (p == null) {
                System.out.println(" Producto no encontrado.");
                continue;
            }

            System.out.print("Cantidad: ");
            int cantidad = leerEntero();
            pedido.agregarProducto(p, cantidad);

            System.out.print("¿Agregar otro producto? (s/n): ");
            String resp = scanner.nextLine();
            if (!resp.equalsIgnoreCase("s")) seguir = false;
        }

        pedidos.add(pedido);
        System.out.println(" Pedido creado con éxito:");
        System.out.println(pedido.mostrarDetalle());
    }

    public void listar() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }
        System.out.println("=== Lista de Pedidos ===");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }

    public void verDetalle() {
        listar();
        if (pedidos.isEmpty()) return;

        System.out.print("Ingrese ID del pedido a ver: ");
        int id = leerEntero();

        Pedido pedido = buscarPorId(id);
        if (pedido == null) {
            System.out.println(" Pedido no encontrado.");
            return;
        }

        System.out.println(pedido.mostrarDetalle());
    }

    public void eliminar() {
        listar();
        if (pedidos.isEmpty()) return;

        System.out.print("Ingrese ID del pedido a eliminar: ");
        int id = leerEntero();

        Pedido pedido = buscarPorId(id);
        if (pedido == null) {
            System.out.println(" Pedido no encontrado.");
            return;
        }

        pedidos.remove(pedido);
        System.out.println(" Pedido eliminado con éxito.");
    }

    // === MÉTODOS AUXILIARES ===

    private Producto buscarProductoPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    private Pedido buscarPorId(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    private void listarProductosDisponibles() {
        System.out.println("=== Productos disponibles ===");
        for (Producto p : productos) {
            System.out.println(p.getId() + ") " + p.getNombre() + " - $" + p.getPrecio());
        }
    }

    public int leerEntero() {
        while (true) {
            try {
                String linea = scanner.nextLine();
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }
}


