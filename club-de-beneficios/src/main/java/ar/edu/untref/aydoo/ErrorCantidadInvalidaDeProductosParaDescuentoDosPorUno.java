package ar.edu.untref.aydoo;

public class ErrorCantidadInvalidaDeProductosParaDescuentoDosPorUno extends Error {
    
    public ErrorCantidadInvalidaDeProductosParaDescuentoDosPorUno() {
        super("Debe ingresar 2 productos para poder realizar este descuento");
    }
    
}
