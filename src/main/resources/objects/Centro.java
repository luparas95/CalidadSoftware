package main.resources.objects;

/**
 * Esta clase define objetos "Centro" cuyos atributos son su nombre (string) y numero de electores (int) del mismo
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class Centro {
    
    //Campos de la clase
    private String nombre;
    private int electores;
    
    /**
    * Constructor para un objeto Centro
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param nombre define el nombre del centro
    * @param electores define el numero de electores del centro 
    */
    public Centro(String nombre, int electores) {
    
        this.nombre = nombre;
        this.electores = electores;
    
    }
    
    /**
    * Metodo que devuelve el nombre del centro
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.nombre es el atributo nombre del centro en cuestion 
    */
    public String getNombre() {
    
        return this.nombre;

    }
    
    /**
    * Metodo que devuelve el numero de electores del centro
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.electores es el atributo electores del centro en cuestion 
    */
    public int getElectores() {
    
        return this.electores;

    }
    
    /**
    * Metodo establece un nuevo nombre para el centro
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param nombre parametro que define el nuevo nombre del centro
    */
    public void setNombre(String nombre) {
    
        this.nombre = nombre;

    }
    
    /**
    * Metodo establece una nueva cantidad de electores para el centro
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param electores parametro que define la nueva cantidad de electores del centro
    */
    public void setElectores(int electores) {
    
        this.electores = electores;

    }
    
    /**
     * Método que imprime por pantalla los atributos de un objeto Centro
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     */
    public void print() {
    
        System.out.println("------------------------------");
        System.out.println("Centro: " + this.nombre);
        System.out.println("Electores: " + this.electores);
    
    }
    
}