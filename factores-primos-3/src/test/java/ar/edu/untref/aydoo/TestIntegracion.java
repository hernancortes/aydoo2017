package ar.edu.untref.aydoo;

import static ar.edu.untref.aydoo.Presentador.CRLF;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;


public class TestIntegracion {
    
    @Test
    public void ingresoNumeroOchoyPrueboQueNoEsPrimo() {
        BuscadorDePrimos buscaPrimos = new BuscadorDePrimos();
        boolean resultado = buscaPrimos.esPrimo(8);
        boolean resultadoEsperado = false;
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoNumeroDosYPrueboQueSiEsPrimo() {
        BuscadorDePrimos buscaPrimos = new BuscadorDePrimos();
        boolean resultado = buscaPrimos.esPrimo(2);
        boolean resultadoEsperado = true;
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoListaTestConNumeroDosYComparoConBuscarPrimosDeNumeroDos() {
        BuscadorDePrimos buscaPrimos = new BuscadorDePrimos();
        ArrayList<Integer> listaTest = new ArrayList<>();
        listaTest.add(2);
        Assert.assertEquals(listaTest, buscaPrimos.buscar(2));
    }
    
    @Test
    public void ingresoListaTestConNumeroDosYTresYComparoConBuscarPrimosDeNumeroDos() {
        BuscadorDePrimos buscaPrimos = new BuscadorDePrimos();
        ArrayList<Integer> listaTest = new ArrayList<>();
        listaTest.add(2);
        listaTest.add(2);
        Assert.assertNotEquals(listaTest, buscaPrimos.buscar(2));
    }
    
    @Test
    public void ingresoListaTestConNumerosPrimosDe360YComparoConBuscarPrimosDe360() {
        BuscadorDePrimos buscaPrimos = new BuscadorDePrimos();
        ArrayList<Integer> listaTest = new ArrayList<>();
        listaTest.add(2);
        listaTest.add(2);
        listaTest.add(2);
        listaTest.add(3);
        listaTest.add(3);
        listaTest.add(5);
        Assert.assertEquals(listaTest, buscaPrimos.buscar(360));
    }
    
    @Test
    public void ingresoListaTestConNumerosPrimosDe360YUnoDeEllosErroneoYComparoConBuscarPrimosDe360() {
        BuscadorDePrimos buscaPrimos = new BuscadorDePrimos();
        ArrayList<Integer> listaTest = new ArrayList<>();
        listaTest.add(2);
        listaTest.add(2);
        listaTest.add(2);
        listaTest.add(4);
        listaTest.add(3);
        listaTest.add(5);
        Assert.assertNotEquals(listaTest, buscaPrimos.buscar(360));
    }
    
    @Test
    public void ingresoFormatoQuietEnMayusculasYLuegoDeValidarSeraConvertidoAMinusculas() {
        Validador validador = new Validador();
        String[] listaArgumentosTest = new String[2];
        listaArgumentosTest[0] = "360";
        listaArgumentosTest[1] = "--format=QUIET";
        String resultadoEsperado = "--format=quiet";
        String resultado = validador.validarTipoDeFormato(listaArgumentosTest);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoFormatoPrettyEnMayusculasYMinusculasYLuegoDeValidarSeraConvertidoAMinusculas() {
        Validador validador = new Validador();
        String[] listaArgumentosTest = new String[2];
        listaArgumentosTest[0] = "360";
        listaArgumentosTest[1] = "--format=PreTTy";
        String resultadoEsperado = "--format=pretty";
        String resultado = validador.validarTipoDeFormato(listaArgumentosTest);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
        
    @Test
    public void noIngresoFormatoEntoncesLuegoDeValidarDevolveraFormatoPretty() {
        Validador validador = new Validador();
        String[] listaArgumentosTest = new String[1];
        listaArgumentosTest[0] = "360";
        String resultadoEsperado = "--format=pretty";
        String resultado = validador.validarTipoDeFormato(listaArgumentosTest);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoArgumentosYNoEspecificoElOrdenEntoncesLuegoDeValidarDevolveraOrdenAscPredeterminado() {
        Validador validador = new Validador();
        String[] listaArgumentosTest = new String[1];
        listaArgumentosTest[0] = "360";
        String resultadoEsperado = "--sort=asc";
        String resultado = validador.validarTipoDeOrdenamiento(listaArgumentosTest);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoArgumentosYEspecificoElOrdenDescendenteEntoncesLuegoDeValidarDevolveraOrdenDescendente() {
        Validador validador = new Validador();
        String[] listaArgumentosTest = new String[3];
        listaArgumentosTest[0] = "360";
        listaArgumentosTest[1] = "--format=quiet";
        listaArgumentosTest[2] = "--sort=des";
        String resultadoEsperado = "--sort=des";
        String resultado = validador.validarTipoDeOrdenamiento(listaArgumentosTest);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoArgumentosYEspecificoSalidaAArchivoConMayusculasYMinusculasEntoncesLuegoDeValidarDevolveraElArgumentoDeSalidaIngresadoEnMinusculas() {
        Validador validador = new Validador();
        String[] listaArgumentosTest = new String[3];
        listaArgumentosTest[0] = "360";
        listaArgumentosTest[1] = "--format=quiet";
        listaArgumentosTest[2] = "--outPUT-fiLe=1.txt";
        String resultadoEsperado = "--output-file=1.txt";
        String resultado = validador.validarTipoDeSalidaPorPantallaOArchivo(listaArgumentosTest);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoArgumentosYEspecificoSalidaAArchivoSinNombreEntoncesLuegoDeValidarDevolveraElArgumentoDeSalidaSinNombre() {
        Validador validador = new Validador();
        String[] listaArgumentosTest = new String[3];
        listaArgumentosTest[0] = "360";
        listaArgumentosTest[1] = "--format=quiet";
        listaArgumentosTest[2] = "--output-file=";
        String resultadoEsperado = "--output-file=";
        String resultado = validador.validarTipoDeSalidaPorPantallaOArchivo(listaArgumentosTest);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoArgumentosYEspecificoOutputSinElSignoIgualEntoncesLuegoDeValidarDevolveraSalidaAArchivoVacio() {
        Validador validador = new Validador();
        String[] listaArgumentosTest = new String[3];
        listaArgumentosTest[0] = "360";
        listaArgumentosTest[1] = "--format=quiet";
        listaArgumentosTest[2] = "--output-file";
        String resultadoEsperado = "";
        String resultado = validador.validarTipoDeSalidaPorPantallaOArchivo(listaArgumentosTest);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoArgumentosYNoEspecificoSalidaAArchivoEntoncesLuegoDeValidarDevolveraStringSalidaAArchivoVacio() {
        Validador validador = new Validador();
        String[] listaArgumentosTest = new String[3];
        listaArgumentosTest[0] = "360";
        listaArgumentosTest[1] = "--format=quiet";
        listaArgumentosTest[2] = "--sort=des";
        String resultadoEsperado = "";
        String resultado = validador.validarTipoDeSalidaPorPantallaOArchivo(listaArgumentosTest);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    /*
    @Test
    public void ingresoNumeroYResultadoConFormatoPrettyDebeDevolverStringCorrecto() {
        BuscadorDePrimos buscaPrimos = new BuscadorDePrimos();
        Formateador formateador = new Formateador();
        String[] listaArgumentosTest = new String[2];
        listaArgumentosTest[0] = "360";
        listaArgumentosTest[1] = "--format=pretty";
        String resultadoEsperado = "Factores primos 360: 2 2 2 3 3 5 ";
        String resultado = formateador.resultadoConFormatoPretty(Integer.parseInt(listaArgumentosTest[0]), buscaPrimos.buscar(Integer.parseInt(listaArgumentosTest[0])));
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoNumeroYNoIngresoTipoDeOrdenamientoResultadoConFormatoQuietDebeDevolverStringCorrectoYOrdenamientoAscPredeterminado() {
        BuscadorDePrimos buscaPrimos = new BuscadorDePrimos();
        Validador validador = new Validador();
        Formateador formateador = new Formateador();
        String[] listaArgumentosTest = new String[2];
        listaArgumentosTest[0] = "360";
        listaArgumentosTest[1] = "--format=quiet";
        String resultadoEsperado = "2"+ CRLF + "2" + CRLF + "2" + CRLF + "3" + CRLF + "3" + CRLF + "5" + CRLF;
        String resultado = formateador.resultadoConFormatoQuiet(buscaPrimos.buscar(Integer.parseInt(listaArgumentosTest[0])), validador.validarTipoDeOrdenamiento(listaArgumentosTest));
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoNumeroYEIngresoTipoDeOrdenamientoDescResultadoConFormatoQuietDebeDevolverStringCorrectoYOrdenamientoDescendente() {
        BuscadorDePrimos buscaPrimos = new BuscadorDePrimos();
        Validador validador = new Validador();
        Formateador formateador = new Formateador();
        String[] listaArgumentosTest = new String[2];
        listaArgumentosTest[0] = "360";
        listaArgumentosTest[1] = "--format=qUiet";
        listaArgumentosTest[1] = "--sort=Des";
        String resultadoEsperado = "5"+ CRLF + "3" + CRLF + "3" + CRLF + "2" + CRLF + "2" + CRLF + "2" + CRLF;
        String resultado = formateador.resultadoConFormatoQuiet(buscaPrimos.buscar(Integer.parseInt(listaArgumentosTest[0])), validador.validarTipoDeOrdenamiento(listaArgumentosTest));
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    */
}
