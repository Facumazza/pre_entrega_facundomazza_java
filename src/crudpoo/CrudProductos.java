package crudpoo;

import java.util.*;

public class CrudProductos extends CrudConsola<Producto> {

    private final ArrayList<Producto> productos;
    private final ArrayList<Categoria> categorias;

    public CrudProductos(ArrayList<Producto> productos, ArrayList<Categoria> categorias) {
        this.productos = productos;
        this.categorias = categorias;
    }

    @Override
    public void crear() {
        System.out.println("1) Crear Artículo");
        System.out.println("2) Crear Servicio");
        int op = leerEntero("Elegí una opción: ");

        if (op == 1) {
            String nombre = leerTexto("Nombre: ");
            double precio = leerDouble("Precio: ");
            if (categorias.isEmpty()) {
                System.out.println("No hay categorías. Creá una primero.");
                return;
            }
            System.out.println("Categorías:");
            for (Categoria c : categorias) {
                System.out.println(c.getId() + ") " + c.getNombre());
            }
            int idCat = leerEntero("Elegí id de categoría: ");
            Categoria seleccionada = null;
            for (Categoria c : categorias) {
                if (c.getId() == idCat) { seleccionada = c; break; }
            }
            if (seleccionada != null) {
                productos.add(new Articulo(nombre, precio, seleccionada));
                System.out.println("Artículo creado.");
            } else {
                System.out.println("Categoría inválida.");
            }
        } else if (op == 2) {
            String nombre = leerTexto("Nombre: ");
            double precio = leerDouble("Precio: ");
            int duracion = leerEntero("Duración (horas): ");
            productos.add(new Servicio(nombre, precio, duracion));
            System.out.println("Servicio creado.");
        } else {
            System.out.println("Opción inválida.");
        }
    }

    @Override
    public void listar() {
        if (productos.isEmpty()) {
            System.out.println("(sin productos)");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    @Override
    public void actualizar() {
        int id = leerEntero("Id del producto: ");
        for (Producto p : productos) {
            if (p.getId() == id) {
                String nuevoNombre = leerTexto("Nuevo nombre: ");
                double nuevoPrecio = leerDouble("Nuevo precio: ");
                p.setNombre(nuevoNombre);
                p.setPrecio(nuevoPrecio);

                if (p instanceof Articulo) {
                    System.out.println("¿Cambiar categoría? 1=Sí / 0=No");
                    int cam = leerEntero("Opción: ");
                    if (cam == 1) {
                        for (Categoria c : categorias) {
                            System.out.println(c.getId() + ") " + c.getNombre());
                        }
                        int idCat = leerEntero("Elegí id de categoría: ");
                        for (Categoria c : categorias) {
                            if (c.getId() == idCat) { ((Articulo)p).setCategoria(c); break; }
                        }
                    }
                }

                if (p instanceof Servicio) {
                    System.out.println("¿Cambiar duración (horas)? 1=Sí / 0=No");
                    int cam = leerEntero("Opción: ");
                    if (cam == 1) {
                        int dur = leerEntero("Nueva duración (horas): ");
                        ((Servicio)p).setDuracionHoras(dur);
                    }
                }

                System.out.println("Actualizado: " + p);
                return;
            }
        }
        System.out.println("No se encontró producto con id " + id);
    }

    @Override
    public void eliminar() {
        int id = leerEntero("Id del producto a eliminar: ");
        boolean eliminado = productos.removeIf(p -> p.getId() == id);
        System.out.println(eliminado ? "Producto eliminado." : "No existía ese id.");
    }
}
