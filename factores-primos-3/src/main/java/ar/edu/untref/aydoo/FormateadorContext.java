package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FormateadorContext {
    
    //private final StrategyFormateador formateador;
    private Map<String, Formateador> estrategias = new HashMap<>();
    //private static Dictionary<ePassengerTitle, IPassengerTitleStrategy> _strategies = new Dictionary<ePassengerTitle, IPassengerTitleStrategy>();

    //public ContextFormateador(StrategyFormateador formateador){
    public FormateadorContext() {
        //this.formateador = formateador;
        estrategias.put("--format=pretty", new FormateadorPretty());
        estrategias.put("--format=quiet", new FormateadorQuiet());
    }

    public String ejecutarEstrategia(String tipoDeFormato, int numeroIngresado, ArrayList<Integer> listaDeDivisoresPrimos) {
        return estrategias.get(tipoDeFormato).getTextoAImprimir(numeroIngresado, listaDeDivisoresPrimos);
    }
}
