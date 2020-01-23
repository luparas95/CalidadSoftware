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
    * Método que crea un nuevo objeto Partido y lo agrega al arreglo donde son almacenados
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param nombre El nombre del partido a crear
    * @param siglas Las siglas del partido a crear
    */
    public static void creaPartido(String nombre, String siglas) {
    
        PartidoVo partido = new PartidoVo(0, nombre, siglas);
        PartidoDao.createPartido(partido);
    
    }

}