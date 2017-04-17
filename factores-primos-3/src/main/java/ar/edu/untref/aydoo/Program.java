package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Program{
    
    public static final void main(String[] arg) throws Exception{
        Program programa = new Program();
    	try{
            programa.imprimirResultadoConFormato(Integer.parseInt(arg[0]), programa.buscarPrimos(Integer.parseInt(arg[0])), validarTipoDeFormato(arg), validarTipoDeOrdenamiento(arg));
        } catch (Exception e) {
            impresionAPantalla("El numero ingresado no es valido");
        }
    }
    
    public static String validarTipoDeFormato(String[] arg){
        String formatoParaImprimir = "--format=pretty";
        //busca si entre los parametros ingresados se pide formatQuiet, caso contrario mostrara formatPretty
        for (String arg1 : arg) {
            if ("--format=quiet".equals(arg1.toLowerCase())) {
                formatoParaImprimir = "--format=quiet";
            }
        }
        return formatoParaImprimir;
    }
    
    public static String validarTipoDeOrdenamiento(String[] arg){
        String ordenamientoElegido = "--sort=asc";
        //busca si entre los parametros ingresados se pide sortDesc, caso contrario mostrara sortAsc
        for (String arg1 : arg) {
            if ("--sort=des".equals(arg1.toLowerCase())) {
                ordenamientoElegido = "--sort=des";
            }
        }
        return ordenamientoElegido;
    }
            
    public static void impresionAPantalla(String textoAImprimir){
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
    
    public void imprimirResultadoConFormato(int numeroIngresado, ArrayList<Integer> listaDeDivisoresPrimos, String formatoDeImpresionIngresado, String tipoDeOrdenamientoElegido){
        switch (formatoDeImpresionIngresado){
            case "--format=pretty":
                imprimirConFormatoPretty(numeroIngresado, listaDeDivisoresPrimos);
                break;
            case "--format=quiet":
                imprimirConFormatoQuiet(listaDeDivisoresPrimos, tipoDeOrdenamientoElegido);
                break;
            default:
                impresionAPantalla("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
        }
    }
    
    public void imprimirConFormatoPretty(int numeroIngresado, ArrayList<Integer> listaDeDivisoresPrimos){
        impresionAPantalla("Factores primos " + numeroIngresado + ": ");
    	Iterator<Integer> iterador = listaDeDivisoresPrimos.iterator();
    	while(iterador.hasNext()) impresionAPantalla(String.valueOf(iterador.next()) + " ");
    }
    
    public void imprimirConFormatoQuiet(ArrayList<Integer> listaDeDivisoresPrimos, String tipoDeOrdenamientoElegido){
    	if ("--sort=asc".equals(tipoDeOrdenamientoElegido)){
            ListIterator iterador = listaDeDivisoresPrimos.listIterator(0);
            while(iterador.hasNext()) impresionAPantalla(String.valueOf(iterador.next())+ "\n");                           
        } else {
            ListIterator iterador = listaDeDivisoresPrimos.listIterator(listaDeDivisoresPrimos.size());
            while(iterador.hasPrevious()) impresionAPantalla(String.valueOf(iterador.previous())+ "\n");                   
        }
    }
}