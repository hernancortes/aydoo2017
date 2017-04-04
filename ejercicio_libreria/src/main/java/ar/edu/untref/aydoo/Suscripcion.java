package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Suscripcion extends Producto{
    private List<RevistaOPeriodico> productos;

    public Suscripcion(String descripcion, double precio){
        super(descripcion, precio);
        this.productos = new LinkedList<>();
    }

    public void AgregarRevistaOPeriodico(RevistaOPeriodico revistaOPeriodico){
        this.productos.add(revistaOPeriodico);
    }

    public double getMontoACobrarPorSuscripciones(){
        double total = 0;
        Iterator<RevistaOPeriodico> iterador = productos.iterator();
        while (iterador.hasNext()){
            RevistaOPeriodico revistaOPeriodicoIterado = iterador.next();
            total += revistaOPeriodicoIterado.getPrecioMensualConSuscripcionAnual();
        }
        return total;
    }

}