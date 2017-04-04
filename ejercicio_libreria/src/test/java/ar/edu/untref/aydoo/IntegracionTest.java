package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class IntegracionTest{
    private Libreria nuevaLibreria;
    private Cliente juan;
    private Cliente maria;
    private Libro elHobbit;
    private ArticuloDeLibreria lapicera;
    private RevistaOPeriodico elGrafico;
    private RevistaOPeriodico barcelona;
    private RevistaOPeriodico pagina12;
    private Suscripcion suscripcionesDeMaria;
    private Suscripcion suscripcionesDeJuan;
    private CompraMensual compraDeAgosto;
    private CompraMensual compraDeEnero;

    @Before
    public void configuracionInicial(){
        nuevaLibreria = new Libreria("Nueva Libreria");
        juan = new Cliente("Juan Apellido", "20.123.123", "Direccion 123");
        maria = new Cliente("Maria Apellido", "20.456.456", "Direccion 456");
        nuevaLibreria.agregarCliente(juan);
        nuevaLibreria.agregarCliente(maria);
        elHobbit = new Libro("El Hobbit", 50.0);
        lapicera = new ArticuloDeLibreria("Lapicera", 5.0);
        lapicera.aplicarIva();
        elGrafico = new RevistaOPeriodico("El Grafico", 30.0, 1);
        barcelona = new RevistaOPeriodico("Barcelona", 20.0, 2);
        pagina12 = new RevistaOPeriodico("Pagina12", 12.0, 30);
        suscripcionesDeMaria = new Suscripcion("Suscripciones De Maria", 0);
        suscripcionesDeMaria.AgregarRevistaOPeriodico(barcelona);
        suscripcionesDeMaria.setPrecio(suscripcionesDeMaria.getMontoACobrarPorSuscripciones());
        suscripcionesDeJuan = new Suscripcion("Suscripciones De Juan", 0);
        suscripcionesDeJuan.AgregarRevistaOPeriodico(elGrafico);
        suscripcionesDeJuan.AgregarRevistaOPeriodico(barcelona);
        suscripcionesDeJuan.setPrecio(suscripcionesDeJuan.getMontoACobrarPorSuscripciones());
        compraDeAgosto = new CompraMensual();
        compraDeEnero = new CompraMensual();
        juan.agregarCompraMensual(compraDeAgosto);
        maria.agregarCompraMensual(compraDeEnero);
    }

}