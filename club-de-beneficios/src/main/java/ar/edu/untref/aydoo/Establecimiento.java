package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Establecimiento {

    private String nombre;
    private List<Sucursal> sucursales = new ArrayList<>();
    private List<Beneficio> beneficios = new ArrayList<>();
    
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

    public int getCantidadMaximaDeBeneficiosOtorgadaEnElMes(int mes, int anio) throws Exception {
        int cantidadDeBeneficiosDeEstablecimiento = 0;
        for (Sucursal sucursal : sucursales) {
            cantidadDeBeneficiosDeEstablecimiento = cantidadDeBeneficiosDeEstablecimiento + sucursal.getCantidadDeClientesAtendidosPorSucursal(mes, anio);
        }
        return cantidadDeBeneficiosDeEstablecimiento;
    }
    
    public Establecimiento getEstablecimientosConSiguienteCantidadDeBeneficiosOtorgada(int mes, int anio, int cantDeBeneficiosRequerida) throws Exception {
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

    public boolean tieneBeneficio(Beneficio beneficioAVerificar) {
        //Beneficio beneficio = null;
        boolean tiene = false;
        for (Beneficio beneficio : beneficios) {
            if (beneficio == beneficioAVerificar){
                tiene = true;
            }
        }
        /*
        if (tarjeta.equals(Tarjeta.CLASSIC) && tipoDeBeneficio.equals(TipoDeBeneficio.DESCUENTO)) {
            for (int i = 0; i < this.CLASSICbeneficiosDescuento.size() && !tiene; i++) {
                beneficio = this.CLASSICbeneficiosDescuento.get(i);
                tiene = beneficio.getTarjeta().equals(tarjeta);
            }
        }*/
        return tiene;
    }

}
