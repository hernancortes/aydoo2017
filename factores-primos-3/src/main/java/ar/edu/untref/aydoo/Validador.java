package ar.edu.untref.aydoo;

public class Validador {
    
    public boolean hayArgumentosIngresadosPorUsuario(String[] arg) {
        boolean elArrayDeArgumentosNoEstaVacio = true;
        if (arg.length == 0) {
            elArrayDeArgumentosNoEstaVacio = false;
        }
        return elArrayDeArgumentosNoEstaVacio;
    }
    
    public boolean elPrimerArgumentoIngresadosPorUsuarioEsUnNumero(String[] arg) {
        boolean elPrimerArgumentoIngresadosPorUsuarioEsUnNumero = true;
        try {
            Integer.parseInt(arg[0]);
        } catch (NumberFormatException e) {
            elPrimerArgumentoIngresadosPorUsuarioEsUnNumero = false;
        }  
        return elPrimerArgumentoIngresadosPorUsuarioEsUnNumero;
    }
    
    public String validarTipoDeFormato(String[] arg) {
        String formatoParaImprimir = "--format=pretty";
        //busca si entre los parametros ingresados se pide formatQuiet, caso contrario mostrara formatPretty
        for (String arg1 : arg) {
            if ("--format=quiet".equals(arg1.toLowerCase())) {
                formatoParaImprimir = "--format=quiet";
            }
        }
        return formatoParaImprimir;
    }
    
    public String validarTipoDeOrdenamiento(String[] arg) {
        String ordenamientoElegido = "--sort=asc";
        //busca si entre los parametros ingresados se pide sortDesc, caso contrario mostrara sortAsc
        for (String arg1 : arg) {
            if ("--sort=des".equals(arg1.toLowerCase())) {
                ordenamientoElegido = "--sort=des";
            }
        }
        return ordenamientoElegido;
    }
    
    public String validarTipoDeSalidaPorPantallaOArchivo(String[] arg) {
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
    
}
