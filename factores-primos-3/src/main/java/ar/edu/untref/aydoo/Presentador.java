package ar.edu.untref.aydoo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Presentador {
    
    //para impresion de salto de linea en pantalla o archivo
    public final static char CR  = (char) 0x0D;
    public final static char LF  = (char) 0x0A; 
    public final static String CRLF  = "" + CR + LF;
    
    public void impresionAPantalla(String textoAImprimir){
        System.out.print(textoAImprimir);
    }
    
    public void imprimirResultadoConFormato(int numeroIngresado, ArrayList<Integer> listaDeDivisoresPrimos, String formatoDeImpresionIngresado, String tipoDeOrdenamientoElegido, String salidaPorArchivo){
        Formateador formateador = new Formateador();
        switch (formatoDeImpresionIngresado){
            case "--format=pretty":
                imprimirPorPantallaOArchivo(formateador.resultadoConFormatoPretty(numeroIngresado, listaDeDivisoresPrimos), salidaPorArchivo);
                break;
            case "--format=quiet":
                imprimirPorPantallaOArchivo(formateador.resultadoConFormatoQuiet(listaDeDivisoresPrimos, tipoDeOrdenamientoElegido), salidaPorArchivo);
                break;
            default:
                impresionAPantalla("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
        }
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
