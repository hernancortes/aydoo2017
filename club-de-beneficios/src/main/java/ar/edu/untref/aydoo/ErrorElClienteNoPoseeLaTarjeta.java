package ar.edu.untref.aydoo;

public class ErrorElClienteNoPoseeLaTarjeta extends Error {
    
    public ErrorElClienteNoPoseeLaTarjeta() {
        super("El cliente no posee la tarjeta necesaria para este beneficio");
    }
}
