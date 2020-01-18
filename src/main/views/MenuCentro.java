package main.views;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import main.models.vo.CentroVo;
import main.models.dao.CentroDao;

/**
 * Esta clase contiene el menu de la clase Centro y la implementacion de sus metodos
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class MenuCentro {
    
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
    */
    private static void muestraCentros() {

        List centros = CentroDao.getCentros();
            
        if (centros.isEmpty()) {
        
            System.out.println("Aún no hay centros");
        
        } else {
            
            for (Object centro:centros) {

                ((CentroVo) centro).print();

            }
            
        }
    
    }
    
    /**
    * Método que crea un nuevo objeto Centro y lo agrega al arreglo donde son almacenados
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    */
    private static void creaCentro() {
    
        Scanner entrada = new Scanner(System.in);
        System.out.println("------------------------------");
        System.out.print("Introduzca el nombre del centro: ");
        String nombre = entrada.nextLine();
        
        System.out.print("Introduzca el número de electores: ");
        Boolean nonInt = true;
        int electores = 0;
        do {
        
            try {
                
                electores = entrada.nextInt();
                if (electores < 1) {
                
                    System.out.print("El valor debe ser mayor que 0: ");
                
                } else {
                
                    nonInt = false;
                
                }
            
            } catch (InputMismatchException ime) {
            
                System.out.print("Número incorrecto, vuelva a introducirlo: ");
                entrada.next();
            
            }
        
        } while (nonInt);
        
        CentroVo centro = new CentroVo(0, nombre, electores);
        CentroDao.createCentro(centro);
    
    }

    /**
    * Método que implementa las opciones del menu principal
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    */
    public static void muestraMenuCentro() {
    
        Scanner entrada = new Scanner(System.in);
        Boolean noSalir = true;
        int opcion;
        
        muestraMenuPrincipal();
        
        do {

            try {
                
                opcion = entrada.nextInt();
                switch (opcion) {

                    case 1:

                        muestraCentros();
                        muestraMenuPrincipal();
                        break;

                    case 2:

                        creaCentro();
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
