package main.resources.utils;

import main.resources.objects.Centro;
import main.resources.objects.Partido;
import main.resources.objects.Resultado;

public class Utils {

    public static Centro[] CentroArrayPush(Centro item, Centro[] oldArray) {
        
        int len = oldArray.length;
        Centro[] newArray = new Centro[len + 1];
        System.arraycopy(oldArray, 0, newArray, 0, len);
        newArray[len] = item;

        return newArray;

    }
    
    public static Partido[] PartidoArrayPush(Partido item, Partido[] oldArray) {
        
        int len = oldArray.length;
        Partido[] newArray = new Partido[len + 1];
        System.arraycopy(oldArray, 0, newArray, 0, len);
        newArray[len] = item;

        return newArray;

    }
    
    public static Resultado[] ResultadoArrayPush(Resultado item, Resultado[] oldArray) {
        
        int len = oldArray.length;
        Resultado[] newArray = new Resultado[len + 1];
        System.arraycopy(oldArray, 0, newArray, 0, len);
        newArray[len] = item;

        return newArray;

    }
        
}