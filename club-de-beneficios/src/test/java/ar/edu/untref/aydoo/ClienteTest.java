package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

    private Cliente carlos;
    private Cliente juan;

    @Before
    public void inicializar() {
        this.carlos = new Cliente("Carlos", "carlos@gmail.com", Tarjeta.CLASSIC);
        this.juan = new Cliente("Juan", "juan@gmail.com", Tarjeta.PREMIUM);
    }
    
    @Test
    public void siElClienteNoRealizaOperacionesEntoncesNoAhorraNada() {
        Assert.assertEquals(0, carlos.getAhorro(), 0.005);
    }
    
    @Test
    public void siElClienteRealizaUnaOperacionDeMilPesosConDescuentoDe10PorcientoEntoncesAhorro100() {
        Beneficio beneficio = new Beneficio(Tarjeta.CLASSIC, 10);
        Operacion operacion = new Operacion(beneficio, 1000);
        
        carlos.getOperaciones().add(operacion);
        double resultadoEsperado = 900.0;
        
        Assert.assertEquals(resultadoEsperado, carlos.getAhorro(), 0.005);
    }
    
    @Test
    public void siElClienteRealizaUnaOperacionDeUnPesoConDescuentoDe50PorcientoEntoncesAhorroCincuentaCentavos() {      
        Beneficio beneficio = new Beneficio(Tarjeta.PREMIUM, 50);
        Operacion operacion = new Operacion(beneficio, 1);
        
        juan.getOperaciones().add(operacion);
        double resultadoEsperado = 0.5;
        
        Assert.assertEquals(resultadoEsperado, juan.getAhorro(), 0.005);
    }
}
