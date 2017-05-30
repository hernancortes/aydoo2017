package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class ValidadorTest {
    
    @Test
    public void pasoAlValidadorListaVaciaDeArgumentosEntoncesDevuelveFalse() {
        String[] listaTest = new String[0];
        Validador validador = new Validador();
        
        boolean resultado = validador.hayArgumentosIngresadosPorUsuario(listaTest);
        boolean resultadoEsperado = false;
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void pasoAlValidadorListaDeArgumentosConUnElementoEntoncesDevuelveTrue() {
        String[] listaTest = new String[1];
        Validador validador = new Validador();
        
        boolean resultado = validador.hayArgumentosIngresadosPorUsuario(listaTest);
        boolean resultadoEsperado = true;
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void pasoAlValidadorListaDeArgumentosConElPrimerElementoQueNoEsNumeroEntoncesDevuelveFalse() {
        String[] listaTest = new String[1];
        listaTest[0] = "hola";
        Validador validador = new Validador();
        
        boolean resultado = validador.elPrimerArgumentoIngresadosPorUsuarioEsUnNumero(listaTest);
        boolean resultadoEsperado = false;
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void pasoAlValidadorListaDeArgumentosConElPrimerElementoQueEsNumeroEntoncesDevuelveTrue() {
        String[] listaTest = new String[1];
        listaTest[0] = "5";
        Validador validador = new Validador();
        
        boolean resultado = validador.elPrimerArgumentoIngresadosPorUsuarioEsUnNumero(listaTest);
        boolean resultadoEsperado = true;
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
}
