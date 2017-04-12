package ar.edu.untref.aydoo;

public class Voto {
    final private String nombreDeCandidato;
    final private String nombreDeProvincia;

    public Voto(String nombreDeCandidato, String nombreDeProvincia) {
            this.nombreDeCandidato = nombreDeCandidato;
            this.nombreDeProvincia = nombreDeProvincia;
            try{
                if (Votacion.existeProvincia(nombreDeProvincia) && Votacion.existeCandidato(nombreDeCandidato)){
                    Votacion.setVoto(nombreDeCandidato, nombreDeProvincia);
                } else {
                    throw new Error ("Ha ingresado datos incorrectos");
                }
            } catch (Exception e) {
                error(e);
            }
    }

    public static void error(Exception e) {
        System.out.print(e);
    }
    
}
