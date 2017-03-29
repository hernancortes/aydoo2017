package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class IntegracionTest {
    Votacion nuevaVotacion = new Votacion();
    
    @Before
    public void configuracionInicialYSimulacionDeVotacion() throws Exception {
        nuevaVotacion.setProvincia("Buenos Aires");
        nuevaVotacion.setProvincia("Catamarca");
        nuevaVotacion.setProvincia("Chaco");
        nuevaVotacion.setProvincia("Chubut");
        nuevaVotacion.setProvincia("Cordoba");
        nuevaVotacion.setProvincia("Corrientes");
        nuevaVotacion.setProvincia("Entre Rios");
        nuevaVotacion.setProvincia("Formosa");
        nuevaVotacion.setProvincia("Jujuy");
        nuevaVotacion.setProvincia("La Pampa");
        nuevaVotacion.setProvincia("La Rioja");
        nuevaVotacion.setProvincia("Mendoza");
        nuevaVotacion.setProvincia("Misiones");
        nuevaVotacion.setProvincia("Neuquen");
        nuevaVotacion.setProvincia("Rio Negro");
        nuevaVotacion.setProvincia("Salta");
        nuevaVotacion.setProvincia("San Juan");
        nuevaVotacion.setProvincia("San Luis");
        nuevaVotacion.setProvincia("Santa Cruz");
        nuevaVotacion.setProvincia("Santa Fe");
        nuevaVotacion.setProvincia("Santiago del Estero");
        nuevaVotacion.setProvincia("Tierra del Fuego");
        nuevaVotacion.setProvincia("Tucuman");

        nuevaVotacion.setCandidato("Juan", "Partido J");
        nuevaVotacion.setCandidato("Jose", "Partido J");
        nuevaVotacion.setCandidato("Martin", "Partido M");
        nuevaVotacion.setCandidato("Mauro", "Partido M");
        
        nuevaVotacion.setVoto("Juan", "Buenos Aires");
        nuevaVotacion.setVoto("Juan", "Buenos Aires");
        nuevaVotacion.setVoto("Juan", "Buenos Aires");
        nuevaVotacion.setVoto("Juan", "Buenos Aires");
        nuevaVotacion.setVoto("Juan", "Buenos Aires");
        nuevaVotacion.setVoto("Juan", "Buenos Aires");
        
        nuevaVotacion.setVoto("Jose", "Jujuy");
        nuevaVotacion.setVoto("Jose", "Jujuy");
        nuevaVotacion.setVoto("Jose", "Jujuy");
        nuevaVotacion.setVoto("Jose", "Jujuy");
        
        nuevaVotacion.setVoto("Martin", "Jujuy");
        nuevaVotacion.setVoto("Martin", "Jujuy");
        nuevaVotacion.setVoto("Martin", "Jujuy");
        nuevaVotacion.setVoto("Martin", "Jujuy");
        nuevaVotacion.setVoto("Martin", "Jujuy");
        nuevaVotacion.setVoto("Martin", "Jujuy");
        nuevaVotacion.setVoto("Martin", "Jujuy");
        
        nuevaVotacion.setVoto("Mauro", "Buenos Aires");
        
        nuevaVotacion.setVoto("Juan", "Salta");
        nuevaVotacion.setVoto("Juan", "Salta");
        nuevaVotacion.setVoto("Juan", "Salta");
        nuevaVotacion.setVoto("Juan", "Salta");
        nuevaVotacion.setVoto("Juan", "Salta");
        
        nuevaVotacion.setVoto("Mauro", "Salta");
        nuevaVotacion.setVoto("Mauro", "Salta");
    }

    @Test
    public void juanGanaComoCandidatoANivelNacional() throws Exception {
        Assert.assertEquals("Juan", nuevaVotacion.getCandidatoGanadorPais());
    }
    
    @Test
    public void martinNoGanaComoCandidatoANivelNacional() throws Exception {
        Assert.assertNotEquals("Martin", nuevaVotacion.getCandidatoGanadorPais());
    }
    
       @Test
    public void elPartidoConMasVotosEnJujuyEsM() throws Exception {
        Assert.assertEquals("Partido M", nuevaVotacion.getPartidoGanadorProvincia("Jujuy"));
    }
    
           @Test
    public void elPartidoConMasVotosEnBuenosAiresEsJ() throws Exception {
        Assert.assertEquals("Partido J", nuevaVotacion.getPartidoGanadorProvincia("Buenos Aires"));
    }
    
           @Test
    public void elPartidoConMasVotosEnSaltaEsJ() throws Exception {
        Assert.assertEquals("Partido J", nuevaVotacion.getPartidoGanadorProvincia("Salta"));
    }
    
    @Test
    public void elPartidoConMasVotosEnSaltaNoEsM() throws Exception {
        Assert.assertNotEquals("Partido M", nuevaVotacion.getPartidoGanadorProvincia("Salta"));
    }
    
}