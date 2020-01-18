package main.models.vo;

/**
 * Esta clase define objetos "Resultado" los cuales se componen de tuplas formadas por un idCentro (int), un idPartido (int) y 
 * la cantidad de votos (int) que el partido ha obtenido en dicho centro
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class ResultadoVo {

    //Campos de la clase
    private int idCentro;
    private int idPartido;
    private int votos;
    
    /**
    * Constructor para un objeto Resultado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param idCentro define el id del centro 
    * @param idPartido define el id del partido
    * @param votos define la cantidad de votos que el partido ha obtenido en el centro en cuestión
    */
    public ResultadoVo(int idCentro, int idPartido, int votos) {
    
        this.idCentro = idCentro;
        this.idPartido = idPartido;
        this.votos = votos;
    
    }
    
    /**
    * Método que devuelve el objeto Centro de la tupla Resultado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.idCentro es el id Centro de la tupla Resultado
    */
    public int getIdCentro() {
    
        return this.idCentro;

    }
    
    /**
    * Método que devuelve el objeto Partido de la tupla Resultado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return this.idPartido es el objeto Partido de la tupla Resultado
    */
    public int getIdPartido() {
    
        return this.idPartido;

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
    * @param idCentro parametro que define el nuevo centro del Resultado
    */
    public void setIdCentro(int idCentro) {
    
        this.idCentro = idCentro;

    }
    
    /**
    * Método que establece el atributo partido del objeto Resultado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param idPartido parametro que define el nuevo partido del Resultado
    */
    public void setIdPartido(int idPartido) {
    
        this.idPartido = idPartido;

    }
    
    /**
    * Método que establece la cantidad de votos que ha obtenido el partido en el centro especificado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param votos parametro que define el numero de votos
    */
    public void setVotos(int votos) {
    
        this.votos = votos;

    }
    
}