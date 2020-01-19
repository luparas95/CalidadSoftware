package main.views;

import java.awt.event.*;
import javax.swing.*;
import main.views.MenuCentroView;

public class MenuPrincipalView {
    
    public static void mostrar() {
        
        JFrame f = new JFrame("Menú Principal");
        JButton bCentros = new JButton("Menú Centros");
        JButton bPartidos = new JButton("Menú Partidos");
        JButton bResultados = new JButton("Introducir Resultados");
        JButton bTotalizacion = new JButton("Totalización");
        JButton bSalir = new JButton("Salir");
        
        bCentros.setBounds(50, 50, 275, 30);
        bPartidos.setBounds(50, 100, 275, 30);
        bResultados.setBounds(50, 150, 275, 30);
        bTotalizacion.setBounds(50, 200, 275, 30);
        bSalir.setBounds(50, 250, 275, 30);
        
        bCentros.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                MenuCentroView.mostrar();

            }

        });
        
        bPartidos.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                //TODO: Mostrar menú de partidos

            }

        });
        
        bResultados.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                //TODO: Mostrar inserción de resultados

            }

        });
        
        bTotalizacion.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                //TODO: Mostrar totalizacion

            }

        });
        
        bSalir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }

        });
        
        f.add(bCentros);
        f.add(bPartidos);
        f.add(bResultados);
        f.add(bTotalizacion);
        f.add(bSalir);

        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
  
    }

}