package ar.edu.untref.aydoo;

import java.util.List;
import java.util.ArrayList;

public abstract class Beneficio {

    private TipoDeBeneficio tipoDeBeneficio;
    private Tarjeta tarjeta;
    private List<Establecimiento> establecimientos = new ArrayList<>();
    
    public Beneficio(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    public TipoDeBeneficio getTipoDeBeneficio() {
        return tipoDeBeneficio;
    }

    public void setTipoDeBeneficio(TipoDeBeneficio tipoDeBeneficio) {
        this.tipoDeBeneficio = tipoDeBeneficio;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    public Tarjeta getTarjeta() {
        return this.tarjeta;
    }

    public abstract Double calcularAhorro(List<Producto> productos) throws Exception;

}
