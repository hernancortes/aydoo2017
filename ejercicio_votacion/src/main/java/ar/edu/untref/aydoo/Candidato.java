package ar.edu.untref.aydoo;

public class Candidato {
    final private String nombreDeCandidato;
    final private String nombreDePartido;

    public Candidato(String nombreDeCandidato, String nombreDePartido) {
            this.nombreDeCandidato = nombreDeCandidato;
            this.nombreDePartido = nombreDePartido;
    }

    public String getNombre() {
            return nombreDeCandidato;
    }

    public String getPartido() {
            return nombreDePartido;
    }

}