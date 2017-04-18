package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClubDeBeneficiosTest {

    private Cliente carlos;

    @Before
    public void inicializar() {
        this.carlos = new Cliente("Carlos", "carlos@gmail.com", Tarjeta.CLASSIC);
    }

    @Test
    public void devuelveCarlosComoUnicoBeneficiadoEnElMes() {
        Beneficio beneficio = new Beneficio(Tarjeta.CLASSIC, 10);
        Operacion operacion = new Operacion(beneficio, 1000);
        
        carlos.getOperaciones().add(operacion);
        
        Assert.assertEquals(900, carlos.getAhorro(), 0.005);
    }

}
