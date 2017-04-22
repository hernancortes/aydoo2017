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

    public Establecimiento getEstablecimiento() {
        return this.establecimiento;
    }
       
    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }
    
    public void setCompra(Beneficio beneficio, Sucursal sucursal, List<Producto> productos, Cliente cliente, int mes, int anio) {
        Operacion nuevaOperacion = new Operacion(beneficio, sucursal, productos, cliente, mes, anio);
    }

}
