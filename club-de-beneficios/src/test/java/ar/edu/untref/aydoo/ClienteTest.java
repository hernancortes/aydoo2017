package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

    private Cliente carlos;
    private Cliente juan;
    private Establecimiento heladeriaA;
    private Sucursal sucursalHeladeriaA_S1;
    private Producto kiloDeHelado;
    List<Producto> productosAComprar = new ArrayList<>();

    @Before
    public void inicializar() {
        carlos = new Cliente("Carlos", "carlos@gmail.com", Tarjeta.CLASSIC);
        juan = new Cliente("Juan", "juan@gmail.com", Tarjeta.PREMIUM);
        heladeriaA = new Establecimiento("Heladeria A");
        sucursalHeladeriaA_S1 = new Sucursal("Heladeria A - Sucursal S1", heladeriaA);
        kiloDeHelado = new Producto("1 kilo de helado", 100);
        productosAComprar.add(kiloDeHelado);
    }
    
    @Test
    public void siElClienteNoRealizaOperacionesEntoncesNoAhorraNada() throws Exception {
        Assert.assertEquals(0, carlos.getAhorro(), 0.005);
    }
    
    @Test
    public void siElClienteRealizaUnaCompraDe100ConDescuentoDe10PorcientoEntoncesAhorra10() throws Exception {
        BeneficioDescuento beneficio1 = new BeneficioDescuento(Tarjeta.CLASSIC, 10);
        Operacion operacion = new Operacion(beneficio1, sucursalHeladeriaA_S1, productosAComprar, carlos, 4, 2017);
        
        carlos.getOperaciones().add(operacion);
        double resultadoEsperado = 90.0;
        
        Assert.assertEquals(resultadoEsperado, carlos.getAhorro(), 0.005);
    }
    
    @Test
    public void siElClienteRealizaUnaCompraDe100ConDescuentoDe50PorcientoEntoncesAhorra50() throws Exception {      
        BeneficioDescuento beneficio2 = new BeneficioDescuento(Tarjeta.PREMIUM, 50);
        Operacion operacion = new Operacion(beneficio2, sucursalHeladeriaA_S1, productosAComprar, carlos, 4, 2017);
        
        juan.getOperaciones().add(operacion);
        double resultadoEsperado = 50.0;
        
        Assert.assertEquals(resultadoEsperado, juan.getAhorro(), 0.005);
    }
    
}
