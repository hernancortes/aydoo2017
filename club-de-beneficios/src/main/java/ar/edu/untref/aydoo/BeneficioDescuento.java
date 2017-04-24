package ar.edu.untref.aydoo;

import java.util.List;

public class BeneficioDescuento extends Beneficio {

    private int porcentajeDeDescuento;
    private static final double CIEN_POR_CIENTO = 100.0;
    private static final double PORCENTAJE_DE_DESCUENTO_MINIMO = 5;

    public BeneficioDescuento(Tarjeta tarjeta, int porcentajeDeDescuento) {
        super(tarjeta);
        if (porcentajeDeDescuento >= PORCENTAJE_DE_DESCUENTO_MINIMO) {
            this.porcentajeDeDescuento = porcentajeDeDescuento;
            this.setTipoDeBeneficio(TipoDeBeneficio.DESCUENTO);
        } else {
            throw new Error ("El porcentaje de descuento ingresado debe ser superior al minimo");
        }
    }
    
    public int getPorcentajeDeDescuento() {
        return this.porcentajeDeDescuento;
    }
    
    @Override
    public double calcularAhorro(double precio) {
            double ahorro;
            ahorro = precio * (this.porcentajeDeDescuento / CIEN_POR_CIENTO);
            return ahorro;
    }

}