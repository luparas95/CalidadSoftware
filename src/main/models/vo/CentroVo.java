package main.models.vo;

/**
 * Esta clase define objetos "Centro" cuyos atributos son: su id (int), su nombre (string) y numero de electores (int) del mismo
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class CentroVo {
    
    //Campos de la clase
    private int id;
    private String nombre;
    private int electores;
    
    /**
    * Constructor para un objeto Centro
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param id define el id del centro
    * @param nombre define el nombre del centro
    * @param electores define el numero de electores del centro 
    */
    public CentroVo(int id, String nombre, int electores) {
    
        this.id = id;
        this.nombre = nombre;
        this.electores = electores;
    
    }
    
    /**
    * Método que devuelve el id del centro
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.id es el atributo id del centro
    */
    public int getId() {
    
        return this.id;

    }
    
    /**
    * Método que devuelve el nombre del centro
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.nombre es el atributo nombre del centro
    */
    public String getNombre() {
    
        return this.nombre;

    }
    
    /**
    * Método que devuelve el numero de electores del centro
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.electores es el numero de electores del centro
    */
    public int getElectores() {
    
        return this.electores;

    }
    
    /**
    * Método que establece un nuevo id para el centro
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param id parametro que define el nuevo id del centro
    */
    public void setId(int id) {
    
        this.id = id;

    }
    
    /**
    * Método que establece un nuevo nombre para el centro
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param nombre parametro que define el nuevo nombre del centro
    */
    public void setNombre(String nombre) {
    
        this.nombre = nombre;

    }
    
    /**
    * Método que establece una nueva cantidad de electores para el centro
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
        System.out.println("Id: " + this.id);
        System.out.println("Centro: " + this.nombre);
        System.out.println("Electores: " + this.electores);
    
    }
    
}