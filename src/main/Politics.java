package main;

import java.util.Scanner;
import java.util.InputMismatchException;

import main.resources.objects.Centro;
import main.resources.objects.Partido;
import main.resources.objects.Resultado;

import main.resources.menus.MenuCentro;
import main.resources.menus.MenuPartido;
import main.resources.menus.MenuResultado;

public class Politics {
    
    private static void muestraMenuPrincipal() {
    
        System.out.println("------------------------------");
        System.out.println("Bienvenido");
        System.out.println("1. Centros");
        System.out.println("2. Partidos");
        System.out.println("3. Resultados");
        System.out.println("4. Totalización");
        System.out.println("5. Salir");
        System.out.print("Introduzca la opción deseada: ");
    
    }
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        Boolean noSalir = true;
        int opcion;
        Centro centros[] = new Centro[0];
        Partido partidos[] = new Partido[0];
        Resultado resultados[] = new Resultado[0];

        muestraMenuPrincipal();
        
        do {
        
            try {

                opcion = entrada.nextInt();
                switch (opcion) {

                    case 1:

                        centros = MenuCentro.muestraMenuCentro(centros);
                        muestraMenuPrincipal();
                        break;

                    case 2:

                        partidos = MenuPartido.muestraMenuPartido(partidos);
                        muestraMenuPrincipal();
                        break;

                    case 3:

                        resultados = MenuResultado.insertaTripleta(centros, partidos, resultados);
                        muestraMenuPrincipal();
                        break;

                    case 4:

                        for (Resultado resultado:resultados) {

                            resultado.print();

                        }
                        muestraMenuPrincipal();
                        break;

                    case 5:

                        noSalir = false;
                        entrada.close();
                        System.out.println("Fin del programa, hasta la próxima!!!");
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
