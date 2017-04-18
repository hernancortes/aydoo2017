package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class ClubDeBeneficios {

    private List<Establecimiento> establecimientos = new ArrayList<>();
    
    public void agregarEstablecimiento(Establecimiento establecimiento) {
        this.establecimientos.add(establecimiento);
    }

    public Establecimiento obtenerEstablecimientoAFelicitar() {
        return this.establecimientos.get(0);
    }

}
