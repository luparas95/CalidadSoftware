package main.resources.objects;

public class Partido {

    private String nombre;
    private String siglas;
    
    public Partido(String nombre, String siglas) {
    
        this.nombre = nombre;
        this.siglas = siglas;
    
    }
    
    public String getNombre() {
    
        return this.nombre;

    }
    
    public String getSiglas() {
    
        return this.siglas;

    }
    
    public void setNombre(String nombre) {
    
        this.nombre = nombre;

    }
    
    public void setSiglas(String siglas) {
    
        this.siglas = siglas;

    }
    
    public void print() {
    
        System.out.println("------------------------------");
        System.out.println("Partido: " + this.nombre);
        System.out.println("Siglas: " + this.siglas);
    
    }
    
}