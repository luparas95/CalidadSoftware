package main.resources.menus;

import java.util.Scanner;

import main.resources.objects.Partido;

import main.resources.utils.Utils;

/**
 * Esta clase contiene el menu de la clase Partido y la implementacion de sus metodos
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class MenuPartido {
    
    private static final Scanner ENTRADA = new Scanner(System.in);
    
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
    * @param partidos[] este parametro es un arreglo usado para almacenar todos los objetos Partido
    */
    private static void muestraPartidos(Partido partidos[]) {
    
        System.out.println("------------------------------");
        
        if (partidos.length == 0) {
        
            System.out.println("Aún no hay partidos");
        
        } else {
        
            for (Partido partido:partidos) {

                partido.print();

            }
            
        }
    
    }
    
    /**
    * Método que crea un nuevo objeto Partido y lo agrega al arreglo donde son almacenados
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param partidos[] este parametro es un arreglo usado para almacenar todos los objetos Partido
    * @return Partido[] arreglo usado para almacenar todos los objetos Partido
    */
    private static Partido[] creaPartido(Partido partidos[]) {
    
        System.out.println("------------------------------");
        System.out.print("Introduzca el nombre del partido: ");
        String nombre = ENTRADA.nextLine();
        
        System.out.print("Introduzca las siglas: ");
        String siglas = ENTRADA.nextLine();
        
        Partido partido = new Partido(nombre, siglas);
        
        return Utils.PartidoArrayPush(partido, partidos);
    
    }
    
    /**
    * Método que implementa las opciones del menu principal
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param partidos[] este parametro es un arreglo usado para almacenar todos los objetos Partido
    * @return Partido[] arreglo usado para almacenar todos los objetos Partido 
    */
    public static Partido[] muestraMenuPartido(Partido partidos[]) {
    
        Boolean noSalir = true;
        int opcion;
        Partido newPartidos[] = partidos;
        
        muestraMenuPrincipal();
        
        do {

            opcion = ENTRADA.nextInt();
            switch (opcion) {
            
                case 1:
                    
                    muestraPartidos(newPartidos);
                    muestraMenuPrincipal();
                    break;
            
                case 2:
                    
                    newPartidos = creaPartido(newPartidos);
                    muestraMenuPrincipal();
                    break;
            
                case 3:
                    
                    ENTRADA.close();
                    noSalir = false;
                    break;
                    
                default:
                    
                    System.out.print("Opción no válida, inténtelo de nuevo: ");
            
            }
            
        } while (noSalir);
        
        return newPartidos;
            
    }

}