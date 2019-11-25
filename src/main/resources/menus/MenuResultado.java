package main.resources.menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.resources.objects.Centro;
import main.resources.objects.Partido;
import main.resources.objects.Resultado;

import main.resources.utils.Utils;

/**
 * Esta clase contiene el menu de la clase Resultado y la implementacion de sus metodos
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class MenuResultado {
    
    /**
     * Metodo que imprime por pantalla todos los centros almacenados con un número asociado y devuelve el centro elegido
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     * @param centros[] este parametro es el arreglo usado para almacenar todos los centros del sistema
     * @return Centro es el centro elegido por el usuario de entre todos los almacenados
     */
    private static Centro escogeCentro(Centro[] centros) {
    
        Scanner entrada = new Scanner(System.in);
        Centro centroEscogido = null;
        Boolean opcionNoValida = true;
        
        System.out.println("------------------------------");

        int i = 0;
        for (Centro centro:centros) {

            i++;
            System.out.println("" + i + ". " + centro.getNombre());

        }

        System.out.print("Escoge centro: ");
        
        do {
        
            try {
                
                int opcion = entrada.nextInt();
                
                if (opcion < 1 || opcion > centros.length) {
                
                    System.out.print("Opción incorrecta, vuelva a introducirla: ");
                
                } else {
                    
                    centroEscogido = centros[opcion - 1];
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
    private static Partido escogePartido(Partido[] partidos) {
    
        Scanner entrada = new Scanner(System.in);
        Partido partidoEscogido = null;
        Boolean opcionNoValida = true;
        
        System.out.println("------------------------------");

        int i = 0;
        for (Partido partido:partidos) {

            i++;
            System.out.println("" + i + ". " + partido.getNombre());

        }

        System.out.print("Escoge partido: ");
        
        do {
        
            try {
                
                int opcion = entrada.nextInt();
                
                if (opcion < 1 || opcion > partidos.length) {
                
                    System.out.print("Opción incorrecta, vuelva a introducirla: ");
                
                } else {
                    
                    partidoEscogido = partidos[opcion - 1];
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
    private static int introduceVotos(Resultado[] resultados, Centro centro) {
    
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
    private static Boolean existeResultado(Resultado[] resultados, Centro centro, Partido partido) {
    
        for (Resultado resultado:resultados) {

            if (resultado.getCentro() == centro && resultado.getPartido() == partido) {
            
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
    private static int votosDisponibles(Resultado[] resultados, Centro centro) {
    
        int votosDisponibles = centro.getElectores();
        for (Resultado resultado:resultados) {

            if (resultado.getCentro() == centro) {
            
                votosDisponibles -= resultado.getVotos();
            
            }

        }
        
        return votosDisponibles;
    
    }
    
    /**
     * Metodo que introduce la nueva tripleta en el arreglo donde se almacenan
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     * @param centros[] este parametro es el arreglo usado para almacenar todos los centos del sistema
     * @param partidos[] este parametro es el arreglo usado para almacenar todos los partidos del sistema
     * @param resultados[] este parametro es el arreglo usado para almacenar todos los resultados del sistema
     * @return Resultado[] arreglo usado para almacenar todos los resultados del sistema
     */   
    public static Resultado[] insertaTripleta(Centro[] centros, Partido[] partidos, Resultado[] resultados) {
    
        Resultado newResultados[] = resultados;
        Centro centro;
        Partido partido;
        int votos;
        
        if (centros.length == 0) {
        
            System.out.println("------------------------------");
            System.out.println("Inscriba primero los centros para poder introducir resultados");
        
        } else if (partidos.length == 0) {
        
            System.out.println("------------------------------");
            System.out.println("Inscriba primero los partidos para poder introducir resultados");
        
        } else {
        
            centro = escogeCentro(centros);
            partido = escogePartido(partidos);
            if (existeResultado(resultados, centro, partido)) {
            
                System.out.print("Ya existe un resultado para ese centro y partido");
            
            } else {
            
                votos = introduceVotos(resultados, centro);
                Resultado resultado = new Resultado(centro, partido, votos);
                newResultados = Utils.ResultadoArrayPush(resultado, resultados);
            
            }
        
        }
        
        return newResultados;
    
    }

}
