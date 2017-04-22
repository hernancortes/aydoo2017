package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Establecimiento {

    private String nombre;
    private List<Sucursal> sucursales = new ArrayList<>();
    private List<Beneficio> CLASSICbeneficiosDescuento = new ArrayList<>();
    private List<Beneficio> CLASSICbeneficiosDosPorUno = new ArrayList<>();
    private List<Beneficio> PREMIUMbeneficiosDescuento = new ArrayList<>();
    private List<Beneficio> PREMIUMbeneficiosDosPorUno = new ArrayList<>();

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

    public void agregarBeneficio(Tarjeta tarjeta, Beneficio beneficio) {
        if (tarjeta.equals(Tarjeta.CLASSIC) && beneficio.getTipoDeBeneficio().equals(TipoDeBeneficio.DESCUENTO)) {
            this.CLASSICbeneficiosDescuento.add(beneficio);
        }
        if (tarjeta.equals(Tarjeta.PREMIUM) && beneficio.getTipoDeBeneficio().equals(TipoDeBeneficio.DESCUENTO)) {
            this.PREMIUMbeneficiosDescuento.add(beneficio);
        }
       if (tarjeta.equals(Tarjeta.CLASSIC) && beneficio.getTipoDeBeneficio().equals(TipoDeBeneficio.DOSPORUNO)) {
            this.CLASSICbeneficiosDosPorUno.add(beneficio);
        }
       if (tarjeta.equals(Tarjeta.PREMIUM) && beneficio.getTipoDeBeneficio().equals(TipoDeBeneficio.DOSPORUNO)) {
            this.PREMIUMbeneficiosDosPorUno.add(beneficio);
        }
    }

    public Beneficio tieneBeneficio(Tarjeta tarjeta, TipoDeBeneficio tipoDeBeneficio) {
        Beneficio beneficio = null;
        boolean tiene = false;
        if (tarjeta.equals(Tarjeta.CLASSIC) && tipoDeBeneficio.equals(TipoDeBeneficio.DESCUENTO)) {
            for (int i = 0; i < this.CLASSICbeneficiosDescuento.size() && !tiene; i++) {
                beneficio = this.CLASSICbeneficiosDescuento.get(i);
                tiene = beneficio.getTarjeta().equals(tarjeta);
            }
        }
        if (tarjeta.equals(Tarjeta.PREMIUM) && tipoDeBeneficio.equals(TipoDeBeneficio.DESCUENTO)) {
            for (int i = 0; i < this.PREMIUMbeneficiosDescuento.size() && !tiene; i++) {
                beneficio = this.PREMIUMbeneficiosDescuento.get(i);
                tiene = beneficio.getTarjeta().equals(tarjeta);
            }
        }
       if (tarjeta.equals(Tarjeta.CLASSIC) && tipoDeBeneficio.equals(TipoDeBeneficio.DOSPORUNO)) {
            for (int i = 0; i < this.CLASSICbeneficiosDosPorUno.size() && !tiene; i++) {
                beneficio = this.CLASSICbeneficiosDosPorUno.get(i);
                tiene = beneficio.getTarjeta().equals(tarjeta);
            }
        }
       if (tarjeta.equals(Tarjeta.PREMIUM) && tipoDeBeneficio.equals(TipoDeBeneficio.DOSPORUNO)) {
            for (int i = 0; i < this.PREMIUMbeneficiosDosPorUno.size() && !tiene; i++) {
                beneficio = this.PREMIUMbeneficiosDosPorUno.get(i);
                tiene = beneficio.getTarjeta().equals(tarjeta);
            }
        }
        return beneficio;
    }

}
