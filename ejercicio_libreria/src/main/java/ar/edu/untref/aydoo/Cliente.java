package ar.edu.untref.aydoo;

public class Cliente{
    private String nombre;
    private String dni;
    private String direccion;

    public Cliente(String nombre, String dni, String direccion){
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
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

    public void agregarCompraMensual(CompraMensual unMes){
        
    }  

}