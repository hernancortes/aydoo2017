package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Libreria{
    private String nombreDeLibreria;
    private List<Cliente> clientes;
    
    public Libreria(String nombreDeLibreria){
        this.nombreDeLibreria = nombreDeLibreria;
        this.clientes = new LinkedList<Cliente>();
    }

    public String getNombre(){
        return this.nombreDeLibreria;
    }
    
    public void agregarCliente(Cliente clienteAAgregar){
        this.clientes.add(clienteAAgregar);
    }
    
    public void comprar(Cliente cliente, Producto producto, CompraMensual mes){
        if(!clientes.contains(cliente)) throw new Error("Cliente Inexistente");
        Iterator<Cliente> iterador = clientes.iterator();
        while (iterador.hasNext()){
            Cliente clienteActual = iterador.next();
            if (cliente.getNombre().equals(clienteActual.getNombre())) clienteActual.comprar(mes, producto);
        }
    }
    
    public double calcularMontoACobrar(CompraMensual mes, Cliente cliente) {
        return 1.0;
    }
}
