package crudpoo;

import java.util.ArrayList;
import java.util.Scanner;

public class CrudUsuarios extends CrudConsola<Usuario>{
    private ArrayList<Usuario> usuarios;
    public final Scanner scanner = new Scanner(System.in);

    public CrudUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void mostrarOpciones() {
        System.out.println("\n=== CRUD de Usuarios ===");
        System.out.println("1) Crear usuario");
        System.out.println("2) Listar usuarios");
        System.out.println("3) Actualizar usuario");
        System.out.println("4) Eliminar usuario");
        System.out.println("0) Volver");
        System.out.print("Opción: ");
    }

    public void crear() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        usuarios.add(new Usuario(nombre, email));
        System.out.println(" Usuario creado correctamente.");
    }

    public void listar() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        System.out.println("=== Lista de Usuarios ===");
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    public void actualizar() {
        listar();
        System.out.print("Ingrese ID del usuario a actualizar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Usuario u = buscarPorId(id);
        if (u == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (actual: " + u.getNombre() + "): ");
        u.setNombre(scanner.nextLine());
        System.out.print("Nuevo email (actual: " + u.getEmail() + "): ");
        u.setEmail(scanner.nextLine());
        System.out.println(" Usuario actualizado.");
    }

    public void eliminar() {
        listar();
        System.out.print("Ingrese ID del usuario a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Usuario u = buscarPorId(id);
        if (u == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        usuarios.remove(u);
        System.out.println(" Usuario eliminado.");
    }

    public Usuario buscarPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
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



