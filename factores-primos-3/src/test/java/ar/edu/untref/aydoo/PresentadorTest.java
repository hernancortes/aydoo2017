package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class PresentadorTest {
    
    @Test
    public void pasoAlMetodoDeImpresionAPantallaDelPresentadorUnTextoDePruebaEntoncesDevuelveStringSalidaPorPantalla() {
        String textoPrueba = "Texto de Prueba";
        Presentador presentador = new Presentador();
        
        String resultado = presentador.impresionAPantalla(textoPrueba);
        String resultadoEsperado = "salida por pantalla";
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void pasoAlMetodoDeImpresionAArchivoDelPresentadorUnTextoDePruebaEntoncesDevuelveStringSalidaPorArchivo() {
        String textoPrueba = "Texto de Prueba";
        String nombreDeArchivo = "texto.txt";
        Presentador presentador = new Presentador();
        
        String resultado = presentador.impresionAArchivo(textoPrueba, nombreDeArchivo);
        String resultadoEsperado = "salida por archivo";
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void pasoAlMetodoDeImpresionAArchivoDelPresentadorUnTextoDePruebaYNombreLargoDeArchivoEntoncesDevuelveStringSalidaPorArchivo() {
        String textoPrueba = "Texto de Prueba";
        String nombreDeArchivo = "esteesuntextolargodemasde14caracteres.txt";
        Presentador presentador = new Presentador();
        
        String resultado = presentador.impresionAArchivo(textoPrueba, nombreDeArchivo);
        String resultadoEsperado = "salida por archivo";
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void pasoAlMetodoImprimirPorPantallaOArchivoDelPresentadorUnNombreDeArchivoVacioEntoncesDevuelveStringSalidaPorPantalla() {
        String textoPrueba = "Texto de Prueba";
        String nombreDeArchivo = "";
        Presentador presentador = new Presentador();
        
        String resultado = presentador.imprimirPorPantallaOArchivo(textoPrueba, nombreDeArchivo);
        String resultadoEsperado = "salida por pantalla";
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void pasoAlMetodoImprimirPorPantallaOArchivoDelPresentadorUnNombreDeArchivoValidoEntoncesDevuelveStringSalidaPorArchivo() {
        String textoPrueba = "Texto de Prueba";
        String nombreDeArchivo = "salida.txt";
        Presentador presentador = new Presentador();
        
        String resultado = presentador.imprimirPorPantallaOArchivo(textoPrueba, nombreDeArchivo);
        String resultadoEsperado = "salida por archivo";
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
}
