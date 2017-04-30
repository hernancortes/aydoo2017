package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private final String nombreYApellido;
    private final String email;
    private final Tarjeta tarjeta;
    private final List<Operacion> operaciones = new ArrayList<>();

    public Cliente(String nombreYApellido, String email, Tarjeta tarjeta) {
        this.nombreYApellido = nombreYApellido;
        this.email = email;
        this.tarjeta = tarjeta;
    }

    
    public String getNombreYApellido() {
        return this.nombreYApellido;
    }
    
    public Tarjeta getTarjeta() {
        return this.tarjeta;
    }
    
    public String getAhorro(int mes, int anio) {
        String ahorro = "";
        for (Operacion operacion : operaciones) {
            if (operacion.getMes() == mes && operacion.getAnio() == anio) {
                if ("".equals(ahorro)) {
                    ahorro = "*** Resumen de Ahorro Mensual Para " + this.getNombreYApellido() + " *** ";
                }
                ahorro = ahorro + operacion.getNombreDeEstablecimiento() + " | " +
                        operacion.getListaDeProductosConFormatoParaReporteMensual() + "" +
                        operacion.getMontoTotalSinDescuentos() + " | " +
                        operacion.getMontoAhorrado() + " ||| "; 
            }
        }
        return ahorro;
    }
    
    public void setOperacion(Operacion operacion) {
        this.operaciones.add(operacion);
    }

}
