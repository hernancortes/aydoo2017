package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OperacionTest {
    
    private ClubDeBeneficios nuevoClub;
    private Cliente carlos;
    private Establecimiento heladeriaA;
    private Sucursal sucursalHeladeriaA_S1;
    private BeneficioDescuento beneficioPremiumDescuento10PorCiento;
    private BeneficioDescuento beneficioClassicDescuento10PorCiento;
    private BeneficioDescuento beneficioNoAgregado;
    private Producto kiloDeHelado;
    private List<Producto> productosAComprar = new ArrayList<>();

    @Before
    public void inicializar() {
        nuevoClub = new ClubDeBeneficios ();
        carlos = new Cliente("Carlos", "carlos@gmail.com", Tarjeta.CLASSIC);
        heladeriaA = new Establecimiento("Heladeria A");
        sucursalHeladeriaA_S1 = new Sucursal("Heladeria A - Sucursal S1", heladeriaA);
        nuevoClub.agregarCliente(carlos);
        nuevoClub.agregarEstablecimiento(heladeriaA);
        nuevoClub.agregarSucursal(sucursalHeladeriaA_S1, heladeriaA);
        beneficioPremiumDescuento10PorCiento = new BeneficioDescuento(Tarjeta.PREMIUM, 10);
        beneficioNoAgregado = new BeneficioDescuento(Tarjeta.CLASSIC, 10);
        beneficioClassicDescuento10PorCiento = new BeneficioDescuento(Tarjeta.CLASSIC, 10);
        heladeriaA.agregarBeneficio(beneficioClassicDescuento10PorCiento);
        kiloDeHelado = new Producto("1 kilo de helado", 100);
        productosAComprar.add(kiloDeHelado);
    }

    @Test (expected = Error.class)
    public void intentoUnaOperacionConCarlosQueTieneTarjetaClassicPeroElBeneficioEsParaTarjetaPremium() throws Exception {
        Operacion nuevaOperacion = new Operacion (carlos, Tarjeta.CLASSIC, beneficioPremiumDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprar, 4, 2017);
    }
    
    @Test (expected = Error.class)
    public void intentoUnaOperacionIngresandoMesNumero15DebeDevolverError() throws Exception {
        Operacion nuevaOperacion = new Operacion (carlos, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprar, 15, 2017);
    }
    
    @Test (expected = Error.class)
    public void intentoUnaOperacionIngresandoAnio2020DebeDevolverError() throws Exception {
        Operacion nuevaOperacion = new Operacion (carlos, Tarjeta.CLASSIC, beneficioClassicDescuento10PorCiento, sucursalHeladeriaA_S1, productosAComprar, 4, 2020);
    }
    
    @Test (expected = Error.class)
    public void intentoComprarConUnBeneficioQueNoEstaAgregadoEnElEstablecimientoEntoncesDevuelveError() throws Exception {
        Operacion nuevaOperacion = new Operacion (carlos, Tarjeta.CLASSIC, beneficioNoAgregado, sucursalHeladeriaA_S1, productosAComprar, 4, 2017);
    }
}
