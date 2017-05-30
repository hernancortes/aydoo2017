package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class Programa {

    public static final void main(String[] arg) {
        //Se crean los objetos
        BuscadorDePrimos buscaPrimos = new BuscadorDePrimos();
        Validador validador = new Validador();
        Presentador presentador = new Presentador();
        FormateadorContext formateadorContext = new FormateadorContext();
        if (validador.hayArgumentosIngresadosPorUsuario(arg) && validador.elPrimerArgumentoIngresadosPorUsuarioEsUnNumero(arg)) {
            //Junto todos los datos para procesar la salida
            int numeroAFactorizar = Integer.parseInt(arg[0]);
            ArrayList<Integer> listaDeDivisoresPrimos = buscaPrimos.buscar(numeroAFactorizar);
            String formatoDeImpresionIngresado = validador.validarTipoDeFormato(arg);
            String tipoDeOrdenamientoElegido = validador.validarTipoDeOrdenamiento(arg);
            String salidaPorArchivo = validador.validarTipoDeSalidaPorPantallaOArchivo(arg);
            
            formateadorContext.ejecutarEstrategia(formatoDeImpresionIngresado, numeroAFactorizar, listaDeDivisoresPrimos);
            /*
            presentador.presentarResultado(numeroAFactorizar,
                    buscaPrimos.buscar(numeroAFactorizar),
                    validador.validarTipoDeFormato(arg),
                    validador.validarTipoDeOrdenamiento(arg),
                    validador.validarTipoDeSalidaPorPantallaOArchivo(arg));*/
        } else {
            presentador.impresionAPantalla("El numero ingresado no es valido");
        } 
    }

}
