package ar.edu.untref.aydoo;

public class ErrorEstablecimientoNoPoseeNingunBeneficioParaLaTarjetaDelCliente extends Error {
    
    public ErrorEstablecimientoNoPoseeNingunBeneficioParaLaTarjetaDelCliente() {
        super("El establecimiento no posee ningun beneficio para la tarjeta del cliente");
    }
    
}
