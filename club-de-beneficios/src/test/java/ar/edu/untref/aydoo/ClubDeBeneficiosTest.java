package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClubDeBeneficiosTest {

    private Cliente juan;

    @Before
    public void inicializar() {
        this.juan = new Cliente(Tarjeta.CLASSIC);
    }

    @Test
    public void devuelveJuanComoUnicoBeneficiadoEnElMes() {
        
        Beneficio beneficio = new Beneficio(Tarjeta.CLASSIC, 10);
        
        Operacion operacion = new Operacion(beneficio, 1000);
        
        juan.getOperaciones().add(operacion);
        
        Assert.assertEquals(900, juan.calcularAhorro(), 0.005);
    }

}
