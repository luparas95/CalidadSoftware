package main.views;

import java.awt.Dimension;
import java.awt.event.*;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.*;

import main.controllers.PartidoController;

public class PartidoListView {
    
    public static void mostrar() {
        
        LoadingView.mostrar();
        
        JFrame f = new JFrame("Listado Partidos");
        JButton bVolver = new JButton("Volver");
        
        bVolver.setBounds(50, 315, 275, 30);
        
        bVolver.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                MenuPartidoView.mostrar();

            }

        });
        
        f.add(bVolver);
        
        Vector cabeceras = new Vector(Arrays.asList(new String[] { "Id", "Nombre", "Siglas" }));
        JTable table = new JTable(PartidoController.getPartidos(), cabeceras) {
        
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {                
                    return false;               
            };
        
        };
        
        JScrollPane tablePanel = new JScrollPane(table);
        tablePanel.setPreferredSize(new Dimension(400, 300));
        f.add(tablePanel);
        f.pack();
         
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);

        LoadingView.ocultar();
  
    }
}
