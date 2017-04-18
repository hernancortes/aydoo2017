package ar.edu.untref.aydoo;

public class Beneficio {

    private Tarjeta tarjeta;
    private int valor;

    public Beneficio(Tarjeta tarjeta, int valor) {
        this.tarjeta = tarjeta;
        this.valor = valor;
    }
    
    public Tarjeta obtenerTarjeta() {
        return this.tarjeta;
    }

    public int obtenerValorBeneficio() {
        return this.valor;
    }

}
