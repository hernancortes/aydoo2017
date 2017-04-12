package ar.edu.untref.aydoo;

import java.util.HashMap;

public class Votacion {
    private static HashMap<String, Provincia> provincias = new HashMap<>();
    private static HashMap<String, Candidato> candidatos = new HashMap<>();

    public static void setVoto(String nombreDeCandidato, String nombreDeProvincia) throws Exception {
        try{
            provincias.get(nombreDeProvincia).setVoto(candidatos.get(nombreDeCandidato));
        } catch (Exception e) {
            error(e);
        }
    }

    public static void error(Exception e) {
        System.out.print(e);
    }

    public void setProvincia(String nombreDeProvincia) {
        provincias.put(nombreDeProvincia, new Provincia(nombreDeProvincia));
    }

    public void setCandidato(String nombreDeCandidato, String nombreDePartido) {
        candidatos.put(nombreDeCandidato, new Candidato(nombreDeCandidato, nombreDePartido));
    }

    public static boolean existeProvincia(String nombreDeProvincia) {
        if (provincias.containsKey(nombreDeProvincia)) 
            return true;
        else
            return false;
    }
    
    public static boolean existeCandidato(String nombreDeCandidato) {
        if (candidatos.containsKey(nombreDeCandidato)) 
            return true;
        else
            return false;
    }
    
    
    public String getGanador(HashMap<String, Integer> cantidadDeVotos) throws Exception {
        String nombreDeGanador = "";
        int cantidadDeVotosDeGanador = 0;	
        try{
            for (String nuevaClave : cantidadDeVotos.keySet()) {
                int nuevaCantidadDeVotos = cantidadDeVotos.get(nuevaClave);
                if (nuevaCantidadDeVotos > cantidadDeVotosDeGanador) {
                    nombreDeGanador = nuevaClave;
                    cantidadDeVotosDeGanador = nuevaCantidadDeVotos;
                }
            }   
        } catch (Exception e){
            error(e);
        } finally {
            return nombreDeGanador;
        }
    }

    public String getCandidatoGanadorPais() throws Exception {
        try{
            HashMap<String, Integer> votosTotales = new HashMap<>();
            for (String provincia : this.provincias.keySet()) {
                Provincia p = this.provincias.get(provincia);
                HashMap<Candidato, Integer> votos = p.getCantidadDeVotos();
                for (Candidato candidato : votos.keySet()) {
                    String nombreDeCandidato = candidato.getNombre();
                    if (!votosTotales.containsKey(nombreDeCandidato)) {
                        votosTotales.put(nombreDeCandidato, votos.get(candidato));
                    } else {
                        votosTotales.put(nombreDeCandidato, votosTotales.get(nombreDeCandidato) + votos.get(candidato));
                    }
                }
            }
            return getGanador(votosTotales);
        } catch (Exception e){
            error(e);
            return "";
        }
    }

    public String getPartidoGanadorProvincia(String provincia) throws Exception {
        try{
            HashMap<String, Integer> cantidadDeVotosPorPartido = new HashMap<>();
            HashMap<Candidato, Integer> votos = provincias.get(provincia).getCantidadDeVotos();
            for (Candidato candidato : votos.keySet()) {
                String partido = candidato.getPartido();
                if (!cantidadDeVotosPorPartido.containsKey(partido)) {
                    cantidadDeVotosPorPartido.put(partido, votos.get(candidato));
                } else {
                    cantidadDeVotosPorPartido.put(partido, cantidadDeVotosPorPartido.get(partido) + votos.get(candidato));
                }
            }
            return getGanador(cantidadDeVotosPorPartido);
        } catch (Exception e){
            error(e);
            return "";
        }
    }
    
}