package main.controllers;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import main.models.dao.CentroDao;
import main.models.dao.PartidoDao;
import main.models.dao.ResultadoDao;

import main.models.vo.CentroVo;
import main.models.vo.PartidoVo;
import main.models.vo.ResultadoVo;


/**
 * Esta clase contiene el menu de la clase Resultado y la implementacion de sus metodos
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class ResultadoController {
    
    /**
     * Metodo que imprime por pantalla todos los centros almacenados con un número asociado y devuelve el centro elegido
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     * @param centros este parametro es el arreglo usado para almacenar todos los centros del sistema
     * @return Centro es el centro elegido por el usuario de entre todos los almacenados
     */
    private static CentroVo escogeCentro(List centros) {
    
        Scanner entrada = new Scanner(System.in);
        CentroVo centroEscogido = null;
        Boolean opcionNoValida = true;
        
        System.out.println("------------------------------");

        int i = 0;
        for (Object centro:centros) {

            i++;
            System.out.println("" + i + ". " + ((CentroVo) centro).getNombre());

        }

        System.out.print("Escoge centro: ");
        
        do {
        
            try {
                
                int opcion = entrada.nextInt();
                
                if (opcion < 1 || opcion > centros.size()) {
                
                    System.out.print("Opción incorrecta, vuelva a introducirla: ");
                
                } else {
                    
                    centroEscogido = (CentroVo) centros.get(opcion - 1);
                    opcionNoValida = false;
                    
                }
            
            } catch (InputMismatchException ime) {
            
                System.out.print("Número incorrecto, vuelva a introducirla: ");
                entrada.next();
            
            }
        
        } while (opcionNoValida);
        
        return centroEscogido;
    
    }
    
    /**
     * Metodo que imprime por pantalla todos los partidos almacenados con un número asociado y devuelve el partido elegido
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     * @param partidos[] este parametro es el arreglo usado para almacenar todos los partidos del sistema
     * @return Partido es el partido elegido por el usuario de entre todos los almacenados
     */
    private static PartidoVo escogePartido(List partidos) {
    
        Scanner entrada = new Scanner(System.in);
        PartidoVo partidoEscogido = null;
        Boolean opcionNoValida = true;
        
        System.out.println("------------------------------");

        int i = 0;
        for (Object partido:partidos) {

            i++;
            System.out.println("" + i + ". " + ((PartidoVo) partido).getNombre());

        }

        System.out.print("Escoge partido: ");
        
        do {
        
            try {
                
                int opcion = entrada.nextInt();
                
                if (opcion < 1 || opcion > partidos.size()) {
                
                    System.out.print("Opción incorrecta, vuelva a introducirla: ");
                
                } else {
                    
                    partidoEscogido = (PartidoVo) partidos.get(opcion - 1);
                    opcionNoValida = false;
                    
                }
            
            } catch (InputMismatchException ime) {
            
                System.out.print("Opción incorrecta, vuelva a introducirla: ");
                entrada.next();
            
            }
        
        } while (opcionNoValida);
        
        return partidoEscogido;
    
    }
    
    /**
     * Metodo que pide introducir al usuario un número de votos válido para el centro escogido
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     * @param resultados[] arreglo usado para almacenar todos los resultados del sistema
     * @param centro este parametro es el centro escogido por el usuario
     * @return int es el número de votos de la nueva tripleta
     */    
    private static int introduceVotos(List resultados, CentroVo centro) {
    
        Scanner entrada = new Scanner(System.in);
        int votos = 0;
        Boolean opcionNoValida = true;
        
        System.out.println("------------------------------");

        System.out.print("Introduce número de votos: ");
        
        do {
        
            try {
                
                int opcion = entrada.nextInt();
                int votosDisponibles = votosDisponibles(resultados, centro);
                if (opcion < 0 || opcion > votosDisponibles) {
                
                    System.out.print("Número incorrecto, hay " + votosDisponibles + " votos disponibles: ");
                
                } else {
                    
                    votos = opcion;
                    opcionNoValida = false;
                    
                }
            
            } catch (InputMismatchException ime) {
            
                System.out.print("Número incorrecto, vuelva a introducirlo: ");
                entrada.next();
            
            }
        
        } while (opcionNoValida);
        
        return votos;
    
    }
    
    /**
     * Metodo que comprueba si ya existe una tripleta con el centro y el partido especificados
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     * @param resultados[] arreglo usado para almacenar todos los resultados del sistema
     * @param centro escogido por el usuario
     * @param partido escogido por el usuario
     * @return verdadero o falso dependiendo de si ya existe una trupleta con el centro y partido seleccionados
     */  
    private static Boolean existeResultado(List resultados, CentroVo centro, PartidoVo partido) {
    
        for (Object resultado:resultados) {

            if (((ResultadoVo) resultado).getIdCentro() == centro.getId() && ((ResultadoVo) resultado).getIdPartido() == partido.getId()) {
            
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
    private static int votosDisponibles(List resultados, CentroVo centro) {
    
        int votosDisponibles = centro.getElectores();
        for (Object resultado:resultados) {

            if (((ResultadoVo) resultado).getIdCentro() == centro.getId()) {
            
                votosDisponibles -= ((ResultadoVo) resultado).getVotos();
            
            }

        }
        
        return votosDisponibles;
    
    }
    
    /**
     * Metodo que introduce la nueva tripleta en el arreglo donde se almacenan
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     */   
    public static void insertaTripleta() {
    
        List centros = CentroDao.getCentros();
        List partidos = PartidoDao.getPartidos();
        List resultados = ResultadoDao.getResultados();
        
        CentroVo centro;
        PartidoVo partido;
        int votos;
        
        if (centros.isEmpty()) {
        
            System.out.println("------------------------------");
            System.out.println("Inscriba primero los centros para poder introducir resultados");
        
        } else if (partidos.isEmpty()) {
        
            System.out.println("------------------------------");
            System.out.println("Inscriba primero los partidos para poder introducir resultados");
        
        } else {
        
            centro = escogeCentro(centros);
            partido = escogePartido(partidos);
            if (existeResultado(resultados, centro, partido)) {
            
                System.out.print("Ya existe un resultado para ese centro y partido");
            
            } else {
            
                votos = introduceVotos(resultados, centro);
                ResultadoVo resultado = new ResultadoVo(centro.getId(), partido.getId(), votos);
                ResultadoDao.createResultado(resultado);
            
            }
        
        }
    
    }

}
