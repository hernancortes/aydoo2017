package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;

public class FormateadorPretty implements Formateador {
    
    @Override
    public String getTextoAImprimir(int numeroIngresado, ArrayList<Integer> listaDeDivisoresPrimos) {
        String textoAImprimir = "Factores primos " + numeroIngresado + ": ";
        Iterator<Integer> iterador = listaDeDivisoresPrimos.iterator();
        while (iterador.hasNext()) {
            textoAImprimir = textoAImprimir + (String.valueOf(iterador.next()) + " ");
        }
        return textoAImprimir;
    }
    
}
