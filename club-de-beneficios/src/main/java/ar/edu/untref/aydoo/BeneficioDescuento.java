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
        } else {
            throw new ErrorPorcentajeDeDescuentoInvalido();
        }
    }
    
    @Override
    public double calcularAhorro(List<Producto> productos) {
        double montoTotalSinDescuentos = 0.0;
        for (Producto producto : productos) {
            montoTotalSinDescuentos += producto.getPrecio();
        }
        double ahorro;
        ahorro = montoTotalSinDescuentos * (this.porcentajeDeDescuento / CIEN_POR_CIENTO);
        return ahorro;
    }

}
