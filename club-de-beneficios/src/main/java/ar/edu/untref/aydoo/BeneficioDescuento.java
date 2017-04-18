package ar.edu.untref.aydoo;

import java.util.List;

public class BeneficioDescuento extends Beneficio {

    private int porcentajeDeDescuento;
    private static final double CIEN_POR_CIENTO = 100.0;
    private static final double PORCENTAJE_DE_DESCUENTO_MINIMO = 5;

    public BeneficioDescuento(Tarjeta tarjeta, int porcentajeDeDescuento) {
        this.tarjeta = tarjeta;
        if (porcentajeDeDescuento >= PORCENTAJE_DE_DESCUENTO_MINIMO) {
            this.porcentajeDeDescuento = porcentajeDeDescuento;
            this.setTipoDeBeneficio(TipoDeBeneficio.DESCUENTO);
        } else {
            throw new Error("El porcentaje de descuento ingresado debe ser superior al minimo");
        }
    }
    
    public int getPorcentajeDeDescuento() {
        return this.porcentajeDeDescuento;
    }
    
    @Override
    public Double calcularAhorro(List<Producto> productos) {
            double ahorro;
            double precioDeProducto = productos.get(0).getPrecio();
            ahorro = precioDeProducto * (this.porcentajeDeDescuento / CIEN_POR_CIENTO);
            return ahorro;
    }

}