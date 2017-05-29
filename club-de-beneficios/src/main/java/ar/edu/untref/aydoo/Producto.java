package ar.edu.untref.aydoo;

public class Producto {

    private final String nombre;
    private final double precio;
    private final String tipoDeProducto;

    public Producto(String nombre, double precio, String tipoDeProducto) {
            this.nombre = nombre;
            this.precio = precio;
            this.tipoDeProducto = tipoDeProducto;
    }

    public String getNombre() {
            return this.nombre;
    }

    public double getPrecio() {
            return this.precio;
    }

       public String getTipoDeProducto() {
            return this.tipoDeProducto;
    }

}
