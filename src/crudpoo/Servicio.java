package crudpoo;

public class Servicio extends Producto {

    private int duracionHoras;

    public Servicio(String nombre, double precio, int duracionHoras) {
        super(nombre, precio);
        this.duracionHoras = duracionHoras;
    }

    //getters y setters
    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    // 20% de descuento
    @Override
    public double aplicarDescuento() {
        return getPrecio() * 0.80;
    }

    @Override
    public String toString() {
        return super.toString() + ", duracion=" + duracionHoras + "h";
    }
}
