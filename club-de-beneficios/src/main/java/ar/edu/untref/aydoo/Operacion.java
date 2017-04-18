package ar.edu.untref.aydoo;

public class Operacion {

    private double importe;
    private Beneficio beneficio;
    
    public Operacion(Beneficio beneficio, int importeOriginal) {
        this.beneficio = beneficio;
        this.importe = ( (100-beneficio.obtenerValorBeneficio() )*importeOriginal) / 100.0;
    }
    
    public double obtenerImporte(){
        return this.importe;
    }
    
}