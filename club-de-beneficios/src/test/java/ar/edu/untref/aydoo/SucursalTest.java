package ar.edu.untref.aydoo;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SucursalTest {

    @Ignore
    @Test
    public void siCarlosCompraEnLaSucursalBLaOperacionSeRegistraEnLaSucursalYEnCarlos() throws Exception {
        Cliente carlos = new Cliente("Carlos", "carlos@gmail.com", Tarjeta.PREMIUM);
        Establecimiento heladeriaA = new Establecimiento("Heladeria A");
        Beneficio beneficio = new Beneficio(Tarjeta.PREMIUM, 20);
        Sucursal sucursalHeladeriaA_S1 = new Sucursal("Heladeria A - Sucursal S1", heladeriaA);
        heladeriaA.agregarSucursal(sucursalHeladeriaA_S1);
        heladeriaA.agregarBeneficio(beneficio);
        
        sucursalHeladeriaA_S1.comprar(carlos, 100);
        List<Operacion> operacionesDeCarlos = carlos.getOperaciones();
        List<Operacion> operacionesDeSucursal1 = sucursalHeladeriaA_S1.getOperaciones();

        Assert.assertEquals(1, operacionesDeCarlos.size());
        Assert.assertEquals(1, operacionesDeSucursal1.size());
        Assert.assertEquals(operacionesDeCarlos.get(0), operacionesDeSucursal1.get(0));
    }
    
    @Test(expected = Exception.class)
    public void siCarlosTieneTarjetaClassicPeroLaSucursalSoloManejaTarjetaPremiumEntoncesHayUnaExcepcion() throws Exception {
        Cliente carlos = new Cliente("Carlos", "carlos@gmail.com", Tarjeta.CLASSIC);
        Establecimiento heladeriaA = new Establecimiento("Heladeria A");
        Sucursal sucursalHeladeriaA_S1 = new Sucursal("Heladeria A - Sucursal S1", heladeriaA);
        Beneficio beneficioTarjetaPremium = new Beneficio(Tarjeta.PREMIUM, 20);
        
        heladeriaA.agregarSucursal(sucursalHeladeriaA_S1);
        heladeriaA.agregarBeneficio(beneficioTarjetaPremium);

        sucursalHeladeriaA_S1.comprar(carlos, 100);
    }

}
