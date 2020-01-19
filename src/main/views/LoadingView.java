package main.views;

import javax.swing.*;

public class LoadingView {
    
    private static JFrame frame;

    public static void mostrar() {

        frame = new JFrame("Procesando...");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);

    }
    
    public static void ocultar(){
    
        frame.setVisible(false);
    
    }
  
}