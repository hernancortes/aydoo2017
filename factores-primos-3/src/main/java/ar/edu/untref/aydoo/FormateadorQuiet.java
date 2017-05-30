package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.ListIterator;

public class FormateadorQuiet implements Formateador {
    
    //para impresion de salto de linea en pantalla o archivo
    public final static char CR  = (char) 0x0D;
    public final static char LF  = (char) 0x0A; 
    public final static String CRLF  = "" + CR + LF;
    
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
