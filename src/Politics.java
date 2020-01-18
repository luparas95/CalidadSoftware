import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

import main.views.MenuCentro;
import main.views.MenuPartido;
import main.views.MenuResultado;

import main.models.dao.ResultadoDao;

import main.models.vo.ResultadoToPrintVo;

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

        muestraMenuPrincipal();
        
        do {
        
            try {

                opcion = entrada.nextInt();
                switch (opcion) {

                    case 1:

                        MenuCentro.muestraMenuCentro();
                        muestraMenuPrincipal();
                        break;

                    case 2:

                        MenuPartido.muestraMenuPartido();
                        muestraMenuPrincipal();
                        break;

                    case 3:

                        MenuResultado.insertaTripleta();
                        muestraMenuPrincipal();
                        break;

                    case 4:
                        
                        List resultados = ResultadoDao.getResultadosToPrint();
                        for (Object resultado:resultados) {

                            ((ResultadoToPrintVo) resultado).print();

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
