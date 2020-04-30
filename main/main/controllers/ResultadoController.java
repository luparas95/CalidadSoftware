package main.controllers;

import java.util.List;
import java.util.Vector;
import main.exceptions.DuplicateRowException;
import main.exceptions.VotesOutOfRangeException;

import main.models.dao.CentroDao;
import main.models.dao.ResultadoDao;

import main.models.vo.CentroVo;
import main.models.vo.ResultadoToPrintVo;
import main.models.vo.ResultadoVo;


/**
 * Esta clase contiene el menu de la clase Resultado y la implementacion de sus metodos
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class ResultadoController {
    
    /**
     * Metodo que comprueba si ya existe una tripleta con el centro y el partido especificados
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     * @param resultados[] arreglo usado para almacenar todos los resultados del sistema
     * @param idCentro id del centro escogido por el usuario
     * @param idPartido id del partido escogido por el usuario
     * @return verdadero o falso dependiendo de si ya existe una trupleta con el centro y partido seleccionados
     */  
    private static Boolean existeResultado(List resultados, int idCentro, int idPartido) {
    
        for (Object resultado:resultados) {

            if (((ResultadoVo) resultado).getIdCentro() == idCentro && ((ResultadoVo) resultado).getIdPartido() == idPartido) {
            
                return true;
            
            }

        }
        
        return false;
    
    }
    
    /**
     * Metodo que devuelve la cantidad de votos disponibles en un centro
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     * @param resultados[] arreglo usado para almacenar todos los resultados del sistema
     * @param centro centro escogido por el usuario
     * @return int es el número de votos disponibles del centro
     */  
    private static int votosDisponibles(List resultados, CentroVo centro, int idPartido) {
    
        int votosDisponibles = centro.getElectores();
        for (Object resultado:resultados) {

            if (((ResultadoVo) resultado).getIdPartido() != idPartido) {
                
                votosDisponibles -= ((ResultadoVo) resultado).getVotos();
                
            }

        }
        
        return votosDisponibles;
    
    }
    
    /**
     * Metodo que introduce la nueva tripleta en el arreglo donde se almacenan
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     */   
    public static void creaResultado(int idCentro, int idPartido, int votos) throws DuplicateRowException, VotesOutOfRangeException {
    
        CentroVo centro = CentroDao.getCentroById(idCentro);
        List resultados = ResultadoDao.getResultadosByCentro(idCentro);
        
        if (existeResultado(resultados, idCentro, idPartido)) {

            throw new DuplicateRowException();
            
        } else {
            
            int votosDisponibles = votosDisponibles(resultados, centro, idPartido);
            if (votos > votosDisponibles) {

                throw new VotesOutOfRangeException(votosDisponibles);
                
            } else {
                
                ResultadoDao.createResultado(new ResultadoVo(idCentro, idPartido, votos));
            
            }

        }
    
    }
    
    /**
    * Método que lista los objetos resultado de la BBDD
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return resultados Lista de resultados de la BBDD en formato para mostrar
    */
    public static Vector<Vector> getResultadosToPrint() {
        
        List resultados =  ResultadoDao.getResultadosToPrint();
        Vector<Vector> vResultados = new Vector<Vector>();

        for (Object resultado:resultados) {
            
            Vector<String> data = new Vector<String>();
            data.add(((ResultadoToPrintVo) resultado).getCentro());
            data.add(((ResultadoToPrintVo) resultado).getPartido());
            data.add("" + ((ResultadoToPrintVo) resultado).getVotos());
            vResultados.add(data);

        }
        
        return vResultados;
        
    }

    /**
    * Método que actualiza un objeto Resultado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param resultado El objeto resultado a actualizar
    */
    public static void updateResultado(ResultadoVo resultado) throws VotesOutOfRangeException {
        
        CentroVo centro = CentroDao.getCentroById(resultado.getIdCentro());
        List resultados = ResultadoDao.getResultadosByCentro(resultado.getIdCentro());
        
        int votosDisponibles = votosDisponibles(resultados, centro, resultado.getIdPartido());
        if (resultado.getVotos() > votosDisponibles) {

            throw new VotesOutOfRangeException(votosDisponibles);

        } else {

            ResultadoDao.updateResultado(resultado);

        }
    
    }

}
