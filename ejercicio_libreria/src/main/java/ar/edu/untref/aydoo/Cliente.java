package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Cliente{
    private String nombre;
    private String dni;
    private String direccion;
    private List<CompraMensual> compras;

    public Cliente(String nombre, String dni, String direccion){
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.compras = new LinkedList<>();
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getDni(){
        return this.dni;
    }

    public String getDireccion(){
        return this.direccion;
    }

    public void agregarCompraMensual(CompraMensual mes){
        this.compras.add(mes);
    }  

    public void comprar(CompraMensual mesIngresado, Producto productoIngresado){
        if(!compras.contains(mesIngresado)) throw new Error("Mes Inexistente");
        Iterator<CompraMensual> iterador = compras.iterator();
        while (iterador.hasNext()){
            CompraMensual mesIterado = iterador.next();
            if (mesIterado.getNombre().equals(mesIngresado.getNombre())) mesIterado.agregarCompra(productoIngresado);
        }
    }
    
    public double calcularGastoMensual(CompraMensual mesIngresado){
        if(!compras.contains(mesIngresado)) throw new Error("Mes Inexistente");
        double total = 0;
        Iterator<CompraMensual> iterador = compras.iterator();
        while (iterador.hasNext()){
            CompraMensual mesIterado = iterador.next();
            if (mesIterado.getNombre().equals(mesIngresado.getNombre())) total += mesIterado.calcularGastoMensual();
        }
        return total;
	}
    
}