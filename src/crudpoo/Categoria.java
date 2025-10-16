package crudpoo;

public class Categoria {
    private int id;
    private String nombre;

    private static int contador = 1;

    public Categoria(){}

    public Categoria(String nombre) {
        this.id = contador++;
        this.nombre = nombre;
    }

    // getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{id=" + id + ", nombre='" + nombre + "'}";
    }
}
