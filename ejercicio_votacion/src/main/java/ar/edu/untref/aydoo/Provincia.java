package ar.edu.untref.aydoo;

import java.util.HashMap;

public class Provincia {
    final private String nombreDeProvincia;
    private HashMap<Candidato, Integer> candidatoYCantidadDeVotos;

    public Provincia(String nombreDeProvincia) {
        this.nombreDeProvincia = nombreDeProvincia;
        this.candidatoYCantidadDeVotos = new HashMap<>();
    }

    public String getNombre() {
        return nombreDeProvincia;
    }

    public HashMap<Candidato, Integer> getCantidadDeVotos() {
        return candidatoYCantidadDeVotos;
    }
    
    public void setVoto(Candidato candidato) {
        if (!candidatoYCantidadDeVotos.containsKey(candidato))
            candidatoYCantidadDeVotos.put(candidato, 1);
        else
            candidatoYCantidadDeVotos.put(candidato, candidatoYCantidadDeVotos.get(candidato) + 1);
    }
    
}