package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Libreria{
    private String nombreDeLibreria;
    private List<Cliente> clientes;
    
    public Libreria(String nombreDeLibreria){
        this.nombreDeLibreria = nombreDeLibreria;
        this.clientes = new LinkedList<>();
    }

    public String getNombre(){
        return this.nombreDeLibreria;
    }
    
    public void agregarCliente(Cliente clienteAAgregar){
        this.clientes.add(clienteAAgregar);
    }
    
    public void comprar(Cliente clienteIngresado, Producto productoIngresado, CompraMensual mesIngresado){
        if(!clientes.contains(clienteIngresado)) throw new Error("Cliente Inexistente");
        Iterator<Cliente> iterador = clientes.iterator();
        while (iterador.hasNext()){
            Cliente clienteIterado = iterador.next();
            if (clienteIngresado.getNombre().equals(clienteIterado.getNombre())) clienteIterado.comprar(mesIngresado, productoIngresado);
        }
    }
    
    public double calcularMontoACobrar(CompraMensual mesIngresado, Cliente clienteIngresado){
        if(!clientes.contains(clienteIngresado)) throw new Error("El cliente no existe");
        double montoTotal = 0;
        Iterator<Cliente> iterador = clientes.iterator();
        while (iterador.hasNext()){
            Cliente clienteIterado = iterador.next();
            if (clienteIngresado.getNombre().equals(clienteIterado.getNombre())) montoTotal = clienteIterado.calcularGastoMensual(mesIngresado);
        }
        return montoTotal;
    }
}
