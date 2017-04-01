package ar.edu.untref.aydoo;

public class Program{

    public static final void main(String[] arg) throws Exception{
        Program programa = new Program();
    	try{
            programa.buscarPrimos(Integer.parseInt(arg[0]));
        } catch (Exception e) {
            impresionDeMensaje("El numero ingresado no es valido");
        }
    }
    
    public static void impresionDeMensaje(String textoAImprimir){
        System.out.print(textoAImprimir);
    }
    
    public void buscarPrimos(int numeroIngresado){
    	int divisorCandidato = 2;
    	while (!esPrimo(numeroIngresado)){
            if (numeroIngresado % divisorCandidato == 0){
    		numeroIngresado = numeroIngresado/divisorCandidato;
                impresionDeMensaje(String.valueOf(divisorCandidato) + " ");
            } else {
    		divisorCandidato++;
    		while (!esPrimo(divisorCandidato)) divisorCandidato++;
            }
    	}
        impresionDeMensaje(String.valueOf(numeroIngresado) + " ");
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
}