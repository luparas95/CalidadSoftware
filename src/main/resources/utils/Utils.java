package main.resources.utils;

import main.resources.objects.Centro;
import main.resources.objects.Partido;
import main.resources.objects.Resultado;

/**
 * Esta clase contiene los metodos para introducir elementos en los arreglos donde se guardan los objetos Centro, Partido y Resultado respectivamente
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class Utils {
    
    /**
    * Método que introduce un nuevo centro al arreglo de centros
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param item este parametro es el nuevo objeto Centro a almacenar
    * @param oldArray este parametro es el arreglo de centros donde se guardan todos los objetos Centro
    * @return newArray es el arreglo donde se guardan los centros actualizado con el nuevo objeto Centro
    */
    public static Centro[] CentroArrayPush(Centro item, Centro[] oldArray) {
        
        int len = oldArray.length;
        Centro[] newArray = new Centro[len + 1];
        System.arraycopy(oldArray, 0, newArray, 0, len);
        newArray[len] = item;

        return newArray;

    }
    
     /**
    * Método que introduce un nuevo partido al arreglo de partidos
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param item este parametro es el nuevo objeto Partido a almacenar
    * @param oldArray este parametro es el arreglo de partidos donde se guardan todos los objetos Partido
    * @return newArray es el arreglo donde se guardan los partidos actualizado con el nuevo objeto Partido
    */
    public static Partido[] PartidoArrayPush(Partido item, Partido[] oldArray) {
        
        int len = oldArray.length;
        Partido[] newArray = new Partido[len + 1];
        System.arraycopy(oldArray, 0, newArray, 0, len);
        newArray[len] = item;

        return newArray;

    }
    
     /**
    * Método que introduce un nuevo resultado al arreglo de resultados
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param item este parametro es el nuevo objeto Resultado a almacenar
    * @param oldArray este parametro es el arreglo de resultados donde se guaradan todos los objetos Resultado
    * @return newArray es el arreglo donde se guardan los resultados actualizado con el nuevo objeto Resultado
    */
    public static Resultado[] ResultadoArrayPush(Resultado item, Resultado[] oldArray) {
        
        int len = oldArray.length;
        Resultado[] newArray = new Resultado[len + 1];
        System.arraycopy(oldArray, 0, newArray, 0, len);
        newArray[len] = item;

        return newArray;

    }
        
}