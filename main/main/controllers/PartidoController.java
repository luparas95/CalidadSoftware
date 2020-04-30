package main.controllers;

import java.util.List;
import java.util.Vector;

import main.models.vo.PartidoVo;
import main.models.dao.PartidoDao;

/**
 * Esta clase contiene el menu de la clase Partido y la implementacion de sus metodos
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class PartidoController {
    
    /**
     * Método que imprime por pantalla los atributos de todos los objetos Partido guardados
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     */
    public static Vector<Vector> getPartidos() {
        
        List partidos = PartidoDao.getPartidos();
        Vector<Vector> vPartidos = new Vector<Vector>();

        for (Object partido:partidos) {
            
            Vector<String> data = new Vector<String>();
            data.add("" + ((PartidoVo) partido).getId());
            data.add(((PartidoVo) partido).getNombre());
            data.add("" + ((PartidoVo) partido).getSiglas());
            vPartidos.add(data);

        }
        
        return vPartidos;
    
    }
    
    /**
    * Método que devuelve una lista de partidos sólo su id y su nombre
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    */
    public static Vector<String> getPartidosForDrowpdowns() {
        
        List partidos = PartidoDao.getPartidos();
        Vector<String> vPartidos = new Vector<String>();

        for (Object partido:partidos) {
            
            String data = "" + ((PartidoVo) partido).getId() + " - " + ((PartidoVo) partido).getNombre();
            vPartidos.add(data);

        }
        
        return vPartidos;
    
    }
    
    /**
    * Método que imprime por pantalla los atributos de el objeto Partido guardado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param idPartido El id del partido a extraer
    */
    public static PartidoVo getPartidoById(int idPartido) {
        
        return PartidoDao.getPartidoById(idPartido);
    
    }
    
    /**
    * Método que crea un nuevo objeto Partido y lo agrega al arreglo donde son almacenados
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param nombre El nombre del partido a crear
    * @param siglas Las siglas del partido a crear
    */
    public static void creaPartido(String nombre, String siglas) {
    
        PartidoVo partido = new PartidoVo(0, nombre, siglas);
        PartidoDao.createPartido(partido);
    
    }
    
    /**
    * Método que crea un actualiza un objeto Partido
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param partido El objeto partido a actualizar
    */
    public static void updatePartido(PartidoVo partido) {
    
        PartidoDao.updatePartido(partido);
    
    }

}