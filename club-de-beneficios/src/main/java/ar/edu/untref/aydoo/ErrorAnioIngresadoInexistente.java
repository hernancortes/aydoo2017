package ar.edu.untref.aydoo;

public class ErrorAnioIngresadoInexistente extends Error {
    
    public ErrorAnioIngresadoInexistente() {
        super("El anio ingresado debe ser el anio actual");
    }
    
}
