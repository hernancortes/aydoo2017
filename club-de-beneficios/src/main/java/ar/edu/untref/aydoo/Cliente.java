package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombreYApellido;
    private String email;
    private Tarjeta tarjeta;
    private List<Operacion> operaciones = new ArrayList<>();

    public Cliente(String nombreYApellido, String email, Tarjeta tarjeta) {
        this.nombreYApellido = nombreYApellido;
        this.email = email;
        this.tarjeta = tarjeta;
    }

    public String getNombreYApellido() {
        return this.nombreYApellido;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public Tarjeta getTarjeta() {
        return this.tarjeta;
    }
    
    public List<Operacion> getOperaciones() {
        return this.operaciones;
    }

    public String getAhorro(int mes, int anio) throws Exception {
        String ahorro = "";
        for (Operacion operacion : operaciones) {
            if (operacion.getMes() == mes && operacion.getAnio() == anio){
                ahorro = operacion.getEstablecimiento() + " | " + operacion.getListaDeProductosConFormatoParaReporteMensual() + "" + operacion.getMontoTotalSinDescuentos() + " | " + operacion.getMontoAhorrado() + " ||| ";
//ahorro + operacion.getMontoTotalConDescuentos();   
            }
        }
        return ahorro;
    }
    
    public void setOperacion(Operacion operacion) {
        this.operaciones.add(operacion);
    }
    
    public void comprar(){
        
    }
    /*
    //COMIENZA POLIMORFISMO DE METODO COMPRAR
    //compra de una lista de productos
    public void comprar(Beneficio beneficio, Sucursal sucursal, List<Producto> productos, int mes, int anio) {
	sucursal.setCompra(beneficio, sucursal, productos, this, mes, anio);
    }
    //compra de un solo producto con descuento
    public void comprar(Sucursal sucursal, Producto producto, int mes, int anio) {
        Beneficio beneficio;
        List<Producto> productos = new ArrayList<>();
        productos.add(producto);
        beneficio = this.getBeneficioDeEstablecimiento(sucursal, TipoDeBeneficio.DESCUENTO);
        this.comprar(beneficio, sucursal, productos, mes, anio);
    }
    //compra de un solo producto con 2x1
    public void comprar(Sucursal sucursal, Producto producto1, Producto producto2, int mes, int anio) {
        Beneficio beneficio;
        List<Producto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);
        beneficio = this.getBeneficioDeEstablecimiento(sucursal, TipoDeBeneficio.DOSPORUNO);
        this.comprar(beneficio, sucursal, productos, mes, anio);
    }

    private Beneficio getBeneficioDeEstablecimiento(Sucursal sucursal, TipoDeBeneficio tipoDeBeneficio) {
        //Beneficio beneficio = sucursal.obtenerBeneficio(this.getTarjeta(), tipo);
        Beneficio beneficio = sucursal.getEstablecimiento().tieneBeneficio(this.getTarjeta(), tipoDeBeneficio);
        return beneficio;
    }*/
        
}
