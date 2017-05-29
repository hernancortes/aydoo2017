package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class ClubDeBeneficios {

    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Establecimiento> establecimientos = new ArrayList<>();
    private final List<Sucursal> sucursales = new ArrayList<>();

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
    
    public List<String> obtenerReporteDeAhorros(int mes, int anio)  {
        List<String> reporte = new ArrayList<>();
        for (Cliente cliente : this.clientes) {
            if (!cliente.getAhorro(mes, anio).equals("")) {
                reporte.add(cliente.getAhorro(mes, anio));
            }
        }
        return reporte;
    }
    
    public List<Establecimiento> obtenerEstablecimientoAFelicitar(int mes, int anio) {
        List<Establecimiento> reporte = new ArrayList<>();
        int cantidadMaximaDeBeneficiosOtorgadaEnElMes = 0;
        //con este FOR verifico cual es la cantidad maxima de beneficios otorgada en el mes solicitado
        for (Establecimiento establecimiento : this.establecimientos) {
            if (establecimiento.getCantidadMaximaDeBeneficiosOtorgadaEnElMes(mes, anio) > cantidadMaximaDeBeneficiosOtorgadaEnElMes) {
                cantidadMaximaDeBeneficiosOtorgadaEnElMes = establecimiento.getCantidadMaximaDeBeneficiosOtorgadaEnElMes(mes, anio);
            }
        }
        //con este FOR busco todos los establecimientos que otorgaron la cantidad maxima en el mes solicitado
        //la busqueda la realizo en 2 partes para poder llenar la lista con todos los establecimientos otorgaron
        //la cantidad maxima y no solo el primero que encuentre
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
        //con este FOR verifico cual es la cantidad maxima de clientes atendidos en el mes solicitado
        for (Sucursal sucursal : this.sucursales) {
            if (sucursal.getCantidadDeClientesAtendidosPorSucursal(mes, anio) > cantidadMaximaDeClientesAtendidos) {
                cantidadMaximaDeClientesAtendidos = sucursal.getCantidadDeClientesAtendidosPorSucursal(mes, anio);
            }
        }
        //con este FOR busco todas las sucursales que atendieron a la cantidad maxima de clientes en el mes solicitado
        //la busqueda la realizo en 2 partes para poder llenar la lista con todas las sucursales que atendieron a la
        //cantidad maxima y no solo la primera que encuentre
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
