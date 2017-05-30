package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class Programa {

    public static final void main(String[] arg) {
        //Se crean los objetos
        BuscadorDePrimos buscaPrimos = new BuscadorDePrimos();
        Validador validador = new Validador();
        Presentador presentador = new Presentador();
        FormateadorContext formateadorContext = new FormateadorContext();
        OrdenadorContext ordenadorContext = new OrdenadorContext();
        if (validador.hayArgumentosIngresadosPorUsuario(arg) && validador.elPrimerArgumentoIngresadosPorUsuarioEsUnNumero(arg)) {
            //Guardo el numero a factorizar
            int numeroAFactorizar = Integer.parseInt(arg[0]);
            //Obtengo y guardo la lista de divisores primos del numero ingresado
            ArrayList<Integer> listaDeDivisoresPrimos = buscaPrimos.buscar(numeroAFactorizar);
            //Valido y guardo el formato de impresion solicitado
            String formatoDeImpresionIngresado = validador.validarTipoDeFormato(arg);
            //Valido y guardo el tipo de ordenamiento solicitado
            String tipoDeOrdenamientoElegido = validador.validarTipoDeOrdenamiento(arg);
            //Valido y guardo el tipo de salida solicitada
            String salidaPorArchivo = validador.validarTipoDeSalidaPorPantallaOArchivo(arg);
            //Ordeno y guardo la lista de divisores primos segun lo requerido
            ArrayList<Integer> listaDeDivisoresPrimosOrdenados = ordenadorContext.ejecutarEstrategia(tipoDeOrdenamientoElegido, listaDeDivisoresPrimos);
            //Doy formato requerido a la lista ya ordenada de divisores primos y lo guardo como texto
            String textoADevolver = formateadorContext.ejecutarEstrategia(formatoDeImpresionIngresado, numeroAFactorizar, listaDeDivisoresPrimosOrdenados);
            //Muestro el texto ya ordenado y formateado segun lo requerido por el usuario
            presentador.imprimirPorPantallaOArchivo(textoADevolver, salidaPorArchivo);
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
