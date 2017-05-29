package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OperacionTest {
    
    private ClubDeBeneficios nuevoClub;
    private Cliente carlos;
    private Cliente pepe;
    private Establecimiento heladeriaA;
    private Sucursal sucursalHeladeriaA_S1;
    private BeneficioDescuento beneficioClassicDescuento10PorCiento;
    private Producto kiloDeHelado;
    private Producto cucuruchos;
    private final List<Producto> compraDe1KiloDeHelado = new ArrayList<>();
    private final List<Producto> compraDe2PaquetesDeCucuruchos = new ArrayList<>();
    private final List<Producto> compraDe1KiloDeHeladoY1PaqueteDeCucuruchos = new ArrayList<>();

    @Before
    public void inicializar() {
        nuevoClub = new ClubDeBeneficios();
        carlos = new Cliente("Carlos", "carlos@gmail.com", Tarjeta.CLASSIC);
        pepe = new Cliente("Pepe", "pepe@gmail.com", Tarjeta.PREMIUM);
        heladeriaA = new Establecimiento("Heladeria A");
        sucursalHeladeriaA_S1 = new Sucursal("Heladeria A - Sucursal S1", heladeriaA);
        nuevoClub.agregarCliente(carlos);
        nuevoClub.agregarEstablecimiento(heladeriaA);
        nuevoClub.agregarSucursal(sucursalHeladeriaA_S1, heladeriaA);
        beneficioClassicDescuento10PorCiento = new BeneficioDescuento(Tarjeta.CLASSIC, 10);
        heladeriaA.agregarBeneficio(beneficioClassicDescuento10PorCiento);
        kiloDeHelado = new Producto("1 kilo de helado", 100, "helado");
        cucuruchos = new Producto("10 cucuruchos para helado", 20, "cucuruchos");
        compraDe1KiloDeHelado.add(kiloDeHelado);
        compraDe2PaquetesDeCucuruchos.add(cucuruchos);
        compraDe2PaquetesDeCucuruchos.add(cucuruchos);
        compraDe1KiloDeHeladoY1PaqueteDeCucuruchos.add(kiloDeHelado);
        compraDe1KiloDeHeladoY1PaqueteDeCucuruchos.add(cucuruchos);
    }
    
    @Test (expected = ErrorMesIngresadoInexistente.class)
    public void intentoUnaOperacionIngresandoMesNumero15DebeDevolverError() {
        Operacion nuevaOperacion = new Operacion (carlos,sucursalHeladeriaA_S1, compraDe1KiloDeHelado, 15, 2017);
    }
    
    @Test (expected = ErrorAnioIngresadoInexistente.class)
    public void intentoUnaOperacionIngresandoAnio2020DebeDevolverError() {
        Operacion nuevaOperacion = new Operacion (carlos, sucursalHeladeriaA_S1, compraDe1KiloDeHelado, 4, 2020);
    }

    @Test (expected = ErrorEstablecimientoNoPoseeNingunBeneficioParaLaTarjetaDelCliente.class)
    public void clienteConTarjetaPremiumIntentaComprarEnHeladeria2ProductosDelMismoTipoSinBeneficiosEntoncesSeDevuelveUnError() {
        Operacion nuevaOperacion = new Operacion (pepe, sucursalHeladeriaA_S1, compraDe2PaquetesDeCucuruchos, 5, 2017);
    }
    
    @Test (expected = ErrorEstablecimientoNoPoseeNingunBeneficioParaLaTarjetaDelCliente.class)
    public void clienteConTarjetaPremiumIntentaComprarEnHeladeria2ProductosDeDistintoTipoSinBeneficiosEntoncesSeDevuelveUnError() {
        Operacion nuevaOperacion = new Operacion (pepe, sucursalHeladeriaA_S1, compraDe1KiloDeHeladoY1PaqueteDeCucuruchos, 5, 2017);
    }
    
}
