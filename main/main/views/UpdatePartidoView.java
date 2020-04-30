package main.views;

import java.awt.event.*;
import javax.swing.*;

import main.controllers.PartidoController;

import main.models.vo.PartidoVo;

import main.views.validations.Validations;

public class UpdatePartidoView {
    
    public static void mostrar(int idPartido) {
        
        PartidoVo partido = PartidoController.getPartidoById(idPartido);
        LoadingView.ocultar();
        
        JFrame f = new JFrame("Modificar Partido");

        JLabel nombreLbl = new JLabel("Nombre");
        nombreLbl.setBounds(50, 50, 280, 14);
        f.getContentPane().add(nombreLbl);

        JTextField nombreField = new JTextField();
        nombreField.setBounds(50, 70, 280, 25);
        f.getContentPane().add(nombreField);
        nombreField.setColumns(10);
        nombreField.setText(partido.getNombre());
         
        JLabel siglasLbl = new JLabel("Siglas");
        siglasLbl.setBounds(50, 150, 280, 14);
        f.getContentPane().add(siglasLbl);

        JTextField siglasField = new JTextField();
        siglasField.setBounds(50, 170, 280, 25);
        f.getContentPane().add(siglasField);
        siglasField.setColumns(10);
        siglasField.setText(partido.getSiglas());
        
        JButton bCrearPartidos = new JButton("Actualizar");
        JButton bVolver = new JButton("Volver");
        
        bCrearPartidos.setBounds(50, 310, 130, 30);
        bVolver.setBounds(200, 310, 130, 30);
        
        bCrearPartidos.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                if (!Validations.cadenaValida(nombreField.getText())) {
                
                    JOptionPane.showMessageDialog(f, "Introduzca un nombre");
                
                } else if (!Validations.cadenaValida(siglasField.getText())) {
                
                    JOptionPane.showMessageDialog(f, "Introduzca unas siglas");
                
                } else {
                
                    f.setVisible(false);
                    LoadingView.mostrar();
                    partido.setNombre(nombreField.getText());
                    partido.setSiglas(siglasField.getText());
                    PartidoController.updatePartido(partido);
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
