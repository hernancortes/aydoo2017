package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.ListIterator;

public class OrdenadorDescendente implements Ordenador {
    
    @Override
    public ArrayList<Integer> ordenar(ArrayList<Integer> listaDeDivisoresPrimos) {
        ArrayList<Integer> listaConNuevoOrden = new ArrayList<>();
        ListIterator iterador = listaDeDivisoresPrimos.listIterator(listaDeDivisoresPrimos.size());
        while (iterador.hasPrevious()) {
            listaConNuevoOrden.add((Integer) iterador.previous());
        }
        return listaConNuevoOrden;
    }
    
}
