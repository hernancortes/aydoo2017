package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CompraMensual{
    private String nombre;
    private List<Producto> compras;
    
    public CompraMensual(String nombre){
        this.nombre = nombre;
        this.compras = new LinkedList<>();
    }
    
    public String getNombre(){
	return this.nombre;
    }
    
    public void AgregarCompra(Producto producto){
        this.compras.add(producto);
    }

    public double calcularGastoMensual(){
        double total = 0;
        Iterator<Producto> iterador = compras.iterator();
        while (iterador.hasNext()){
            Producto productoIterado = iterador.next();
            total += productoIterado.getPrecio();
        }
        return total;
    }

}