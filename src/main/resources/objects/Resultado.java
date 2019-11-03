package main.resources.objects;

public class Resultado {

    private Centro centro;
    private Partido partido;
    private int votos;
    
    public Resultado(Centro centro, Partido partido, int votos) {
    
        this.centro = centro;
        this.partido = partido;
        this.votos = votos;
    
    }
    
    public Centro getCentro() {
    
        return this.centro;

    }
    
    public Partido getPartido() {
    
        return this.partido;

    }
    
    public int getVotos() {
    
        return this.votos;

    }
    
    public void setCentro(Centro centro) {
    
        this.centro = centro;

    }
    
    public void setPartido(Partido partido) {
    
        this.partido = partido;

    }
    
    public void setVotos(int votos) {
    
        this.votos = votos;

    }
    
    public void print() {
    
        System.out.println("------------------------------");
        System.out.println("Centro: " + this.centro.getNombre());
        System.out.println("Partido: " + this.partido.getNombre());
        System.out.println("Votos: " + this.votos);
    
    }
    
}