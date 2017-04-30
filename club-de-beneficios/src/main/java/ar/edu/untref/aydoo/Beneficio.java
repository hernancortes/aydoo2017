package ar.edu.untref.aydoo;

import java.util.List;

public abstract class Beneficio {

    private Tarjeta tarjeta;
    
    public Beneficio(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Tarjeta getTarjeta() {
        return this.tarjeta;
    }

    public abstract double calcularAhorro(List<Producto> productos);

}
