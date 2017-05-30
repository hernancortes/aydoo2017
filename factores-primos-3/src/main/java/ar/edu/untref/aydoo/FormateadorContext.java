package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FormateadorContext {
    
    private Map<String, Formateador> estrategias = new HashMap<>();

    public FormateadorContext() {
        estrategias.put("--format=pretty", new FormateadorPretty());
        estrategias.put("--format=quiet", new FormateadorQuiet());
    }

    public String ejecutarEstrategia(String tipoDeFormato, int numeroIngresado, ArrayList<Integer> listaDeDivisoresPrimos) {
        return estrategias.get(tipoDeFormato).getTextoAImprimir(numeroIngresado, listaDeDivisoresPrimos);
    }

}
