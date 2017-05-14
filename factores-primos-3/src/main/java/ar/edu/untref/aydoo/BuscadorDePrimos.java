package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class BuscadorDePrimos {
    
    public ArrayList<Integer> buscar(int numeroIngresado) {
    	int divisorCandidato = 2;
        ArrayList<Integer> listaDeDivisoresPrimos = new ArrayList<>();
    	while (!esPrimo(numeroIngresado)) {
            if (numeroIngresado % divisorCandidato == 0) {
    		numeroIngresado = numeroIngresado/divisorCandidato;
                listaDeDivisoresPrimos.add(divisorCandidato);
            } else {
    		divisorCandidato++;
    		while (!esPrimo(divisorCandidato)) {
                    divisorCandidato++;
                }
            }
    	}
        listaDeDivisoresPrimos.add(numeroIngresado);
        return listaDeDivisoresPrimos;
    }
    
    public boolean esPrimo(int numeroIngresado) {
    	if (numeroIngresado == 1 || numeroIngresado == 2 || numeroIngresado == 3) {
            return true;
    	} else {
            if (numeroIngresado % 2 == 0) {
                return false;
            } else {
                double maximoAprox = Math.round(Math.sqrt(numeroIngresado));
                int maximo = (int) maximoAprox;
                for (int i=3; i<=maximo; i++) {
                    if (numeroIngresado % i == 0) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
    }
}
