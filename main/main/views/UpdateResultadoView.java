package main.views;

import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

import main.controllers.CentroController;
import main.controllers.PartidoController;
import main.controllers.ResultadoController;

import main.models.vo.ResultadoVo;

import main.views.validations.Validations;

public class UpdateResultadoView {
    
    public static void mostrar(String nombreCentro, String nombrePartido, int votos) {
        
        JFrame f = new JFrame("MODIFICAR RESULTADO");

        JLabel centroLbl = new JLabel("Centro");
        centroLbl.setBounds(50, 50, 280, 14);
        f.getContentPane().add(centroLbl);
        
        JTextField centroField = new JTextField();
        centroField.setBounds(50, 70, 280, 25);
        f.getContentPane().add(centroField);
        centroField.setColumns(10);
        centroField.setText(nombreCentro);
        centroField.setEditable(false);

        JLabel partidoLbl = new JLabel("Partido");
        partidoLbl.setBounds(50, 130, 280, 14);
        f.getContentPane().add(partidoLbl);
        
        JTextField partidoField = new JTextField();
        partidoField.setBounds(50, 150, 280, 25);
        f.getContentPane().add(partidoField);
        partidoField.setColumns(10);
        partidoField.setText(nombrePartido);
        partidoField.setEditable(false);
        
        JLabel votosLbl = new JLabel("Votos");
        votosLbl.setBounds(50, 210, 280, 14);
        f.getContentPane().add(votosLbl);

        JTextField votosField = new JTextField();
        votosField.setBounds(50, 230, 280, 25);
        f.getContentPane().add(votosField);
        votosField.setColumns(10);
        votosField.setText("" + votos);
        
        JButton bActualizarResultado = new JButton("Actualizar");
        JButton bVolver = new JButton("Volver");
        
        bActualizarResultado.setBounds(50, 310, 130, 30);
        bVolver.setBounds(200, 310, 130, 30);
        
        bActualizarResultado.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                if (!Validations.numeroValido(votosField.getText())) {
                
                    JOptionPane.showMessageDialog(f, "Introduzca una cifra de votos");
                
                } else {
                    
                    f.setVisible(false);
                    LoadingView.mostrar();
                    
                    try {

                        int idCentroSelected = Integer.parseInt(centroField.getText().substring(0, centroField.getText().indexOf(" - ")));
                        int idPartidoSelected = Integer.parseInt(partidoField.getText().substring(0, partidoField.getText().indexOf(" - ")));
                        ResultadoVo resultado = new ResultadoVo(idCentroSelected, idPartidoSelected, Integer.parseInt(votosField.getText()));
                        ResultadoController.updateResultado(resultado);
                        MenuPrincipalView.mostrar();
                        
                    } catch (Exception except) {
                    
                        JOptionPane.showMessageDialog(f, except.getMessage());
                        f.setVisible(true);
                    
                    } finally {
                    
                        LoadingView.ocultar();
                    
                    }
                
                }

            }

        });
        
        bVolver.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                MenuPrincipalView.mostrar();

            }

        });
        
        f.add(bActualizarResultado);
        f.add(bVolver);
        
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
  
    }

}