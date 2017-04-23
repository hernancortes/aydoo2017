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
    
    public void agregarSucursal(Sucursal sucursal, Establecimiento establecimiento) {
        this.sucursales.add(sucursal);
        establecimiento.agregarSucursal(sucursal);
    }
    
    public List<String> obtenerReporteDeAhorros(int mes, int anio) throws Exception {
        List<String> reporte = new ArrayList<>();
        for (Cliente cliente : this.clientes) {
            if (cliente.getAhorro(mes, anio) != "") {
                reporte.add(cliente.getAhorro(mes, anio));
            }
        }
        return reporte;
    }
    
    public List<Establecimiento> obtenerEstablecimientoAFelicitar(int mes, int anio) throws Exception {
        List<Establecimiento> reporte = new ArrayList<>();
        int cantidadMaximaDeBeneficiosOtorgadaEnElMes = 0;
        for (Establecimiento establecimiento : this.establecimientos) {
            if (establecimiento.getCantidadMaximaDeBeneficiosOtorgadaEnElMes(mes, anio) > cantidadMaximaDeBeneficiosOtorgadaEnElMes) {
                cantidadMaximaDeBeneficiosOtorgadaEnElMes = establecimiento.getCantidadMaximaDeBeneficiosOtorgadaEnElMes(mes, anio);
            }
        }
        if (cantidadMaximaDeBeneficiosOtorgadaEnElMes != 0) {
            for (Establecimiento establecimiento : this.establecimientos) {
                if (establecimiento.getEstablecimientosConSiguienteCantidadDeBeneficiosOtorgada(mes, anio, cantidadMaximaDeBeneficiosOtorgadaEnElMes) != null) {
                    reporte.add(establecimiento);
                }
            }
        }
        return reporte;
    }
    
    public List<Sucursal> obtenerSucursalQueMasClientesAtendio(int mes, int anio) {
        List<Sucursal> reporte = new ArrayList<>();
        int cantidadMaximaDeClientesAtendidos = 0;
        for (Sucursal sucursal : this.sucursales) {
            if (sucursal.getCantidadDeClientesAtendidosPorSucursal(mes, anio) > cantidadMaximaDeClientesAtendidos) {
                cantidadMaximaDeClientesAtendidos = sucursal.getCantidadDeClientesAtendidosPorSucursal(mes, anio);
            }
        }
        if (cantidadMaximaDeClientesAtendidos != 0) {
            for (Sucursal sucursal : this.sucursales) {
            if (sucursal.getCantidadDeClientesAtendidosPorSucursal(mes, anio) == cantidadMaximaDeClientesAtendidos) {
                reporte.add(sucursal);
            }
        }
        }
        return reporte;
    }
}
