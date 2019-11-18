package main.resources.menus;

import java.util.Scanner;

import main.resources.objects.Centro;

import main.resources.utils.Utils;

/**
 * Esta clase contiene el menu de la clase Centro y la implementacion de sus metodos
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class MenuCentro {
    
    private static final Scanner ENTRADA = new Scanner(System.in);
    
    /**
     * Método que imprime en pantalla las opciones del menu principal de la clase Centros
     * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
     */
    private static void muestraMenuPrincipal() {
    
        System.out.println("------------------------------");
        System.out.println("1. Ver centros");
        System.out.println("2. Crear centro");
        System.out.println("3. Volver");
        System.out.print("Introduzca la opción deseada: ");
    
    }
    
    /**
    * Método que imprime por pantalla los atributos de todos los objetos Centro guardados
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param centros[] este parametro es un arreglo usado para almacenar todos los objetos Centro
    */
    private static void muestraCentros(Centro centros[]) {

        System.out.println("------------------------------");
        
        if (centros.length == 0) {
        
            System.out.println("Aún no hay centros");
        
        } else {
        
            for (Centro centro:centros) {

                centro.print();

            }
            
        }
    
    }
    
    /**
    * Método que crea un nuevo objeto centro y lo agrega al arreglo donde son almacenados
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param centros[] este parametro es un arreglo usado para almacenar todos los objetos Centro
    * @return Centro[] *por definir*
    */
    private static Centro[] creaCentro(Centro centros[]) {
    
        System.out.println("------------------------------");
        System.out.print("Introduzca el nombre del centro: ");
        String nombre = ENTRADA.nextLine();
        
        System.out.print("Introduzca el número de electores: ");
        Boolean nonInt = true;
        int electores = 0;
        do {
        
            String electoresString = ENTRADA.nextLine();
            try {
                
                electores = Integer.parseInt(electoresString);
                if (electores < 1) {
                
                    System.out.print("El valor debe ser mayor que 0: ");
                
                } else {
                
                    nonInt = false;
                
                }
            
            } catch (NumberFormatException nfe) {
            
                System.out.print("Número incorrecto, vuelva a introducirlo: ");
            
            }
        
        } while (nonInt);
        
        Centro centro = new Centro(nombre, electores);
        return Utils.CentroArrayPush(centro, centros);
    
    }

    /**
    * Método que ejecuta las opciones del menu principal
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param centros[] este parametro es un arreglo usado para almacenar todos los objetos Centro
    * @return Centro[] arreglo usado para almacenar todos los objetos Centro 
    */
    public static Centro[] muestraMenuCentro(Centro centros[]) {
    
        Boolean noSalir = true;
        int opcion;
        Centro newCentros[] = centros;
        
        muestraMenuPrincipal();
        
        do {

            opcion = ENTRADA.nextInt();
            switch (opcion) {
            
                case 1:
                    
                    muestraCentros(newCentros);
                    muestraMenuPrincipal();
                    break;
            
                case 2:
                    
                    newCentros = creaCentro(newCentros);
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
        
        return newCentros;
            
    }

}