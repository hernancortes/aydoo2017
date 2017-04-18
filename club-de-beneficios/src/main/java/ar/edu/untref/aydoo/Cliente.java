package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombreYApellido;
    private String email;
    private Tarjeta tarjeta;
    private List<Operacion> operaciones = new ArrayList<>();

    public Cliente(String nombreYApellido, String email, Tarjeta tarjeta) {
        this.nombreYApellido = nombreYApellido;
        this.email = email;
        this.tarjeta = tarjeta;
    }

    public String getNombreYApellido() {
        return this.nombreYApellido;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public Tarjeta getTarjeta() {
        return this.tarjeta;
    }
    
    public List<Operacion> getOperaciones() {
        return this.operaciones;
    }

    public double getAhorro() throws Exception {
        double ahorro = 0;
        for (Operacion operacion : operaciones) {
            ahorro = ahorro + operacion.getMontoTotalConDescuentos();
        }
        return ahorro;
    }
    
    public void setOperacion(Operacion operacion) {
        this.operaciones.add(operacion);
    }

}
