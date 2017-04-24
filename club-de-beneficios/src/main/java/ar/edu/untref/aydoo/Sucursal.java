package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {

    private String nombre;
    private Establecimiento establecimiento;
    private List<Operacion> operaciones = new ArrayList<>();

    public Sucursal(String nombre, Establecimiento establecimiento) {
        this.nombre = nombre;
        this.establecimiento = establecimiento;
    }
    
    public Establecimiento getEstablecimiento() {
        return this.establecimiento;
    }
       
    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }
    
    public void setOperacion(Operacion operacion) {
        this.operaciones.add(operacion);
    }
    
    public int getCantidadDeClientesAtendidosPorSucursal(int mes, int anio) {
        int cantidadDeClientesAtendidos = 0;
        for (Operacion operacion : this.operaciones) {
            if (operacion.getMes() == mes && operacion.getAnio() == anio){
                cantidadDeClientesAtendidos++;
            }
        }
        return cantidadDeClientesAtendidos;
    }

}
