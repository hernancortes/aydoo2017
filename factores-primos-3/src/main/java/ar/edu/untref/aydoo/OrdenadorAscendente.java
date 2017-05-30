package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class OrdenadorAscendente implements Ordenador {
    
    @Override
    public ArrayList<Integer> ordenar(ArrayList<Integer> listaDeDivisoresPrimos) {
        //como el array de factores primos se crea por defecto en orden ascendente se devuelve el mismo array
        return listaDeDivisoresPrimos;
    }
    
}
