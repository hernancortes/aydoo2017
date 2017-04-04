package ar.edu.untref.aydoo;

public class RevistaOPeriodico extends Producto{
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
        double precio = ((this.getPrecio() * this.frecuenciaDePublicacionAlMes) * 12);
        double descuento = ((precio * 20) / 100);
        return precio - descuento;
    }

    public double getPrecioMensualConSuscripcionAnual(){
        return (this.getPrecioDeSuscripcionAnual() / 12);
    }

}