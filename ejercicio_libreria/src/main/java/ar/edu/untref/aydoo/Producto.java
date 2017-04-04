package ar.edu.untref.aydoo;

public class Producto{
    public static final double PORCENTAJEDEIVA = 0.21;
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre(){
        return this.nombre;
    }

    public double getPrecio(){
        return this.precio;
    }

    public void setNombre(String nuevoNombre){
        this.nombre = nuevoNombre;
    }

    public void setPrecio(double nuevoPrecio){
        this.precio = nuevoPrecio;
    }

    public void aplicarIva(){
        this.precio = this.precio + (this.precio * PORCENTAJEDEIVA);
    }
    
}