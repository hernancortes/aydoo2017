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
    
    public List<Operacion> getOperaciones() {
        return this.operaciones;
    }

    public void comprar(Cliente cliente, int importeOriginal) throws Exception {
        if (this.establecimiento.tieneBeneficio(cliente.getTarjeta())) {
            //TODO: Hay que obtener el Beneficio para crear la Operacion.
            Operacion nuevaOperacion = new Operacion(null, importeOriginal);     
            this.operaciones.add(nuevaOperacion);
            cliente.setOperacion(nuevaOperacion);
        } else {
            throw new Exception("No hay beneficio para esa tarjeta en este establecimiento");
        }
    }

    public void asignarEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

}
