package ar.edu.untref.aydoo;

public class Producto{
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = this.validarPrecio(precio);
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
        this.precio = this.precio * 1.21;
    }

    private double validarPrecio(double precio){
        if (precio < 0) throw new Error("El precio ingresado es incorrecto");
        return precio;
    }

}