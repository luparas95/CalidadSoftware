package main.controllers;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import main.models.vo.PartidoVo;
import main.models.dao.PartidoDao;

/**
 * Esta clase contiene el menu de la clase Partido y la implementacion de sus metodos
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class PartidoController {
    
    /**
     * Método que imprime en pantalla las opciones del menu principal de la clase Partidos
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     */
    private static void muestraMenuPrincipal() {
    
        System.out.println("------------------------------");
        System.out.println("1. Ver partidos");
        System.out.println("2. Crear partido");
        System.out.println("3. Volver");
        System.out.print("Introduzca la opción deseada: ");
    
    }
    
    /**
    * Método que imprime por pantalla los atributos de todos los objetos Partido guardados
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    */
    private static void muestraPartidos() {
    
        List partidos = PartidoDao.getPartidos();
        
        if (partidos.isEmpty()) {
        
            System.out.println("Aún no hay partidos");
        
        } else {
        
            for (Object partido:partidos) {

                ((PartidoVo) partido).print();

            }
            
        }
    
    }
    
    /**
    * Método que crea un nuevo objeto Partido y lo agrega al arreglo donde son almacenados
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    */
    private static void creaPartido() {
    
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("------------------------------");
        System.out.print("Introduzca el nombre del partido: ");
        String nombre = entrada.nextLine();
        
        System.out.print("Introduzca las siglas: ");
        String siglas = entrada.nextLine();
        
        PartidoVo partido = new PartidoVo(0, nombre, siglas);
        PartidoDao.createCentro(partido);
    
    }
    
    /**
    * Método que implementa las opciones del menu principal
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    */
    public static void muestraMenuPartido() {
    
        Scanner entrada = new Scanner(System.in);
        Boolean noSalir = true;
        int opcion;
        
        muestraMenuPrincipal();
        
        do {

            try {
                
                opcion = entrada.nextInt();
                switch (opcion) {

                    case 1:

                        muestraPartidos();
                        muestraMenuPrincipal();
                        break;

                    case 2:

                        creaPartido();
                        muestraMenuPrincipal();
                        break;

                    case 3:

                        noSalir = false;
                        break;

                    default:

                        System.out.print("Opción no válida, inténtelo de nuevo: ");

                }   
                
            } catch (InputMismatchException ime) {
            
                System.out.print("Número no válido, inténtelo de nuevo: ");
                entrada.next();

            }
            
        } while (noSalir);
            
    }

}