package ar.edu.untref.aydoo;

public class ErrorPorcentajeDeDescuentoInvalido extends Error {
    
    public ErrorPorcentajeDeDescuentoInvalido() {
        super("El porcentaje de descuento ingresado debe ser superior al minimo");
    }
    
}
