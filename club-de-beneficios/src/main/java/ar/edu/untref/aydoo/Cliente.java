package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private Tarjeta tarjeta;
    private List<Operacion> operaciones = new ArrayList<Operacion>();

    public Cliente(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public List<Operacion> getOperaciones() {
        return this.operaciones;
    }

    public Tarjeta obtenerTarjeta() {

        return this.tarjeta;
    }

    public double calcularAhorro() {

        double ahorro = 0;
        
        for(Operacion operacion : operaciones){
            ahorro = ahorro + operacion.obtenerImporte();
        }
        
        return ahorro;
    }
    
    public void registrarOperacion(Operacion operacion) {
        this.operaciones.add(operacion);
    }

}