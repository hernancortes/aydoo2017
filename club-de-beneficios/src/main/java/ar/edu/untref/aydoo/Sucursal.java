package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {

    private List<Operacion> operaciones = new ArrayList<Operacion>();
    private Establecimiento establecimiento;

    public List<Operacion> getOperaciones() {
        return this.operaciones;
    }

    public void comprar(Cliente cliente, int importeOriginal) throws Exception {
 
        if (this.establecimiento.tieneBeneficio(cliente.obtenerTarjeta())) {
        
            //TODO: Hay que obtener el Beneficio para crear la Operacion.
            Operacion nuevaOperacion = new Operacion(null, importeOriginal);
            
            this.operaciones.add(nuevaOperacion);
            cliente.registrarOperacion(nuevaOperacion);
        
        } else {
            throw new Exception("No hay beneficio para esa tarjeta en este establecimiento");
        }
    }

    public void asignarEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

}