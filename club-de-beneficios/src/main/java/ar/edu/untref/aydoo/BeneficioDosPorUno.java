package ar.edu.untref.aydoo;

import java.util.List;


public class BeneficioDosPorUno extends Beneficio {

    public BeneficioDosPorUno(Tarjeta tarjeta) {
        super(tarjeta);
    }
    
    @Override
    public double calcularAhorro(List<Producto> productos) {
        double mayorPrecioEntreDosProductos = 0.0;
        if (productos.size() != 2) {
                throw new Error ("Debe ingresar 2 productos para poder realizar este descuento");
            }
            mayorPrecioEntreDosProductos = productos.get(0).getPrecio();
            if (mayorPrecioEntreDosProductos > productos.get(1).getPrecio()) {
                mayorPrecioEntreDosProductos = productos.get(1).getPrecio();
            }
        return mayorPrecioEntreDosProductos;
    }
    
}
