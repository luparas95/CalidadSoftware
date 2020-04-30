package main.views.validations;

public class Validations {
    
    public static boolean cadenaValida (String valor) {
    
        return !valor.isEmpty();
    
    }
    
    public static boolean numeroValido (String valor) {
    
        if (!valor.isEmpty()) {
        
            try {
                
                int valorEntero = Integer.parseInt(valor);
                return valorEntero >= 1;
            
            } catch (NumberFormatException nfe) {
            
                return false;
            
            }
        
        }
        
        return false;
    
    }
    
}
