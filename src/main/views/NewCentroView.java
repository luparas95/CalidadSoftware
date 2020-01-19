package main.views;

import java.awt.event.*;
import javax.swing.*;

import main.controllers.CentroController;

import main.views.validations.Validations;

public class NewCentroView {
    
    public static void mostrar() {
        
        JFrame f = new JFrame("Nuevo Centro");

        JLabel nombreLbl = new JLabel("Nombre");
        nombreLbl.setBounds(50, 50, 280, 14);
        f.getContentPane().add(nombreLbl);

        JTextField nombreField = new JTextField();
        nombreField.setBounds(50, 70, 280, 25);
        f.getContentPane().add(nombreField);
        nombreField.setColumns(10);
         
        JLabel electoresLbl = new JLabel("Electores");
        electoresLbl.setBounds(50, 150, 280, 14);
        f.getContentPane().add(electoresLbl);

        JTextField electoresField = new JTextField();
        electoresField.setBounds(50, 170, 280, 25);
        f.getContentPane().add(electoresField);
        electoresField.setColumns(10);
        
        JButton bCrearCentros = new JButton("Crear Centro");
        JButton bVolver = new JButton("Volver");
        
        bCrearCentros.setBounds(50, 310, 130, 30);
        bVolver.setBounds(200, 310, 130, 30);
        
        bCrearCentros.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                if (!Validations.cadenaValida(nombreField.getText())) {
                
                    JOptionPane.showMessageDialog(f, "Introduzca un nombre válido");
                
                } else if (!Validations.numeroValido(electoresField.getText())) {
                
                    JOptionPane.showMessageDialog(f, "Introduzca un número de electores válido");
                
                } else {
                
                    CentroController.creaCentro(nombreField.getText(), Integer.parseInt(electoresField.getText()));
                    f.setVisible(false);
                    CentroView.mostrar();
                
                }

            }

        });
        
        bVolver.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                CentroView.mostrar();

            }

        });
        
        f.add(bCrearCentros);
        f.add(bVolver);
        
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
  
    }

}