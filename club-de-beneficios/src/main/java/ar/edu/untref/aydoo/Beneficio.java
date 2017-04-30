package ar.edu.untref.aydoo;

import java.util.List;
import java.util.ArrayList;

public abstract class Beneficio {

    private Tarjeta tarjeta;
    
    public Beneficio(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Tarjeta getTarjeta() {
        return this.tarjeta;
    }

    public abstract double calcularAhorro(List<Producto> productos) throws Exception;

}
