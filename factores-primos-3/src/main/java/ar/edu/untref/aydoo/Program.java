package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.io.*;

public class Program{
    
    //para impresion de salto de linea en pantalla o archivo
    public final static char CR  = (char) 0x0D;
    public final static char LF  = (char) 0x0A; 
    public final static String CRLF  = "" + CR + LF;

    public static final void main(String[] arg) {
        Program programa = new Program();
        BuscadorDePrimos buscaPrimos = new BuscadorDePrimos();
    	try{
            programa.imprimirResultadoConFormato(Integer.parseInt(arg[0]), buscaPrimos.buscar(Integer.parseInt(arg[0])), validarTipoDeFormato(arg), validarTipoDeOrdenamiento(arg), validarTipoDeSalidaPorPantallaOArchivo(arg));
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
    
    public static String validarTipoDeSalidaPorPantallaOArchivo(String[] arg){
        String salidaPorArchivo = "";
        //busca si entre los parametros ingresados se pide outputFile, caso contrario devolvera string vacio
        for (String arg1 : arg) {
            //solo verifico los argumentos que tengan mas de 13 caracteres que son los que pueden contener como inicio "--output-file="
            if ((arg1.length() > 13) && ("--output-file=".equals(arg1.toLowerCase().substring(0, 14)))) {
                    salidaPorArchivo = arg1.toLowerCase();
            }
        }
        return salidaPorArchivo;
    }
            
    public static void impresionAPantalla(String textoAImprimir){
        System.out.print(textoAImprimir);
    }
    
    public void imprimirResultadoConFormato(int numeroIngresado, ArrayList<Integer> listaDeDivisoresPrimos, String formatoDeImpresionIngresado, String tipoDeOrdenamientoElegido, String salidaPorArchivo){
        switch (formatoDeImpresionIngresado){
            case "--format=pretty":
                imprimirPorPantallaOArchivo(resultadoConFormatoPretty(numeroIngresado, listaDeDivisoresPrimos), salidaPorArchivo);
                break;
            case "--format=quiet":
                imprimirPorPantallaOArchivo(resultadoConFormatoQuiet(listaDeDivisoresPrimos, tipoDeOrdenamientoElegido), salidaPorArchivo);
                break;
            default:
                impresionAPantalla("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
        }
    }
    
    public String resultadoConFormatoPretty(int numeroIngresado, ArrayList<Integer> listaDeDivisoresPrimos){
        String textoAImprimir = "Factores primos " + numeroIngresado + ": ";
        Iterator<Integer> iterador = listaDeDivisoresPrimos.iterator();
        while(iterador.hasNext()){
            textoAImprimir = textoAImprimir + (String.valueOf(iterador.next()) + " ");
        }
        return textoAImprimir;
    }
    
    public String resultadoConFormatoQuiet(ArrayList<Integer> listaDeDivisoresPrimos, String tipoDeOrdenamientoElegido){
        String textoAImprimir = "";    
        if ("--sort=asc".equals(tipoDeOrdenamientoElegido)){
            //imprime en orden ascendente
            ListIterator iterador = listaDeDivisoresPrimos.listIterator(0);
            while(iterador.hasNext()) textoAImprimir = textoAImprimir + (String.valueOf(iterador.next()) + CRLF);
        } else {
            //imprime en orden descendente
            ListIterator iterador = listaDeDivisoresPrimos.listIterator(listaDeDivisoresPrimos.size());
            while(iterador.hasPrevious()) textoAImprimir = textoAImprimir + (String.valueOf(iterador.previous()) + CRLF);
        }
        return textoAImprimir;
    }
    
    public void imprimirPorPantallaOArchivo(String textoAImprimir, String salidaPorArchivo){
        if ("".equals(salidaPorArchivo)){
            impresionAPantalla(textoAImprimir);
        } else {
            impresionAArchivo(textoAImprimir, salidaPorArchivo);
        }
    }
    
    public void impresionAArchivo(String textoAImprimir, String salidaPorArchivo){
        FileWriter archivo = null;
        PrintWriter pw = null;
        String nombreDeArchivo;
        //si solo fue ingresado argumento "--output-file=" el archivo se llamara "salida.txt"
        if (salidaPorArchivo.length()>14){
            nombreDeArchivo = salidaPorArchivo.substring(14, salidaPorArchivo.length());
        } else {
            nombreDeArchivo = "salida.txt";
        }
        try{
            archivo = new FileWriter(nombreDeArchivo);
            pw = new PrintWriter(archivo);
            pw.println(textoAImprimir);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
               if (null != archivo) archivo.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }    
    }
    
}