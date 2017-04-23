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
    
    public List<String> obtenerReporteDeAhorros(int mes, int anio) throws Exception {
        List<String> reporte = new ArrayList<>();
        for (Cliente cliente : this.clientes) {
            if (cliente.getAhorro(mes, anio) != "") {
                reporte.add(cliente.getAhorro(mes, anio));
            }
            //beneficio = this.CLASSICbeneficiosDescuento.get(i);
            //tiene = beneficio.getTarjeta().equals(tarjeta);
        }
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
