package ar.edu.untref.aydoo;

import java.util.List;

public class Operacion {

    private final Beneficio beneficio;
    private final Sucursal sucursal;
    private final List<Producto> productos;
    private final Cliente cliente;
    private final int mes;
    private final int anio;
    
    public Operacion(Beneficio beneficio, Sucursal sucursal, List<Producto> productos, Cliente cliente, int mes, int anio) {
        this.beneficio = beneficio;
        this.sucursal = sucursal;
        this.productos = productos;
        this.cliente = cliente;
        this.mes = mes;
        this.anio = anio;
    }
    
    public double getMontoTotalConDescuentos() throws Exception {
            return this.getMontoTotalSinDescuentos() - this.getMontoAhorrado();
    }
    
    public double getMontoTotalSinDescuentos() {
        double montoTotalSinDescuentos = 0.0;
        for (Producto productos : this.getProductos()) {
            montoTotalSinDescuentos += productos.getPrecio();
        }
        return montoTotalSinDescuentos;
    }
    
    public List<Producto> getProductos() {
        return productos;
    }
    
    public double getMontoAhorrado() throws Exception {
        double montoAhorrado = this.beneficio.calcularAhorro(this.productos);
        return montoAhorrado;
    }
    
    
}
