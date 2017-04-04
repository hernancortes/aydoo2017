package ar.edu.untref.aydoo;

public class Suscripcion extends Producto{

    public Suscripcion(String descripcion, double precio){
        super(descripcion, precio);
    }

    public void AgregarRevistaOPeriodico(RevistaOPeriodico unaRevistaOPeriodico){
    }

    public double getMontoACobrarPorSuscripciones(){
        return 1.0;
    }

}