package ar.edu.untref.aydoo;

public class Program{

    public static final void main(String[] arg) {
        Program programa = new Program();
        BuscadorDePrimos buscaPrimos = new BuscadorDePrimos();
        Validador validador = new Validador();
        Presentador presentador = new Presentador();
        
    	try{
            presentador.imprimirResultadoConFormato(Integer.parseInt(arg[0]), buscaPrimos.buscar(Integer.parseInt(arg[0])), validador.validarTipoDeFormato(arg), validador.validarTipoDeOrdenamiento(arg), validador.validarTipoDeSalidaPorPantallaOArchivo(arg));
        } catch (Exception e) {
            presentador.impresionAPantalla("El numero ingresado no es valido");
        }
    }

}