package ar.edu.untref.aydoo;

import org.junit.Test;

public class ProgramaTest {
    
    @Test
    public void prueboClaseProgramaPasandoUnArrayDeArgumentosConPrimerElementoNumerico() {
        String[] listaTest = new String[1];
        listaTest[0] = "5";
        Programa.main(listaTest);
    }
    
    @Test
    public void prueboClaseProgramaPasandoUnArrayDeArgumentosConPrimerElementoTexto() {
        String[] listaTest = new String[1];
        listaTest[0] = "hola";
        Programa.main(listaTest);
    }
    
    @Test
    public void prueboClaseProgramaPasandoUnArrayDeArgumentosSinElementos() {
        String[] listaTest = new String[0];
        Programa.main(listaTest);
    }
    
}
