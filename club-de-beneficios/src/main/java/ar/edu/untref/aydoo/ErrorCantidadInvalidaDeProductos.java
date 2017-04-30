package ar.edu.untref.aydoo;

public class ErrorCantidadInvalidaDeProductos extends Error {
    
    public ErrorCantidadInvalidaDeProductos() {
        super("Debe ingresar 2 productos para poder realizar este descuento");
    }
}