package main.models.vo;

/**
 * Esta clase define objetos "Partido" cuyos atributos son el id (int), el nombre (string) y las siglas (string) del mismo
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class PartidoVo {

    //Campos de la clase
    private int id;
    private String nombre;
    private String siglas;
    
    /**
    * Constructor para un objeto Partido
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param id define el id del partido
    * @param nombre define el nombre del partido
    * @param siglas define las siglas del partido
    */
    public PartidoVo(int id, String nombre, String siglas) {
    
        this.id = id;
        this.nombre = nombre;
        this.siglas = siglas;
    
    }
    
    /**
    * Método que devuelve el id del partido
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return id es el id del partido
    */
    public int getId() {
    
        return this.id;

    }
    
    /**
    * Método que devuelve el nombre del partido
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.nombre es el nombre del partido
    */
    public String getNombre() {
    
        return this.nombre;

    }
    
    /**
    * Método que devuelve las siglas del partido
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.siglas siglas del partido 
    */
    public String getSiglas() {
    
        return this.siglas;

    }
    
    /**
    * Método que establece un nuevo id para el partido
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param id parametro que define el nuevo id del partido
    */
    public void setId(int id) {
    
        this.id = id;

    }
    
    /**
    * Método que establece un nuevo nombre para el partido
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param nombre parametro que define el nuevo nombre del partido
    */
    public void setNombre(String nombre) {
    
        this.nombre = nombre;

    }
    
    /**
    * Método que establece nuevas siglas para el partido
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param siglas parametro que define las nuevas siglas del partido
    */
    public void setSiglas(String siglas) {
    
        this.siglas = siglas;

    }

        /**
     * Método que imprime por pantalla los atributos de un objeto Partido
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     */
    public void print() {
    
        System.out.println("------------------------------");
        System.out.println("Partido: " + this.nombre);
        System.out.println("Siglas: " + this.siglas);
    
    }
    
}