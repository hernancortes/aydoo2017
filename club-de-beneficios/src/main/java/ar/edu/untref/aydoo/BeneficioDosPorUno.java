package ar.edu.untref.aydoo;

import java.util.List;


public class BeneficioDosPorUno extends Beneficio {

    public BeneficioDosPorUno(Tarjeta tarjeta) {
        super(tarjeta);
    }
    
    @Override
    public double calcularAhorro(List<Producto> productos) {
        double menorPrecioEntreDosProductos = 0.0;
        if (productos.size() != 2) {
                throw new ErrorCantidadInvalidaDeProductosParaDescuentoDosPorUno();
            }
            menorPrecioEntreDosProductos = productos.get(0).getPrecio();
            if (menorPrecioEntreDosProductos > productos.get(1).getPrecio()) {
                menorPrecioEntreDosProductos = productos.get(1).getPrecio();
            }
        return menorPrecioEntreDosProductos;
    }
    
}
