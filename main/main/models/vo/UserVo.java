package main.models.vo;

/**
 * Esta clase define objetos "User" cuyos atributos son: su id (int), su nombre (string), password (string) y role (int) del mismo
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class UserVo {
    
    //Campos de la clase
    private int id;
    private String nombre;
    private String password;
    private int role;
    
    /**
    * Constructor para un objeto User
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param id define el id del usuario
    * @param nombre define el nombre del usuario
    * @param password define el password del usuario 
    * @param role define el rol del usuario 
    */
    public UserVo(int id, String nombre, String password, int role) {
    
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.role = role;
    
    }
    
    /**
    * Método que devuelve el id del usuario
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.id es el atributo id del usuario
    */
    public int getId() {
    
        return this.id;

    }
    
    /**
    * Método que devuelve el nombre del usuario
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.nombre es el atributo nombre del usuario
    */
    public String getNombre() {
    
        return this.nombre;

    }
    
    /**
    * Método que devuelve password del usuario
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.password es el password del usuario
    */
    public String getPassword() {
    
        return this.password;

    }
    
    /**
    * Método que devuelve role del usuario
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.role es el role del usuario
    */
    public int getRole() {
    
        return this.role;

    }
    
    /**
    * Método que establece un nuevo id para el usuario
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param id parametro que define el nuevo id del usuario
    */
    public void setId(int id) {
    
        this.id = id;

    }
    
    /**
    * Método que establece un nuevo nombre para el usuario
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param nombre parametro que define el nuevo nombre del usuario
    */
    public void setNombre(String nombre) {
    
        this.nombre = nombre;

    }
    
    /**
    * Método que establece una nueva password para el usuario
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param password parametro que define la nueva password del usuario
    */
    public void setPassword(String password) {
    
        this.password = password;

    }
    
    /**
    * Método que establece un nuevo role para el usuario
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param role parametro que define la nueva password del usuario
    */
    public void setRole(int role) {
    
        this.role = role;

    }
    
}