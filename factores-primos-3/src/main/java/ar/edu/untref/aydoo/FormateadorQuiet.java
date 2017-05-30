package ar.edu.untref.aydoo;

import static ar.edu.untref.aydoo.Presentador.CRLF;
import java.util.ArrayList;
import java.util.ListIterator;

public class FormateadorQuiet implements Formateador {
    
    @Override
    public String getTextoAImprimir(int numeroIngresado, ArrayList<Integer> listaDeDivisoresPrimos) {
        String textoAImprimir = "";
        ListIterator iterador = listaDeDivisoresPrimos.listIterator(0);
        while (iterador.hasNext()) {
            textoAImprimir = textoAImprimir + (String.valueOf(iterador.next()) + CRLF);
        }
        return textoAImprimir;
    }
    
}
