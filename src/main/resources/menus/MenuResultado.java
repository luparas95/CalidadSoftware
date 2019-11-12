package main.resources.menus;

import java.util.Scanner;

import main.resources.objects.Centro;
import main.resources.objects.Partido;
import main.resources.objects.Resultado;

import main.resources.utils.Utils;

public class MenuResultado {
    
    private static final Scanner ENTRADA = new Scanner(System.in);
    
    private static Centro escogeCentro(Centro[] centros) {
    
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
                
                int opcion = ENTRADA.nextInt();
                
                if (opcion < 1 || opcion > centros.length) {
                
                    System.out.print("Opción incorrecta, vuelva a introducirla: ");
                
                } else {
                    
                    centroEscogido = centros[opcion - 1];
                    opcionNoValida = false;
                    
                }
            
            } catch (NumberFormatException nfe) {
            
                System.out.print("Opción incorrecta, vuelva a introducirla: ");
            
            }
        
        } while (opcionNoValida);
        
        return centroEscogido;
    
    }
    
    private static Partido escogePartido(Partido[] partidos) {
    
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
                
                int opcion = ENTRADA.nextInt();
                
                if (opcion < 1 || opcion > partidos.length) {
                
                    System.out.print("Opción incorrecta, vuelva a introducirla: ");
                
                } else {
                    
                    partidoEscogido = partidos[opcion - 1];
                    opcionNoValida = false;
                    
                }
            
            } catch (NumberFormatException nfe) {
            
                System.out.print("Opción incorrecta, vuelva a introducirla: ");
            
            }
        
        } while (opcionNoValida);
        
        return partidoEscogido;
    
    }
        
    private static int introduceVotos(Resultado[] resultados, Centro centro) {
    
        int votos = 0;
        Boolean opcionNoValida = true;
        
        System.out.println("------------------------------");

        System.out.print("Introduce número de votos: ");
        
        do {
        
            try {
                
                int opcion = ENTRADA.nextInt();
                int votosDisponibles = votosDisponibles(resultados, centro);
                if (opcion < 0 || opcion > votosDisponibles) {
                
                    System.out.print("Número incorrecto, hay " + votosDisponibles + " votos disponibles: ");
                
                } else {
                    
                    votos = opcion;
                    opcionNoValida = false;
                    
                }
            
            } catch (NumberFormatException nfe) {
            
                System.out.print("Número incorrecto, vuelva a introducirlo: ");
            
            }
        
        } while (opcionNoValida);
        
        return votos;
    
    }
    
    private static Boolean existeResultado(Resultado[] resultados, Centro centro, Partido partido) {
    
        for (Resultado resultado:resultados) {

            if (resultado.getCentro() == centro && resultado.getPartido() == partido) {
            
                return true;
            
            }

        }
        
        return false;
    
    }
        
    private static int votosDisponibles(Resultado[] resultados, Centro centro) {
    
        int votosDisponibles = centro.getElectores();
        for (Resultado resultado:resultados) {

            if (resultado.getCentro() == centro) {
            
                votosDisponibles -= resultado.getVotos();
            
            }

        }
        
        return votosDisponibles;
    
    }
        
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
        
        ENTRADA.close();
        return newResultados;
    
    }

}