package ar.edu.untref.aydoo;

import static ar.edu.untref.aydoo.Presentador.CRLF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Formateador {
    
    public String resultadoConFormatoPretty(int numeroIngresado, ArrayList<Integer> listaDeDivisoresPrimos) {
        String textoAImprimir = "Factores primos " + numeroIngresado + ": ";
        Iterator<Integer> iterador = listaDeDivisoresPrimos.iterator();
        while(iterador.hasNext()) {
            textoAImprimir = textoAImprimir + (String.valueOf(iterador.next()) + " ");
        }
        return textoAImprimir;
    }
    
    public String resultadoConFormatoQuiet(ArrayList<Integer> listaDeDivisoresPrimos, String tipoDeOrdenamientoElegido) {
        String textoAImprimir = "";    
        if ("--sort=asc".equals(tipoDeOrdenamientoElegido)) {
            //imprime en orden ascendente
            ListIterator iterador = listaDeDivisoresPrimos.listIterator(0);
            while(iterador.hasNext()) {
                textoAImprimir = textoAImprimir + (String.valueOf(iterador.next()) + CRLF);
            }
        } else {
            //imprime en orden descendente
            ListIterator iterador = listaDeDivisoresPrimos.listIterator(listaDeDivisoresPrimos.size());
            while(iterador.hasPrevious()) {
                textoAImprimir = textoAImprimir + (String.valueOf(iterador.previous()) + CRLF);
            }
        }
        return textoAImprimir;
    }
    
}
