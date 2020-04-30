package main.exceptions;

/**
 * Esta clase contiene la excepción cuando se intenta introducir más votos de los que dispone un centro electoral
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class DuplicateRowException extends Exception {
    
    public DuplicateRowException() {
    
        super("Ya existe un registro de votos para ese centro y ese partido.");
    
    }
    
}
