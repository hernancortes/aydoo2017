package ar.edu.untref.aydoo;

import static ar.edu.untref.aydoo.Presentador.CRLF;
import java.util.ArrayList;
import java.util.ListIterator;

public class FormateadorQuiet implements Formateador {
    
    @Override
    public String getTextoAImprimir(int numeroIngresado, ArrayList<Integer> listaDeDivisoresPrimos) {
        String textoAImprimir = "";/*
        if ("--sort=asc".equals(tipoDeOrdenamientoElegido)) {
            //imprime en orden ascendente
            ListIterator iterador = listaDeDivisoresPrimos.listIterator(0);
            while (iterador.hasNext()) {
                textoAImprimir = textoAImprimir + (String.valueOf(iterador.next()) + CRLF);
            }
        } else {
            //imprime en orden descendente
            ListIterator iterador = listaDeDivisoresPrimos.listIterator(listaDeDivisoresPrimos.size());
            while (iterador.hasPrevious()) {
                textoAImprimir = textoAImprimir + (String.valueOf(iterador.previous()) + CRLF);
            }
        }*/
        return textoAImprimir;
    }
    
}
