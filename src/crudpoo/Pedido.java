package crudpoo;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {
    private static int contador = 1;
    private int id;
    private Usuario usuario;
    private ArrayList<LineaPedido> lineas;

    public Pedido(Usuario usuario) {
        this.id = contador++;
        this.usuario = usuario;
        this.lineas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<LineaPedido> getLineas() {
        return lineas;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        lineas.add(new LineaPedido(producto, cantidad));
    }

    public double calcularTotal() {
        double total = 0;
        for (LineaPedido l : lineas) {
            total += l.getSubtotal();
        }
        return total;
    }

    public String mostrarDetalle() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Pedido #").append(id).append(" ===\n");
        sb.append("Usuario: ").append(usuario != null ? usuario.getNombre() : "Sin asignar").append("\n");
        sb.append("Productos:\n");
        for (LineaPedido l : lineas) {
            sb.append(" - ").append(l.getProducto().getNombre())
              .append(" x").append(l.getCantidad())
              .append(" = $").append(l.getSubtotal()).append("\n");
        }
        sb.append("Total: $").append(calcularTotal()).append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Pedido #" + id + " - Usuario: " +
               (usuario != null ? usuario.getNombre() : "Sin usuario") +
               " - Total: $" + calcularTotal();
    }
}


