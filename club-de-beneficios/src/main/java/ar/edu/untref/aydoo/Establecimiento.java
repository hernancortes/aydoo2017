package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Establecimiento {

    private final String nombre;
    private final List<Sucursal> sucursales = new ArrayList<>();
    private final List<Beneficio> beneficios = new ArrayList<>();
    
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
    
    //Si a la busqueda de mejorBeneficio se le pasa lista de productos con 2 productos con mismo tipo de producto intentara
    //buscar el beneficio 2x1 dentro de los beneficios del Establecimiento. Si la cantidad de productos es distinta de 2
    //buscara el beneficio correspondiente a la tarjeta del cliente
    public Beneficio getMejorBeneficio(List<Producto> productosAComprar, Tarjeta tarjetaDelCliente) {
        Beneficio mejorBeneficio = null;
        boolean seUtilizaBeneficio2x1 = false;
        //si los productos son 2 y son del mismo tipo entrara en este if
        if (productosAComprar.size() == 2 && productosAComprar.get(0).getTipoDeProducto().equals(productosAComprar.get(1).getTipoDeProducto())) {
            for (Beneficio beneficio : beneficios) {
                //si el beneficio es 2x1 y corresponde a la tarjeta del cliente se tomara como el mejorBeneficio
                if (beneficio.getClass().equals(BeneficioDosPorUno.class) && beneficio.getTarjeta().equals(tarjetaDelCliente)){
                    seUtilizaBeneficio2x1 = true;
                    mejorBeneficio = beneficio;
                }
            }
        }
        //si los productos a comprar no son 2 del mismo tipo o el cliente no tiene tarjeta para 2x1 o no hay 2x1 en el establecimiento se buscan otros beneficios
        if (!seUtilizaBeneficio2x1) {
            for (Beneficio beneficio : beneficios) {
                if (beneficio.getTarjeta().equals(tarjetaDelCliente)){
                    mejorBeneficio = beneficio;
                }
            }
        }
        //si no hay ningun beneficio para el cliente se arroja un error
        if (mejorBeneficio == null) {
            throw new ErrorEstablecimientoNoPoseeNingunBeneficioParaLaTarjetaDelCliente();
        }
        return mejorBeneficio;
    }
    
}
