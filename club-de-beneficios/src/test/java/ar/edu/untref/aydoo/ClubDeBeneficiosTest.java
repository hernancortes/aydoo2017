package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClubDeBeneficiosTest {

    private ClubDeBeneficios nuevoClub;
    private Cliente carlos;
    private Establecimiento heladeriaA;
    private Sucursal sucursalHeladeriaA_S1;
    private Beneficio beneficioClassicDescuento10PorCiento;
    private Producto kiloDeHelado;
    List<Producto> productosAComprar = new ArrayList<>();

    @Before
    public void inicializar() {
        nuevoClub = new ClubDeBeneficios ();
        carlos = new Cliente("Carlos", "carlos@gmail.com", Tarjeta.CLASSIC);
        heladeriaA = new Establecimiento("Heladeria A");
        sucursalHeladeriaA_S1 = new Sucursal("Heladeria A - Sucursal S1", heladeriaA);
        nuevoClub.agregarCliente(carlos);
        nuevoClub.agregarEstablecimiento(heladeriaA);
        nuevoClub.agregarSucursal(sucursalHeladeriaA_S1, heladeriaA);
        BeneficioDescuento beneficioClassicDescuento10PorCiento = new BeneficioDescuento(Tarjeta.CLASSIC, 10);
        kiloDeHelado = new Producto("1 kilo de helado", 100);
        productosAComprar.add(kiloDeHelado);
    }

    @Test
    public void pidoReporteDeAhorroSinComprasEntoncesObtengoReporteDeAhorroVacio() throws Exception {
        List<String> resultadoEsperado = new ArrayList<>();
        List<String> resultado = nuevoClub.obtenerReporteDeAhorros(4, 2017);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void pidoEstablecimientoAFelicitarSinOperacionesEntoncesObtengoListaVacia() throws Exception {
        List<Establecimiento> resultadoEsperado = new ArrayList<>();
        List<Establecimiento> resultado = nuevoClub.obtenerEstablecimientoAFelicitar(4, 2017);
        Assert.assertEquals(resultadoEsperado,resultado);
    }
    
    @Test
    public void pidoSucursalQueMasVendioSinOperacionesEntoncesObtengoListaVacia() {
        List<Sucursal> resultadoEsperado = new ArrayList<>();
        List<Sucursal> resultado = nuevoClub.obtenerSucursalQueMasClientesAtendio(4, 2017);
        Assert.assertEquals(resultadoEsperado,resultado);
    }
    
    @Test
    public void hagoUnaOperacionConDescuentoYPidoReporteDeClientesQueObtuvieronAhorroEntoncesObtengoUnSoloElementoEnLaListaDeReporte() throws Exception {               
        Operacion nuevaOperacion = new Operacion (carlos, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprar, 4, 2017);
        List<String> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add("*** Resumen de Ahorro Mensual Para Carlos *** Heladeria A | 1 kilo de helado | 100.0 | 19.0 ||| ");
        List<String> resultado = nuevoClub.obtenerReporteDeAhorros(4, 2017);
        
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void pidoReporteDeClientesQueObtuvieronAhorroDeUnADondeNoHayClientesConAhorroEntoncesObtengoListaDeReporteVacia() throws Exception {               
        Operacion nuevaOperacion = new Operacion (carlos, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprar, 4, 2017);
        List<String> resultadoEsperado = new ArrayList<>();
        List<String> resultado = nuevoClub.obtenerReporteDeAhorros(4, 2010);
        
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void hagoUnaCompraEnHeladeriaYPidoSucursalQueMasVendioEntoncesReporteDevuelveListaConSucursalDeLaHeladeria() throws Exception {               
        Operacion nuevaOperacion = new Operacion (carlos, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprar, 4, 2017);
        List<Sucursal> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(sucursalHeladeriaA_S1);
        List<Sucursal> resultado = nuevoClub.obtenerSucursalQueMasClientesAtendio(4, 2017);
        
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void hagoUnaCompraEnHeladeriaYPidoSucursalQueMasVendioEnUnAnioDondeNoHayComprasEntoncesReporteDevuelveListaVacia() throws Exception {               
        Operacion nuevaOperacion = new Operacion (carlos, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprar, 4, 2017);
        List<Sucursal> resultadoEsperado = new ArrayList<>();
        List<Sucursal> resultado = nuevoClub.obtenerSucursalQueMasClientesAtendio(4, 2010);
        
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void hagoUnaCompraEnHeladeriaYPidoEstablecimientoAFelicitarEntoncesReporteDevuelveHeladeria() throws Exception {               
        Operacion nuevaOperacion = new Operacion (carlos, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprar, 4, 2017);
        List<Establecimiento> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(heladeriaA);
        List<Establecimiento> resultado = nuevoClub.obtenerEstablecimientoAFelicitar(4, 2017);
        
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
}
