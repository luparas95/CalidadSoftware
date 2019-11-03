package main.resources.objects;

public class Centro {

    private String nombre;
    private int electores;
    
    public Centro(String nombre, int electores) {
    
        this.nombre = nombre;
        this.electores = electores;
    
    }
    
    public String getNombre() {
    
        return this.nombre;

    }
    
    public int getElectores() {
    
        return this.electores;

    }
    
    public void setNombre(String nombre) {
    
        this.nombre = nombre;

    }
    
    public void setElectores(int electores) {
    
        this.electores = electores;

    }
    
    public void print() {
    
        System.out.println("------------------------------");
        System.out.println("Centro: " + this.nombre);
        System.out.println("Electores: " + this.electores);
    
    }
    
}