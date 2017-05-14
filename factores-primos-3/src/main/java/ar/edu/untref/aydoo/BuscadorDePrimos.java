package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class BuscadorDePrimos {
    
    private static final int RESTOCERO = 0;
    private static final int NUMEROUNO = 1;
    private static final int NUMERODOS = 2;
    private static final int NUMEROTRES = 3;
    
    public ArrayList<Integer> buscar(int numeroIngresado) {
    	int divisorCandidato = NUMERODOS;
        ArrayList<Integer> listaDeDivisoresPrimos = new ArrayList<>();
    	while (!esPrimo(numeroIngresado)) {
            if (numeroIngresado % divisorCandidato == RESTOCERO) {
    		numeroIngresado = numeroIngresado / divisorCandidato;
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
    	if (numeroIngresado == NUMEROUNO || numeroIngresado == NUMERODOS || numeroIngresado == NUMEROTRES) {
            return true;
    	} else {
            if (numeroIngresado % NUMERODOS == RESTOCERO) {
                return false;
            } else {
                double maximoAprox = Math.round(Math.sqrt(numeroIngresado));
                int maximo = (int) maximoAprox;
                for (int i = NUMEROTRES; i <= maximo; i++) {
                    if (numeroIngresado % i == RESTOCERO) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
    }
    
}
