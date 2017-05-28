package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Establecimiento {

    private final String nombre;
    private final List<Sucursal> sucursales = new ArrayList<>();
    private final List<Beneficio> beneficios = new ArrayList<>();
    //private final List<Beneficio> beneficiosPremium = new ArrayList<>();
    
    public Establecimiento(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void agregarSucursal(Sucursal sucursal) {
        this.sucursales.add(sucursal);
        sucursal.setEstablecimiento(this);
    }

    public int getCantidadMaximaDeBeneficiosOtorgadaEnElMes(int mes, int anio) {
        int cantidadDeBeneficiosDeEstablecimiento = 0;
        for (Sucursal sucursal : sucursales) {
            cantidadDeBeneficiosDeEstablecimiento = cantidadDeBeneficiosDeEstablecimiento + sucursal.getCantidadDeClientesAtendidosPorSucursal(mes, anio);
        }
        return cantidadDeBeneficiosDeEstablecimiento;
    }
    
    public Establecimiento getEstablecimientosConSiguienteCantidadDeBeneficiosOtorgada(int mes, int anio, int cantDeBeneficiosRequerida) {
        int cantidadDeBeneficiosRequerida = cantDeBeneficiosRequerida;
        int cantidadDeBeneficiosDeEstablecimiento = 0;
        Establecimiento establecimiento = null;
        for (Sucursal sucursal : sucursales) {
            cantidadDeBeneficiosDeEstablecimiento = cantidadDeBeneficiosDeEstablecimiento + sucursal.getCantidadDeClientesAtendidosPorSucursal(mes, anio);
        }
        if (cantidadDeBeneficiosDeEstablecimiento == cantidadDeBeneficiosRequerida) {
            establecimiento = this;
        }
        return establecimiento;
    }
    
    public void agregarBeneficio(Beneficio beneficio) {
            this.beneficios.add(beneficio);
    }
    
    public Beneficio getMejorBeneficio(List<Producto> Productos) {
        
        return this.beneficios.get(0);
    }
    /*
    public void agregarBeneficioPremium(Beneficio beneficio) {
            this.beneficiosPremium.add(beneficio);
    }*/

    /*
    public boolean tieneBeneficio(Beneficio beneficioAVerificar) {
        boolean tiene = false;
        for (Beneficio beneficio : beneficios) {
            if (beneficio == beneficioAVerificar){
                tiene = true;
            }
        }
        return tiene;
    }*/

}
