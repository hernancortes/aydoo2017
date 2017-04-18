package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

    private Cliente juan;

    @Before
    public void inicializar() {
        this.juan = new Cliente(Tarjeta.CLASSIC);
    }
    
    @Test
    public void siElClienteNoRealizaOperacionesEntoncesNoAhorraNada() {
        Assert.assertEquals(0, juan.calcularAhorro(), 0.005);
    }
    
    @Test
    public void siElClienteRealizaUnaOperacionDeMilPesosConDescuentoDe10PorcientoEntoncesAhorro100() {
        Beneficio beneficio = new Beneficio(Tarjeta.CLASSIC, 10);
        Operacion operacion = new Operacion(beneficio, 1000);
        
        juan.getOperaciones().add(operacion);
        
        Assert.assertEquals(900, juan.calcularAhorro(), 0.005);
    }
    
    @Test
    public void siElClienteRealizaUnaOperacionDeUnPesoConDescuentoDe50PorcientoEntoncesAhorro1() {      
        Beneficio beneficio = new Beneficio(Tarjeta.CLASSIC, 50);
        Operacion operacion = new Operacion(beneficio, 1);
        
        juan.getOperaciones().add(operacion);
        
        Assert.assertEquals(0.5, juan.calcularAhorro(), 0.005);
    }
}
