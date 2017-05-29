package ar.edu.untref.aydoo;

import java.util.Calendar;
import java.util.List;

public class Operacion {

    private final Cliente cliente;
    private final Tarjeta tarjeta;
    private final Sucursal sucursal;
    private final Establecimiento establecimiento;
    private final List<Producto> productos;
    private final int mes;
    private final int anio;
    private final double precioOriginal;
    private final double precioFinal;
    private final double montoAhorrado;
    
    public Operacion(Cliente cliente, Sucursal sucursal, List<Producto> productos,  int mes, int anio) {
        if (mes < Calendar.JANUARY || mes > Calendar.DECEMBER) {
            throw new ErrorMesIngresadoInexistente();
        }
        if (anio != Calendar.getInstance().get(Calendar.YEAR)) {
            throw new ErrorAnioIngresadoInexistente();
        }
        if (productos.size() < 1) {
            throw new ErrorCantidadMinimaInvalidaDeProductosAComprar();
        }
        this.cliente = cliente;
        this.tarjeta = cliente.getTarjeta();
        this.sucursal = sucursal;
        this.productos = productos;
        this.mes = mes;
        this.anio = anio;
        this.cliente.setOperacion(this);
        this.sucursal.setOperacion(this);
        this.establecimiento = sucursal.getEstablecimiento();
        this.precioOriginal = this.getMontoTotalSinDescuentos();
        this.precioFinal = this.getMontoTotalConDescuentos();
        this.montoAhorrado = this.getMontoAhorrado();
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
    
    public int getMes() {
        return this.mes;
    }
    
    public int getAnio() {
        return this.anio;
    }
    
    public String getNombreDeEstablecimiento() {
        return this.establecimiento.getNombre();
    }
    
    public String getListaDeProductosConFormatoParaReporteMensual() {
        String listaDeProductosConFormatoParaReporteMensual = "";
        for (Producto producto : productos) {
            listaDeProductosConFormatoParaReporteMensual = listaDeProductosConFormatoParaReporteMensual + producto.getNombre() + " | ";
        }
        return listaDeProductosConFormatoParaReporteMensual;
    }
    
    public double getMontoTotalConDescuentos() {
            return this.getMontoTotalSinDescuentos() - this.getMontoAhorrado();
    }
    
    public double getMontoAhorrado() {
        double montoAhorrado = this.establecimiento.getMejorBeneficio(this.productos, this.tarjeta).calcularAhorro(this.productos);
        return montoAhorrado;
    }
        
}
