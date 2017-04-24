package ar.edu.untref.aydoo;

import java.util.List;


public class BeneficioDosPorUno extends Beneficio {
    
    public BeneficioDosPorUno(Tarjeta tarjeta, TipoDeBeneficio tipoDeBeneficio) {
        super(tarjeta, tipoDeBeneficio);
    }
    
    @Override
    public double calcularAhorro(double precio) {
            double ahorro = 0.0;
            //ahorro = precio * (this.porcentajeDeDescuento / CIEN_POR_CIENTO);
            return ahorro;
    }
    
}
