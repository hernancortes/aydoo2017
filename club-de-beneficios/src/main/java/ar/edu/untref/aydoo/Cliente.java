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

    /*
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
*/
    
    public String getAhorro(int mes, int anio) throws Exception {
        String ahorro = "";
        for (Operacion operacion : operaciones) {
            if (operacion.getMes() == mes && operacion.getAnio() == anio){
                ahorro = operacion.getNombreDeEstablecimiento() + " | " +
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
