package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class ClubDeBeneficios {

    private List<Cliente> clientes = new ArrayList<>();
    private List<Establecimiento> establecimientos = new ArrayList<>();
    private List<Sucursal> sucursales = new ArrayList<>();
    
    public void agregarEstablecimiento(Establecimiento establecimiento) {
        this.establecimientos.add(establecimiento);
    }

    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    public List<String> obtenerReporteDeAhorros() throws Exception {
        List<String> reporte = new ArrayList<>();
        for (int i = 0; i < this.clientes.size(); i++) {
            if (clientes.get(i).getAhorro() > 0.0) {
                reporte.add("" + clientes.get(i).getAhorro());
            }
            //beneficio = this.CLASSICbeneficiosDescuento.get(i);
            //tiene = beneficio.getTarjeta().equals(tarjeta);
        }
        return reporte;
    }
    
    public Establecimiento obtenerEstablecimientoAFelicitar() {
        return this.establecimientos.get(0);
    }
    
    public Sucursal obtenerSucursalQueMasClientesAtendio() {
        return this.sucursales.get(0);
    }
}
