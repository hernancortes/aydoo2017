package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;


public class ProgramTest 
{
    @Test
    public void probarNoEsPrimo()
    {
        Program nuevoProg = new Program();
        boolean resultado = nuevoProg.esPrimo(8);
        boolean resultadoEsperado = false;
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void probarSiEsPrimo()
    {
        Program nuevoProg = new Program();
        boolean resultado = nuevoProg.esPrimo(2);
        boolean resultadoEsperado = true;
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
}