package main.views;

import java.awt.event.*;
import javax.swing.*;

import main.controllers.PartidoController;

import main.views.validations.Validations;

public class NewPartidoView {
    
    public static void mostrar() {
        
        JFrame f = new JFrame("Nuevo Partido");

        JLabel nombreLbl = new JLabel("Nombre");
        nombreLbl.setBounds(50, 50, 280, 14);
        f.getContentPane().add(nombreLbl);

        JTextField nombreField = new JTextField();
        nombreField.setBounds(50, 70, 280, 25);
        f.getContentPane().add(nombreField);
        nombreField.setColumns(10);
         
        JLabel siglasLbl = new JLabel("Siglas");
        siglasLbl.setBounds(50, 150, 280, 14);
        f.getContentPane().add(siglasLbl);

        JTextField siglasField = new JTextField();
        siglasField.setBounds(50, 170, 280, 25);
        f.getContentPane().add(siglasField);
        siglasField.setColumns(10);
        
        JButton bCrearPartidos = new JButton("Crear Partido");
        JButton bVolver = new JButton("Volver");
        
        bCrearPartidos.setBounds(50, 310, 130, 30);
        bVolver.setBounds(200, 310, 130, 30);
        
        bCrearPartidos.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                if (!Validations.cadenaValida(nombreField.getText())) {
                
                    JOptionPane.showMessageDialog(f, "Introduzca un nombre válido");
                
                } else if (!Validations.cadenaValida(siglasField.getText())) {
                
                    JOptionPane.showMessageDialog(f, "Introduzca unas siglas válidas");
                
                } else {
                
                    f.setVisible(false);
                    LoadingView.mostrar();
                    PartidoController.creaPartido(nombreField.getText(), siglasField.getText());
                    LoadingView.ocultar();
                    MenuPartidoView.mostrar();
                
                }

            }

        });
        
        bVolver.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                MenuPartidoView.mostrar();

            }

        });
        
        f.add(bCrearPartidos);
        f.add(bVolver);
        
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
  
    }
}
