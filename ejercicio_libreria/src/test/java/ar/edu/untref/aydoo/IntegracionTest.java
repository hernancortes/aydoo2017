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
    private CompraMensual compraDeDiciembre;

    @Before
    public void configuracionInicial(){
        nuevaLibreria = new Libreria("Nueva Libreria");
        juan = new Cliente("Juan Apellido", "20.123.123", "Direccion 123");
        maria = new Cliente("Maria Apellido", "20.456.456", "Direccion 456");
        elHobbit = new Libro("El Hobbit", 50.0);
        lapicera = new ArticuloDeLibreria("Lapicera", 5.0);
        lapicera.aplicarIva();
        elGrafico = new RevistaOPeriodico("El Grafico", 30.0, 1);
        barcelona = new RevistaOPeriodico("Barcelona", 20.0, 2);
        pagina12 = new RevistaOPeriodico("Pagina12", 12.0, 30);
        compraDeEnero = new CompraMensual("enero");
        compraDeAgosto = new CompraMensual("agosto");
        compraDeDiciembre = new CompraMensual("diciembre");
        nuevaLibreria.agregarCliente(juan);
        nuevaLibreria.agregarCliente(maria);
    }

    @Test
    public void juanCompraEnAgosto1LibroHobbitSeEsperaGastoDe50(){
        juan.agregarCompraMensual(compraDeAgosto);
        nuevaLibreria.comprar(juan, elHobbit, compraDeAgosto);
        
        double resultadoEsperado = 50.0;
        double resultado = nuevaLibreria.calcularMontoACobrar(compraDeAgosto, juan);
        
        Assert.assertEquals(resultadoEsperado, resultado, 0.1);
    }
    
    @Test
    public void juanCompraEnAgosto1LibroHobbit2Lapiceras1EjemplarDeGraficoSinSuscripcionSeEsperaGastoDe92Con1Centavo(){
        juan.agregarCompraMensual(compraDeAgosto);
        nuevaLibreria.comprar(juan, elHobbit, compraDeAgosto);
        nuevaLibreria.comprar(juan, lapicera, compraDeAgosto);
        nuevaLibreria.comprar(juan, lapicera, compraDeAgosto);
        nuevaLibreria.comprar(juan, elGrafico, compraDeAgosto);
        
        double resultadoEsperado = 92.1;
        double resultado = nuevaLibreria.calcularMontoACobrar(compraDeAgosto, juan);
        
        Assert.assertEquals(resultadoEsperado, resultado, 0.1);
    }
    
    @Test
    public void mariaCompraEnEnero1SuscripcionAnualBarcelona1EjemplarPagina12SinSuscripcionSeEsperaGastoDe44(){
        maria.agregarCompraMensual(compraDeEnero);
        suscripcionesDeMaria = new Suscripcion("Suscripciones De Maria en Enero", 0);
        suscripcionesDeMaria.AgregarRevistaOPeriodico(barcelona);
        suscripcionesDeMaria.setPrecio(suscripcionesDeMaria.getMontoACobrarPorSuscripciones());
        nuevaLibreria.comprar(maria, suscripcionesDeMaria, compraDeEnero);
        nuevaLibreria.comprar(maria, pagina12, compraDeEnero);
        
        double resultadoEsperado = 44.0;
        double resultado = nuevaLibreria.calcularMontoACobrar(compraDeEnero, maria);
        
        Assert.assertEquals(resultadoEsperado, resultado, 0.1);
    }
    
    @Test
    public void juanCompraEnDiciembre1SuscripcionAnualBarcelona1SuscripcionAnualElGrafico4LapicerasSeEsperaGastoDe80Con1Centavo(){
        juan.agregarCompraMensual(compraDeDiciembre);
        suscripcionesDeJuan = new Suscripcion("Suscripciones De Juan en Diciembre", 0);
        suscripcionesDeJuan.AgregarRevistaOPeriodico(elGrafico);
        suscripcionesDeJuan.AgregarRevistaOPeriodico(barcelona);
        suscripcionesDeJuan.setPrecio(suscripcionesDeJuan.getMontoACobrarPorSuscripciones());
        nuevaLibreria.comprar(juan, suscripcionesDeJuan, compraDeDiciembre);
        nuevaLibreria.comprar(juan, lapicera, compraDeDiciembre);
        nuevaLibreria.comprar(juan, lapicera, compraDeDiciembre);
        nuevaLibreria.comprar(juan, lapicera, compraDeDiciembre);
        nuevaLibreria.comprar(juan, lapicera, compraDeDiciembre);
        
        double resultadoEsperado = 80.1;
        double resultado = nuevaLibreria.calcularMontoACobrar(compraDeDiciembre, juan);
        
        Assert.assertEquals(resultadoEsperado, resultado, 0.1);
    }
    
}