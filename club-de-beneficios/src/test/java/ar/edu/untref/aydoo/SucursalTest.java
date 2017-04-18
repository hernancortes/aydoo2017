package ar.edu.untref.aydoo;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SucursalTest {

    @Ignore
    @Test
    public void siJuanCompraEnLaSucursalBLaOperacionSeRegistraEnLaSucursalYEnJuan() throws Exception {

        Cliente juan = new Cliente(Tarjeta.PREMIUM);

        Establecimiento heladeria = new Establecimiento();
        Beneficio beneficio = new Beneficio(Tarjeta.PREMIUM, 20);
        Sucursal heladeriaSucursal1 = new Sucursal();

        heladeria.agregarSucursal(heladeriaSucursal1);
        heladeria.agregarBeneficio(beneficio);
        
        heladeriaSucursal1.comprar(juan, 100);

        List<Operacion> operacionesDeJuan = juan.getOperaciones();
        List<Operacion> operacionesDeSucursal1 = heladeriaSucursal1.getOperaciones();

        Assert.assertEquals(operacionesDeJuan.size(), 1);
        Assert.assertEquals(operacionesDeSucursal1.size(), 1);
        Assert.assertEquals(operacionesDeJuan.get(0), operacionesDeSucursal1.get(0));
    }
    
    @Test(expected = Exception.class)
    public void siJuanTieneTarjetaClassicPeroLaSucursalSoloManejaTarjetaPremiumEntoncesHayUnaExcepcion() throws Exception {

        Cliente juan = new Cliente(Tarjeta.CLASSIC);
        
        Establecimiento heladeria = new Establecimiento();
        Sucursal heladeriaSucursal1 = new Sucursal();
        Beneficio beneficioTarjetaPremium = new Beneficio(Tarjeta.PREMIUM, 20);
        
        heladeria.agregarSucursal(heladeriaSucursal1);
        heladeria.agregarBeneficio(beneficioTarjetaPremium);

        heladeriaSucursal1.comprar(juan, 100);
    }

}