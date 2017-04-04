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
        this.compras = new LinkedList<CompraMensual>();
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

    public void comprar(CompraMensual mes, Producto producto) {
        if(!compras.contains(mes)) throw new Error("Mes Inexistente");
        Iterator<CompraMensual> iterador = compras.iterator();
        while (iterador.hasNext()) {
            CompraMensual mesActual = iterador.next();
            if (mesActual.getNombre().equals(mes.getNombre())) {
                mesActual.AgregarCompra(producto);
            }
        }
    }
    
}