package main.views;

import java.awt.Dimension;
import java.awt.event.*;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.*;

import main.controllers.CentroController;

public class CentroListView {
    
    public static void mostrar() {
        
        LoadingView.mostrar();
        
        JFrame f = new JFrame("Listado Centros");
        JButton bVolver = new JButton("Volver");
        
        bVolver.setBounds(50, 315, 275, 30);
        
        bVolver.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                MenuCentroView.mostrar();

            }

        });
        
        f.add(bVolver);
        
        final Vector<Vector> tableData = CentroController.getCentros();
        final Vector cabeceras = new Vector(Arrays.asList(new String[] { "Id", "Nombre", "Electores" }));
        JTable table = new JTable(tableData, cabeceras) {
        
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {                
                    return false;               
            };
        
        };
        
        table.addMouseListener(new MouseAdapter() {
        
            public void mouseClicked(MouseEvent e) {
            
                if (e.getClickCount() == 2) {
                
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    f.setVisible(false);
                    LoadingView.mostrar();
                    UpdateCentroView.mostrar(Integer.parseInt((String) tableData.get(row).get(0)));
                
                }
            
            }
        
        });
        
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