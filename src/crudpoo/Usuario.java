package crudpoo;

import java.io.Serializable;

public class Usuario implements Serializable {
    private static int contador = 1;
    private int id;
    private String nombre;
    private String email;

    public Usuario(String nombre, String email) {
        this.id = contador++;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " (" + email + ")";
    }
}

