package ar.edu.untref.aydoo;

//Tipo de Objeto: Value Object
public class RevistaOPeriodico extends Producto{
    public static final double PORCENTAJEDEDESCUENTOPORSUSCRIPCIONANUAL = 0.2;
    public static final double CANTIDADDEMESESDELANIO = 12;
    private int frecuenciaDePublicacionAlMes;

    public RevistaOPeriodico(String nombre, double precio, int frecuenciaDePublicacionAlMes){
        super(nombre, precio);
        this.frecuenciaDePublicacionAlMes = frecuenciaDePublicacionAlMes;
    }

    public int getFrecuenciaDePublicacionAlMes(){
        return this.frecuenciaDePublicacionAlMes;
    }

    public void setFrecuenciaDePublicacionAlMes(int nuevaFrecuencia){
        this.frecuenciaDePublicacionAlMes = nuevaFrecuencia;
    }

    public double getPrecioDeSuscripcionMensual(){
        return (this.getPrecio() * this.frecuenciaDePublicacionAlMes);
    }

    public double getPrecioDeSuscripcionAnual(){
        double precio = ((this.getPrecio() * this.frecuenciaDePublicacionAlMes) * CANTIDADDEMESESDELANIO);
        double descuento = precio * PORCENTAJEDEDESCUENTOPORSUSCRIPCIONANUAL;
        return precio - descuento;
    }

    public double getPrecioMensualConSuscripcionAnual(){
        return (this.getPrecioDeSuscripcionAnual() / CANTIDADDEMESESDELANIO);
    }

}