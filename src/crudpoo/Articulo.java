package crudpoo;

public class Articulo extends Producto {

    private Categoria categoria;

    public Articulo(String nombre, double precio, Categoria categoria) {
        super(nombre, precio);
        this.categoria = categoria;
    }

    //getters y setters
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // 10% de descuento desde la interfaz
    @Override
    public double aplicarDescuento() {
    	return getPrecio() * 0.90;
    }

    @Override
    public String toString() {
        return super.toString() + ", categoria=" + (categoria != null ? categoria.getNombre() : "Sin categoría");
    }
}
