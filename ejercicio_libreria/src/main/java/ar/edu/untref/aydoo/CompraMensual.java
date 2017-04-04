package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CompraMensual{
    private String nombre;
    private List<Producto> compras;
    
    public CompraMensual(String nombre){
        this.nombre = nombre;
        this.compras = new LinkedList<Producto>();
    }
    
    public String getNombre(){
	return this.nombre;
    }
    
    public void AgregarCompra(Producto producto){
        this.compras.add(producto);
    }

    public double calcularGastoMensual(){
        return 1.0;
    }

}