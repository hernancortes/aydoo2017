package ar.edu.untref.aydoo;

public class Producto{
    public static final double MINIMOVALORDEUNARTICULO = 0.1;
    public static final double PORCENTAJEDEIVA = 0.21;
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
        //this.precio = this.validarPrecio(precio);
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
        this.precio = this.validarPrecio(nuevoPrecio);
    }

    public void aplicarIva(){
        this.precio = this.precio + (this.precio * PORCENTAJEDEIVA);
    }

    private double validarPrecio(double precio){
        if (precio < MINIMOVALORDEUNARTICULO) throw new Error("El precio ingresado es invalido");
        return precio;
    }

}