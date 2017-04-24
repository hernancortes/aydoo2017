package ar.edu.untref.aydoo;

import java.util.Calendar;
import java.util.List;

public class Operacion {

    private final Cliente cliente;
    private final Tarjeta tarjeta;
    private final Beneficio beneficio;
    private final Sucursal sucursal;
    private final Establecimiento establecimiento;
    private final List<Producto> productos;
    private final int mes;
    private final int anio;
    private final double precioOriginal;
    private final double precioFinal;
    private final double montoAhorrado;
    
    public Operacion(Cliente cliente, Tarjeta tarjeta, Beneficio beneficio, Sucursal sucursal, List<Producto> productos,  int mes, int anio) throws Exception {
        //TO-DO: verificar que cliente tenga esa tarjeta 
        if (!cliente.getTarjeta().equals(beneficio.getTarjeta())) {
            throw new Error ("El cliente no posee la tarjeta necesaria para este beneficio");
        }
        if (!cliente.getTarjeta().equals(beneficio.getTarjeta())) {
            throw new Error ("El cliente no posee la tarjeta necesaria para este beneficio");
        }

        //TO-DO: verificar que establecimiento de la sucursal tenga ese descuento
        //TO-DO: verificar que mes y anio sean validos
        if (mes < Calendar.JANUARY || mes > Calendar.DECEMBER) {
            throw new Error ("El mes ingresado es inexistente");
        }
        if (anio != Calendar.getInstance().get(Calendar.YEAR)) {
            throw new Error ("El anio ingresado debe ser el anio actual");
        }
        this.cliente = cliente;
        this.tarjeta = tarjeta;
        this.beneficio = beneficio;
        this.sucursal = sucursal;
        this.productos = productos;
        this.mes = mes;
        this.anio = anio;
        cliente.setOperacion(this);
        sucursal.setOperacion(this);
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
    
    public int getMes(){
        return this.mes;
    }
    
    public int getAnio(){
        return this.anio;
    }
    
    public String getNombreDeEstablecimiento(){
        return this.establecimiento.getNombre();
    }
    
    public String getListaDeProductosConFormatoParaReporteMensual() {
        String listaDeProductosConFormatoParaReporteMensual = "";
        for (Producto producto : productos) {
            listaDeProductosConFormatoParaReporteMensual = listaDeProductosConFormatoParaReporteMensual + producto.getNombre() + " | ";
        }
        return listaDeProductosConFormatoParaReporteMensual;
    }
    
    //TO-DO VER QUE ESTE METODO DEVUELVA VALOR CORRECTO
    public double getMontoTotalConDescuentos() throws Exception {
            return this.getMontoTotalSinDescuentos() - this.getMontoAhorrado();
    }
    
    //TO-DO VER QUE ESTE METODO DEVUELVA VALOR CORRECTO
    public double getMontoAhorrado() throws Exception {
        double montoAhorrado = 19.0;
        //double montoAhorrado = this.beneficio.calcularAhorro(this.productos);
        return montoAhorrado;
    }
        
}
