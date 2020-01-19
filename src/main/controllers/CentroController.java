package main.controllers;

import java.util.List;
import java.util.Vector;

import main.models.vo.CentroVo;
import main.models.dao.CentroDao;

/**
 * Esta clase contiene el menu de la clase Centro y la implementacion de sus metodos
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class CentroController {
    
    /**
    * Método que imprime por pantalla los atributos de todos los objetos Centro guardados
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    */
    public static Vector<Vector> getCentros() {
        
        List centros = CentroDao.getCentros();
        Vector<Vector> vCentros = new Vector<Vector>();

        for (Object centro:centros) {
            
            Vector<String> data = new Vector<String>();
            data.add("" + ((CentroVo) centro).getId());
            data.add(((CentroVo) centro).getNombre());
            data.add("" + ((CentroVo) centro).getElectores());
            vCentros.add(data);

        }
        
        return vCentros;
    
    }
    
    /**
    * Método que crea un nuevo objeto Centro y lo agrega al arreglo donde son almacenados
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param nombre El nombre del centro a crear
    * @param electores El número de electores del centro a crear
    */
    public static void creaCentro(String nombre, int electores) {
    
        CentroVo centro = new CentroVo(0, nombre, electores);
        CentroDao.createCentro(centro);
    
    }

}