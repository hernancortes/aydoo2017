package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Program{
    
    public static final int DOSARGUMENTOS = 2;  // defino MAGIC NUMBER

    public static final void main(String[] arg) throws Exception{
        Program programa = new Program();
    	try{
            String formatoParaImprimir;
            //este if verifica que si el usuario no ingreso tipo de formato, el formato no se pase como argumento nulo
            if (arg.length < DOSARGUMENTOS) formatoParaImprimir = "--format=pretty";
            else formatoParaImprimir = arg[1];
            
            programa.imprimirResultadoConFormato(Integer.parseInt(arg[0]), programa.buscarPrimos(Integer.parseInt(arg[0])), formatoParaImprimir);
        } catch (Exception e) {
            impresionDeMensaje("El numero ingresado no es valido");
        }
    }
    
    public static void impresionDeMensaje(String textoAImprimir){
        System.out.print(textoAImprimir);
    }
    
    public ArrayList<Integer> buscarPrimos(int numeroIngresado){
    	int divisorCandidato = 2;
        ArrayList<Integer> listaDeDivisoresPrimos = new ArrayList<>();
        
    	while (!esPrimo(numeroIngresado)){
            if (numeroIngresado % divisorCandidato == 0){
    		numeroIngresado = numeroIngresado/divisorCandidato;
                listaDeDivisoresPrimos.add(divisorCandidato);
            } else {
    		divisorCandidato++;
    		while (!esPrimo(divisorCandidato)) divisorCandidato++;
            }
    	}
        listaDeDivisoresPrimos.add(numeroIngresado);
        return listaDeDivisoresPrimos;
    }
    
    public boolean esPrimo(int numeroIngresado){
    	if (numeroIngresado == 1 || numeroIngresado == 2 || numeroIngresado == 3){
            return true;
    	} else {
            if (numeroIngresado % 2 == 0){
                return false;
            } else {
                double maximoAprox = Math.round(Math.sqrt(numeroIngresado));
                int maximo = (int) maximoAprox;
                for (int i=3; i<=maximo; i++){
                    if (numeroIngresado % i == 0) return false;
                    i++;
                }
                return true;
            }
        }
    }
    
    public void imprimirResultadoConFormato(int numeroIngresado, ArrayList<Integer> listaDeDivisoresPrimos, String formatoDeImpresionIngresado){
        switch (formatoDeImpresionIngresado){
            case "--format=pretty":
                imprimirConFormatoPretty(numeroIngresado, listaDeDivisoresPrimos);
                break;
            case "--format=quiet":
                imprimirConFormatoQuiet(listaDeDivisoresPrimos);
                break;
            default:
                impresionDeMensaje("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
        }
    }
    
    public void imprimirConFormatoPretty(int numeroIngresado, ArrayList<Integer> listaDeDivisoresPrimos){
        impresionDeMensaje("Factores primos " + numeroIngresado + ": ");
    	Iterator<Integer> iterador = listaDeDivisoresPrimos.iterator();
    	while(iterador.hasNext()) impresionDeMensaje(String.valueOf(iterador.next()) + " ");
    }
    
    public void imprimirConFormatoQuiet(ArrayList<Integer> listaDeDivisoresPrimos){
    	ListIterator iterador = listaDeDivisoresPrimos.listIterator(listaDeDivisoresPrimos.size());
        while(iterador.hasPrevious()) impresionDeMensaje(String.valueOf(iterador.previous())+ "\n");
    }
    
}