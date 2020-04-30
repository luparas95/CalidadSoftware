package main.exceptions;

/**
 * Esta clase contiene la excepción cuando se intenta introducir más votos de los que dispone un centro electoral
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class VotesOutOfRangeException extends Exception {
    
    public VotesOutOfRangeException(int votosDisponibles) {
    
        super("Los votos introducidos superan el total disponible del centro. Dispone de " + votosDisponibles + " votos para este centro.");
    
    }
    
}
