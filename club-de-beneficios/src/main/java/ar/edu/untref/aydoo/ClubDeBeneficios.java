package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class ClubDeBeneficios {

    private List<Cliente> clientes = new ArrayList<>();
    private List<Establecimiento> establecimientos = new ArrayList<>();
    private List<Sucursal> sucursales = new ArrayList<>();

    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    public void agregarEstablecimiento(Establecimiento establecimiento) {
        this.establecimientos.add(establecimiento);
    }
    
    public void agregarSucursal(Sucursal sucursal) {
        this.sucursales.add(sucursal);
    }
    
    //TO-DO: poder pasar como parametro el mes y el año buscado para el reporte
    public List<String> obtenerReporteDeAhorros() {
        List<String> reporte = new ArrayList<>();
        /*
        for (int i = 0; i < this.clientes.size(); i++) {
            if (clientes.get(i).getAhorro() > 0.0) {
                reporte.add("" + clientes.get(i).getAhorro());
            }
            //beneficio = this.CLASSICbeneficiosDescuento.get(i);
            //tiene = beneficio.getTarjeta().equals(tarjeta);
        }*/
        return reporte;
    }
    
    //TO-DO: poder pasar como parametro el mes y el año buscado para el reporte
    public List<Establecimiento> obtenerEstablecimientoAFelicitar() {
        List<Establecimiento> reporte = new ArrayList<>();
        return reporte;
    }
    
    //TO-DO: poder pasar como parametro el mes y el año buscado para el reporte
    public List<Sucursal> obtenerSucursalQueMasClientesAtendio() {
        List<Sucursal> reporte = new ArrayList<>();
        return reporte;
    }
}
