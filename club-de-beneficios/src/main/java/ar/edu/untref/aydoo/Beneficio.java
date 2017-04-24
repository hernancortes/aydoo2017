package ar.edu.untref.aydoo;

import java.util.List;
import java.util.ArrayList;

public abstract class Beneficio {

    private TipoDeBeneficio tipoDeBeneficio;
    private Tarjeta tarjeta;
    
    public Beneficio(Tarjeta tarjeta, TipoDeBeneficio tipoDeBeneficio) {
        this.tarjeta = tarjeta;
        this.tipoDeBeneficio = tipoDeBeneficio;
    }
    
    public TipoDeBeneficio getTipoDeBeneficio() {
        return tipoDeBeneficio;
    }

    public void setTipoDeBeneficio(TipoDeBeneficio tipoDeBeneficio) {
        this.tipoDeBeneficio = tipoDeBeneficio;
    }

    public Tarjeta getTarjeta() {
        return this.tarjeta;
    }

    public abstract double calcularAhorro(double precio) throws Exception;

}
