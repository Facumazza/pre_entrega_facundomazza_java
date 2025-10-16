package main.java;

import java.util.ArrayList;
import java.util.Scanner;

import crudpoo.*;

public class Main {

    public static void main(String[] args) {

        final ArrayList<Producto> productos = new ArrayList<>();
        final ArrayList<Categoria> categorias = new ArrayList<>();
        final ArrayList<Usuario> usuarios = new ArrayList<>();
        final ArrayList<Pedido> pedidos = new ArrayList<>();

        categorias.add(new Categoria("Tecnología"));
        categorias.add(new Categoria("Hogar"));
        categorias.add(new Categoria("Libros"));

        final CrudCategorias crudCat = new CrudCategorias(categorias);
        final CrudProductos crudProd = new CrudProductos(productos, categorias);
        final CrudUsuarios crudUsr = new CrudUsuarios(usuarios);
        final CrudPedidos crudPed = new CrudPedidos(pedidos, productos, crudUsr);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        // === Menú principal ===
        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN ===");
            System.out.println("1) CRUD de Productos");
            System.out.println("2) CRUD de Categorías");
            System.out.println("3) CRUD de Usuarios");
            System.out.println("4) CRUD de Pedidos");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            String linea = scanner.nextLine();
            try {
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                // === CRUD de PRODUCTOS ===
                case 1 -> {
                    int op;
                    do {
                        crudProd.mostrarOpciones();
                        op = crudProd.leerEntero("");
                        switch (op) {
                            case 1 -> crudProd.crear();
                            case 2 -> crudProd.listar();
                            case 3 -> crudProd.actualizar();
                            case 4 -> crudProd.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }

                // === CRUD de CATEGORÍAS ===
                case 2 -> {
                    int op;
                    do {
                        crudCat.mostrarOpciones();
                        op = crudCat.leerEntero("");
                        switch (op) {
                            case 1 -> crudCat.crear();
                            case 2 -> crudCat.listar();
                            case 3 -> crudCat.actualizar();
                            case 4 -> crudCat.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }

                // === CRUD de USUARIOS ===
                case 3 -> {
                    int op;
                    do {
                        crudUsr.mostrarOpciones();
                        op = crudUsr.leerEntero();
                        switch (op) {
                            case 1 -> crudUsr.crear();
                            case 2 -> crudUsr.listar();
                            case 3 -> crudUsr.actualizar();
                            case 4 -> crudUsr.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }

                // === CRUD de PEDIDOS ===
                case 4 -> {
                    int op;
                    do {
                        crudPed.mostrarOpciones();
                        op = crudPed.leerEntero();
                        switch (op) {
                            case 1 -> crudPed.crear();
                            case 2 -> crudPed.listar();
                            case 3 -> crudPed.verDetalle();
                            case 4 -> crudPed.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }

                // === SALIR ===
                case 0 -> System.out.println(" ¡Hasta luego!");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        scanner.close();
    }
}


















