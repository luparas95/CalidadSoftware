package main.views;

import java.awt.event.*;
import javax.swing.*;

public class MenuCentroView {
    
    public static void mostrar() {
        
        JFrame f = new JFrame("Menú Centro");
        JButton bVerCentros = new JButton("Ver Centros");
        JButton bCrearCentros = new JButton("Crear Centro");
        JButton bVolver = new JButton("Volver");
        
        bVerCentros.setBounds(50, 75, 275, 30);
        bCrearCentros.setBounds(50, 150, 275, 30);
        bVolver.setBounds(50, 225, 275, 30);
        
        bVerCentros.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                CentroListView.mostrar();

            }

        });
        
        bCrearCentros.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                NewCentroView.mostrar();

            }

        });
        
        bVolver.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                MenuPrincipalView.mostrar();

            }

        });
        
        f.add(bVerCentros);
        f.add(bCrearCentros);
        f.add(bVolver);

        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
  
    }

}