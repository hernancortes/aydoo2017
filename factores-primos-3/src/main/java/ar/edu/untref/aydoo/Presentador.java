package ar.edu.untref.aydoo;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Presentador {
    
    public String imprimirPorPantallaOArchivo(String textoAImprimir, String salidaPorArchivo) {
        String tipoDeSalida;
        if ("".equals(salidaPorArchivo)) {
            tipoDeSalida = impresionAPantalla(textoAImprimir);
        } else {
            tipoDeSalida = impresionAArchivo(textoAImprimir, salidaPorArchivo);
        }
        //este return es solo para poder cubrir este metodo con los tests
        return tipoDeSalida;
    }
    
    public String impresionAPantalla(String textoAImprimir) {
        System.out.print(textoAImprimir);
        //este return es solo para poder cubrir este metodo con los tests
        return "salida por pantalla";
    }
    
    public String impresionAArchivo(String textoAImprimir, String salidaPorArchivo) {
        FileWriter archivo = null;
        PrintWriter pw = null;
        String nombreDeArchivo;
        //si solo fue ingresado argumento "--output-file=" el archivo se llamara "salida.txt"
        if (salidaPorArchivo.length()>14) {
            nombreDeArchivo = salidaPorArchivo.substring(14, salidaPorArchivo.length());
        } else {
            nombreDeArchivo = "salida.txt";
        }
        try {
            archivo = new FileWriter(nombreDeArchivo);
            pw = new PrintWriter(archivo);
            pw.println(textoAImprimir);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
               if (null != archivo) {
                   archivo.close();
               }
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        //este return es solo para poder cubrir este metodo con los tests
        return "salida por archivo";
    }
    
}
