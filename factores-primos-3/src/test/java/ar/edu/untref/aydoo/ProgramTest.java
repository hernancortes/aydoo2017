package ar.edu.untref.aydoo;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;


public class ProgramTest 
{
    @Test
    public void ingresoNumeroOchoyPrueboQueNoEsPrimo(){
        Program nuevoProg = new Program();
        boolean resultado = nuevoProg.esPrimo(8);
        boolean resultadoEsperado = false;
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoNumeroDosYPrueboQueSiEsPrimo(){
        Program nuevoProg = new Program();
        boolean resultado = nuevoProg.esPrimo(2);
        boolean resultadoEsperado = true;
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoListaTestConNumeroDosYComparoConBuscarPrimosDeNumeroDos(){
        Program nuevoProg = new Program();
        ArrayList<Integer> listaTest = new ArrayList<>();
        listaTest.add(2);
        Assert.assertEquals(listaTest,nuevoProg.buscarPrimos(2));
    }
    
    @Test
    public void ingresoListaTestConNumeroDosYTresYComparoConBuscarPrimosDeNumeroDos(){
        Program nuevoProg = new Program();
        ArrayList<Integer> listaTest = new ArrayList<>();
        listaTest.add(2);
        listaTest.add(2);
        Assert.assertNotEquals(listaTest,nuevoProg.buscarPrimos(2));
    }
    
    @Test
    public void ingresoListaTestConNumerosPrimosDe360YComparoConBuscarPrimosDe360(){
        Program nuevoProg = new Program();
        ArrayList<Integer> listaTest = new ArrayList<>();
        listaTest.add(2);
        listaTest.add(2);
        listaTest.add(2);
        listaTest.add(3);
        listaTest.add(3);
        listaTest.add(5);
        Assert.assertEquals(listaTest,nuevoProg.buscarPrimos(360));
    }
    
    @Test
    public void ingresoListaTestConNumerosPrimosDe360YUnoDeEllosErroneoYComparoConBuscarPrimosDe360(){
        Program nuevoProg = new Program();
        ArrayList<Integer> listaTest = new ArrayList<>();
        listaTest.add(2);
        listaTest.add(2);
        listaTest.add(2);
        listaTest.add(4);
        listaTest.add(3);
        listaTest.add(5);
        Assert.assertNotEquals(listaTest,nuevoProg.buscarPrimos(360));
    }
    
    @Test
    public void ingresoFormatoQuietEnMayusculasYLuegoDeValidarSeraConvertidoAMinusculas(){
        Program nuevoProg = new Program();
        String[] listaArgumentosTest = new String[2];
        listaArgumentosTest[0] = "360";
        listaArgumentosTest[1] = "--format=QUIET";
        String resultadoEsperado = "--format=quiet";
        String resultado = nuevoProg.validarTipoDeFormato(listaArgumentosTest);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoFormatoPrettyEnMayusculasYMinusculasYLuegoDeValidarSeraConvertidoAMinusculas(){
        Program nuevoProg = new Program();
        String[] listaArgumentosTest = new String[2];
        listaArgumentosTest[0] = "360";
        listaArgumentosTest[1] = "--format=PreTTy";
        String resultadoEsperado = "--format=pretty";
        String resultado = nuevoProg.validarTipoDeFormato(listaArgumentosTest);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
        
    @Test
    public void noIngresoFormatoEntoncesLuegoDeValidarDevolveraFormatoPretty(){
        Program nuevoProg = new Program();
        String[] listaArgumentosTest = new String[1];
        listaArgumentosTest[0] = "360";
        String resultadoEsperado = "--format=pretty";
        String resultado = nuevoProg.validarTipoDeFormato(listaArgumentosTest);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoArgumentosYNoEspecificoElOrdenEntoncesLuegoDeValidarDevolveraOrdenAscPredeterminado(){
        Program nuevoProg = new Program();
        String[] listaArgumentosTest = new String[1];
        listaArgumentosTest[0] = "360";
        String resultadoEsperado = "--sort=asc";
        String resultado = nuevoProg.validarTipoDeOrdenamiento(listaArgumentosTest);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void ingresoArgumentosYEspecificoElOrdenDescendenteEntoncesLuegoDeValidarDevolveraOrdenDescendente(){
        Program nuevoProg = new Program();
        String[] listaArgumentosTest = new String[3];
        listaArgumentosTest[0] = "360";
        listaArgumentosTest[1] = "--format=quiet";
        listaArgumentosTest[2] = "--sort=des";
        String resultadoEsperado = "--sort=des";
        String resultado = nuevoProg.validarTipoDeOrdenamiento(listaArgumentosTest);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
}