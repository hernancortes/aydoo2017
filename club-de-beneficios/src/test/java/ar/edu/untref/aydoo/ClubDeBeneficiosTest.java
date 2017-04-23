package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

public class ClubDeBeneficiosTest {

    private ClubDeBeneficios nuevoClub;
    private Cliente carlos;
    private Establecimiento heladeriaA;
    private Sucursal sucursalHeladeriaA_S1;
    //private Producto kiloDeHelado;
    //List<Producto> productosAComprar = new ArrayList<>();

    @Before
    public void inicializar() {
        nuevoClub = new ClubDeBeneficios ();
        carlos = new Cliente("Carlos", "carlos@gmail.com", Tarjeta.CLASSIC);
        heladeriaA = new Establecimiento("Heladeria A");
        sucursalHeladeriaA_S1 = new Sucursal("Heladeria A - Sucursal S1", heladeriaA);
        nuevoClub.agregarCliente(carlos);
        nuevoClub.agregarEstablecimiento(heladeriaA);
        nuevoClub.agregarSucursal(sucursalHeladeriaA_S1);
        
        //kiloDeHelado = new Producto("1 kilo de helado", 100);
        //productosAComprar.add(kiloDeHelado);
    }

    @Test
    public void pidoReporteDeAhorroSinComprasEntoncesObtengoReporteDeAhorroVacio(){
        List<String> resultadoEsperado = new ArrayList<>();
        List<String> resultado = nuevoClub.obtenerReporteDeAhorros();
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    
    
    /*
    @Test
    public void devuelveCarlosComoUnicoBeneficiadoEnElMes() throws Exception {
        BeneficioDescuento beneficio1 = new BeneficioDescuento(Tarjeta.CLASSIC, 10);
        Operacion operacion = new Operacion(beneficio1, sucursalHeladeriaA_S1, productosAComprar, carlos, 4, 2017);
        
        carlos.getOperaciones().add(operacion);
        double resultadoEsperado = 90.0;
        
        Assert.assertEquals(resultadoEsperado, carlos.getAhorro(), 0.005);
    }*/

}
