package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestIntegracion {
    
    private ClubDeBeneficios nuevoClub;
    private Cliente carlos;
    private Cliente juan;
    private Cliente mateo;
    private Cliente nuevoCliente1;
    private Cliente nuevoCliente2;
    private Cliente nuevoCliente3;
    private Cliente nuevoCliente4;
    private Cliente nuevoCliente5;
    private Cliente nuevoCliente6;
    private Cliente nuevoCliente7;
    private Cliente nuevoCliente8;
    private Establecimiento heladeriaA;
    private Establecimiento restoranB;
    private Establecimiento libreriaElAltillo;
    private Sucursal sucursalHeladeriaA_S1;
    private Sucursal sucursalHeladeriaA_S2;
    private Sucursal sucursalRestoranB_S3;
    private Sucursal sucursalLibreriaElAltillo_S4;
    private Producto kiloDeHelado;
    private Producto menuEjecutivo;
    private Producto libroMartinFierro;
    private Producto libroElCantarDelCid;
    private Producto libroLaSantaBiblia;
    private int mes;
    private int anio;
    private BeneficioDescuento beneficioClassicDescuento10PorCiento;
    private BeneficioDescuento beneficioClassicDescuento20PorCiento;
    private BeneficioDescuento beneficioPremiumDescuento20PorCiento;
    private List<Producto> productosAComprarEnHeladeria = new ArrayList<>();
    private List<Producto> productosAComprarEnRestoran = new ArrayList<>();
    private List<Producto> productosAComprarEnLibreria = new ArrayList<>();
    private BeneficioDosPorUno beneficioDosPorUnoClassic;

    @Before
    public void inicializar() {
        nuevoClub = new ClubDeBeneficios();
        carlos = new Cliente("Carlos", "carlos@gmail.com", Tarjeta.CLASSIC);
        juan = new Cliente("Juan", "juan@gmail.com", Tarjeta.PREMIUM);
        mateo = new Cliente("Mateo", "mateo@gmail.com", Tarjeta.CLASSIC);        
        nuevoCliente1 = new Cliente("nuevoCliente1", "nuevoCliente1@gmail.com", Tarjeta.CLASSIC);
        nuevoCliente2 = new Cliente("nuevoCliente2", "nuevoCliente2@gmail.com", Tarjeta.CLASSIC);
        nuevoCliente3 = new Cliente("nuevoCliente3", "nuevoCliente3@gmail.com", Tarjeta.CLASSIC);
        nuevoCliente4 = new Cliente("nuevoCliente4", "nuevoCliente4@gmail.com", Tarjeta.CLASSIC);
        nuevoCliente5 = new Cliente("nuevoCliente5", "nuevoCliente1@gmail.com", Tarjeta.PREMIUM);
        nuevoCliente6 = new Cliente("nuevoCliente6", "nuevoCliente1@gmail.com", Tarjeta.PREMIUM);
        nuevoCliente7 = new Cliente("nuevoCliente7", "nuevoCliente1@gmail.com", Tarjeta.PREMIUM);
        nuevoCliente8 = new Cliente("nuevoCliente8", "nuevoCliente1@gmail.com", Tarjeta.PREMIUM);
        heladeriaA = new Establecimiento("Heladeria A");
        restoranB = new Establecimiento("Restoran B");
        libreriaElAltillo = new Establecimiento("Libreria El Altillo");
        sucursalHeladeriaA_S1 = new Sucursal("Heladeria A - Sucursal S1", heladeriaA);
        sucursalHeladeriaA_S2 = new Sucursal("Heladeria A - Sucursal S2", heladeriaA);
        sucursalRestoranB_S3 = new Sucursal("Restoran B - Sucursal S3", restoranB);
        sucursalLibreriaElAltillo_S4 = new Sucursal("Libreria El Altillo - Sucursal S4", libreriaElAltillo);
        kiloDeHelado = new Producto("1 kilo de helado", 100);
        menuEjecutivo = new Producto("1 menu ejecutivo", 200);
        libroMartinFierro = new Producto("1 libro Martin Fierro", 100);
        libroElCantarDelCid = new Producto("1 libro El Cantar del Cid", 80);
        libroLaSantaBiblia = new Producto("1 libro La Santa Biblia", 2);
        mes = 4;
        anio = 2017;
        nuevoClub.agregarCliente(carlos);
        nuevoClub.agregarCliente(juan);
        nuevoClub.agregarCliente(mateo);
        nuevoClub.agregarCliente(nuevoCliente1);
        nuevoClub.agregarCliente(nuevoCliente2);
        nuevoClub.agregarCliente(nuevoCliente3);
        nuevoClub.agregarCliente(nuevoCliente4);
        nuevoClub.agregarCliente(nuevoCliente5);
        nuevoClub.agregarCliente(nuevoCliente6);
        nuevoClub.agregarCliente(nuevoCliente7);
        nuevoClub.agregarCliente(nuevoCliente8);
        nuevoClub.agregarEstablecimiento(this.restoranB);
        nuevoClub.agregarEstablecimiento(this.heladeriaA);
        nuevoClub.agregarEstablecimiento(this.libreriaElAltillo);
        nuevoClub.agregarSucursal(sucursalHeladeriaA_S1, heladeriaA);
        nuevoClub.agregarSucursal(sucursalHeladeriaA_S2, heladeriaA);
        nuevoClub.agregarSucursal(sucursalRestoranB_S3, restoranB);
        nuevoClub.agregarSucursal(sucursalLibreriaElAltillo_S4, libreriaElAltillo);
        beneficioClassicDescuento10PorCiento = new BeneficioDescuento(Tarjeta.CLASSIC, 10);
        beneficioClassicDescuento20PorCiento = new BeneficioDescuento(Tarjeta.CLASSIC, 20);
        beneficioPremiumDescuento20PorCiento = new BeneficioDescuento(Tarjeta.PREMIUM, 20);
        heladeriaA.agregarBeneficio(beneficioClassicDescuento10PorCiento);
        heladeriaA.agregarBeneficio(beneficioPremiumDescuento20PorCiento);
        restoranB.agregarBeneficio(beneficioClassicDescuento10PorCiento);
        //beneficioDosPorUnoClassic = new BeneficioDosPorUno(Tarjeta.CLASSIC, TipoDeBeneficio.DOSPORUNO);
        beneficioDosPorUnoClassic = new BeneficioDosPorUno(Tarjeta.CLASSIC);
        libreriaElAltillo.agregarBeneficio(beneficioDosPorUnoClassic);
    }
    
    @Test
    public void realizoSieteComprasEnHeladeriaAYSeisEnRestoranBEntoncesEstablecimientoAFelicitarDebeSerHeladeriaA() throws Exception {
        productosAComprarEnHeladeria.add(kiloDeHelado);
        productosAComprarEnRestoran.add(menuEjecutivo);
        Operacion nuevaOperacionClassicEnHeladeria1 = new Operacion (carlos, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnHeladeria2 = new Operacion (nuevoCliente1, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnHeladeria3 = new Operacion (nuevoCliente2, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnHeladeria4 = new Operacion (nuevoCliente3, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionPremiumEnHeladeria1 = new Operacion (juan, Tarjeta.PREMIUM, beneficioPremiumDescuento20PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionPremiumEnHeladeria2 = new Operacion (nuevoCliente5, Tarjeta.PREMIUM, beneficioPremiumDescuento20PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionPremiumEnHeladeria3 = new Operacion (nuevoCliente6, Tarjeta.PREMIUM, beneficioPremiumDescuento20PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran1 = new Operacion (carlos, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran2 = new Operacion (nuevoCliente1, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran3 = new Operacion (nuevoCliente1, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran4 = new Operacion (nuevoCliente2, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran5 = new Operacion (nuevoCliente3, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran6 = new Operacion (nuevoCliente3, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        List<Establecimiento> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(heladeriaA);
        List<Establecimiento> resultado = nuevoClub.obtenerEstablecimientoAFelicitar(1, 2017);
        
        Assert.assertEquals(resultadoEsperado, resultado);    
    }
    
    @Test
    public void realizoSieteComprasEnHeladeriaASucursal1YSeisEnRestoranBSucursal3EntoncesSucursalQueMasClientesAtendioEsSucursal1() throws Exception {
        productosAComprarEnHeladeria.add(kiloDeHelado);
        productosAComprarEnRestoran.add(menuEjecutivo);
        Operacion nuevaOperacionClassicEnHeladeria1 = new Operacion (carlos, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnHeladeria2 = new Operacion (nuevoCliente1, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnHeladeria3 = new Operacion (nuevoCliente2, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnHeladeria4 = new Operacion (nuevoCliente3, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionPremiumEnHeladeria1 = new Operacion (juan, Tarjeta.PREMIUM, beneficioPremiumDescuento20PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionPremiumEnHeladeria2 = new Operacion (nuevoCliente5, Tarjeta.PREMIUM, beneficioPremiumDescuento20PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionPremiumEnHeladeria3 = new Operacion (nuevoCliente6, Tarjeta.PREMIUM, beneficioPremiumDescuento20PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran1 = new Operacion (carlos, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran2 = new Operacion (nuevoCliente1, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran3 = new Operacion (nuevoCliente1, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran4 = new Operacion (nuevoCliente2, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran5 = new Operacion (nuevoCliente3, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran6 = new Operacion (nuevoCliente3, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        List<Sucursal> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(sucursalHeladeriaA_S1);
        List<Sucursal> resultado = nuevoClub.obtenerSucursalQueMasClientesAtendio(1, 2017);
        
        Assert.assertEquals(resultadoEsperado, resultado);    
    }
    
    @Test
    public void carlosRealizaCompraEnHeladeriaYRestoranEntoncesDebeRecibirReporteDeAhorrosDeHeladeriaYRestoran() throws Exception {
        productosAComprarEnHeladeria.add(kiloDeHelado);
        productosAComprarEnRestoran.add(menuEjecutivo);
        Operacion nuevaOperacionClassicEnHeladeria1 = new Operacion (carlos, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnHeladeria2 = new Operacion (nuevoCliente1, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnHeladeria3 = new Operacion (nuevoCliente2, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnHeladeria4 = new Operacion (nuevoCliente3, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionPremiumEnHeladeria1 = new Operacion (juan, Tarjeta.PREMIUM, beneficioPremiumDescuento20PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionPremiumEnHeladeria2 = new Operacion (nuevoCliente5, Tarjeta.PREMIUM, beneficioPremiumDescuento20PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionPremiumEnHeladeria3 = new Operacion (nuevoCliente6, Tarjeta.PREMIUM, beneficioPremiumDescuento20PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran1 = new Operacion (carlos, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran2 = new Operacion (nuevoCliente1, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran3 = new Operacion (nuevoCliente1, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran4 = new Operacion (nuevoCliente2, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran5 = new Operacion (nuevoCliente3, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran6 = new Operacion (nuevoCliente3, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        String resultadoEsperado = "*** Resumen de Ahorro Mensual Para Carlos *** Heladeria A | 1 kilo de helado | 100.0 | 10.0 ||| Restoran B | 1 menu ejecutivo | 200.0 | 20.0 ||| ";
        String resultado = nuevoClub.obtenerReporteDeAhorros(1, 2017).get(0);
        
        Assert.assertEquals(resultadoEsperado, resultado);    
    }
    
    @Test
    public void juanRealizaCompraEnHeladeriaYEntoncesDebeRecibirReporteDeAhorrosDeHeladeria() throws Exception {
        productosAComprarEnHeladeria.add(kiloDeHelado);
        productosAComprarEnRestoran.add(menuEjecutivo);
        Operacion nuevaOperacionClassicEnHeladeria1 = new Operacion (carlos, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnHeladeria2 = new Operacion (nuevoCliente1, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnHeladeria3 = new Operacion (nuevoCliente2, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnHeladeria4 = new Operacion (nuevoCliente3, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionPremiumEnHeladeria1 = new Operacion (juan, Tarjeta.PREMIUM, beneficioPremiumDescuento20PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionPremiumEnHeladeria2 = new Operacion (nuevoCliente5, Tarjeta.PREMIUM, beneficioPremiumDescuento20PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionPremiumEnHeladeria3 = new Operacion (nuevoCliente6, Tarjeta.PREMIUM, beneficioPremiumDescuento20PorCiento, sucursalHeladeriaA_S1, productosAComprarEnHeladeria, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran1 = new Operacion (carlos, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran2 = new Operacion (nuevoCliente1, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran3 = new Operacion (nuevoCliente1, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran4 = new Operacion (nuevoCliente2, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran5 = new Operacion (nuevoCliente3, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        Operacion nuevaOperacionClassicEnRestoran6 = new Operacion (nuevoCliente3, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalRestoranB_S3, productosAComprarEnRestoran, 1, 2017);
        String resultadoEsperado = "*** Resumen de Ahorro Mensual Para Juan *** Heladeria A | 1 kilo de helado | 100.0 | 20.0 ||| ";
        String resultado = nuevoClub.obtenerReporteDeAhorros(1, 2017).get(1);
        
        Assert.assertEquals(resultadoEsperado, resultado);    
    }
        
    @Test (expected = Error.class)
    public void intentoCrearUnBeneficioConUnDescuentoMenorAlMinimoEstipuladoDevuelveError() throws Exception {
        BeneficioDescuento beneficioDeDosPorciento = new BeneficioDescuento(Tarjeta.CLASSIC, 2);
    }
    
    @Test
    public void mateoCompraDosPorUnoEnLibreriaEntoncesObtieneReporteMensualConEsaCompra() throws Exception {
        productosAComprarEnLibreria.add(libroMartinFierro);
        productosAComprarEnLibreria.add(libroElCantarDelCid);
        Operacion nuevaOperacionDosPorUno = new Operacion (mateo, Tarjeta.CLASSIC, beneficioDosPorUnoClassic, sucursalLibreriaElAltillo_S4, productosAComprarEnLibreria, 3, 2017);
        List<String> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add("*** Resumen de Ahorro Mensual Para Mateo *** Libreria El Altillo | 1 libro Martin Fierro | 1 libro El Cantar del Cid | 180.0 | 80.0 ||| ");
        List<String> resultado = nuevoClub.obtenerReporteDeAhorros(3, 2017);
        
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test (expected = Error.class)
    public void intentoComprarConDescuentoDeDosPorUnoIngresandoUnSoloProductoEntoncesObtengoError() throws Exception {
        productosAComprarEnLibreria.add(libroMartinFierro);
        Operacion nuevaOperacionDosPorUno = new Operacion (mateo, Tarjeta.CLASSIC, beneficioDosPorUnoClassic, sucursalLibreriaElAltillo_S4, productosAComprarEnLibreria, 3, 2017);
    }
    
    @Test (expected = Error.class)
    public void intentoComprarConDescuentoDeDosPorUnoIngresandoTresProductosEntoncesObtengoError() throws Exception {
        productosAComprarEnLibreria.add(libroMartinFierro);
        productosAComprarEnLibreria.add(libroElCantarDelCid);
        productosAComprarEnLibreria.add(libroLaSantaBiblia);
        Operacion nuevaOperacionDosPorUno = new Operacion (mateo, Tarjeta.CLASSIC, beneficioDosPorUnoClassic, sucursalLibreriaElAltillo_S4, productosAComprarEnLibreria, 3, 2017);
    }
    
    @Test (expected = Error.class)
    public void intentoComprarConDescuentoDeDosPorUnoSinIngresarNingunProductoEntoncesObtengoError() throws Exception {
        Operacion nuevaOperacionDosPorUno = new Operacion (mateo, Tarjeta.CLASSIC, beneficioDosPorUnoClassic, sucursalLibreriaElAltillo_S4, productosAComprarEnLibreria, 3, 2017);
    }
        
}
