package main.resources.objects;

/**
 * Esta clase define objetos "Resultado" los cuales se componen de tuplas formadas por un objeto Centro, un objeto Partido y 
 * la cantidad de votos que el partido ha obtenido en dicho centro
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class Resultado implements Comparable<Resultado> {

    //Campos de la clase
    private Centro centro;
    private Partido partido;
    private int votos;
    
    /**
    * Constructor para un objeto Resultado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param centro define el centro 
    * @param partido define el partido
    * @param votos define la cantidad de votos que el partido ha obtenido en el centro en cuestión
    */
    public Resultado(Centro centro, Partido partido, int votos) {
    
        this.centro = centro;
        this.partido = partido;
        this.votos = votos;
    
    }
    
    /**
    * Método que devuelve el objeto Centro de la tupla Resultado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.centro es el objeto Centro de la tupla Resultado
    */
    public Centro getCentro() {
    
        return this.centro;

    }
    
    /**
    * Método que devuelve el objeto Partido de la tupla Resultado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.partido es el objeto Partido de la tupla Resultado
    */
    public Partido getPartido() {
    
        return this.partido;

    }
    
    /**
    * Método que devuelve la cantidad de votos que el partido ha obtenido en centro especificado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.votos es la cantidad de votos obtenidos por el partido especificado, en el centro designado
    */
    public int getVotos() {
    
        return this.votos;

    }
    
    /**
    * Método que establece el atributo centro del objeto Resultado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param centro parametro que define el nuevo centro del Resultado
    */
    public void setCentro(Centro centro) {
    
        this.centro = centro;

    }
    
    /**
    * Método que establece el atributo partido del objeto Resultado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param partido parametro que define el nuevo partido del Resultado
    */
    public void setPartido(Partido partido) {
    
        this.partido = partido;

    }
    
    /**
    * Método que establece la cantidad de votos que ha obtenido el partido en el centro especificado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param votos parametro que define el numero de votos
    */
    public void setVotos(int votos) {
    
        this.votos = votos;

    }
    /**
     * Método que imprime por pantalla los atributos de un objeto Resultado
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     */
    public void print() {
    
        System.out.println("------------------------------");
        System.out.println("Centro: " + this.centro.getNombre());
        System.out.println("Partido: " + this.partido.getNombre());
        System.out.println("Votos: " + this.votos);
    
    }
    
    @Override
    public int compareTo(Resultado r) {

        return getCentro().getNombre().compareTo(r.getCentro().getNombre());

    }
    
}