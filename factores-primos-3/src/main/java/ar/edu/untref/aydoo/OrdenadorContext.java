package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrdenadorContext {
    
    private Map<String, Ordenador> estrategias = new HashMap<>();

    public OrdenadorContext() {
        estrategias.put("--sort=asc", new OrdenadorAscendente());
        estrategias.put("--sort=des", new OrdenadorDescendente());
    }

    public ArrayList<Integer> ejecutarEstrategia(String tipoDeOrdenamientoElegido, ArrayList<Integer> listaDeDivisoresPrimos) {
        return estrategias.get(tipoDeOrdenamientoElegido).ordenar(listaDeDivisoresPrimos);
    }

}