package main.views;

import java.awt.Dimension;
import java.awt.event.*;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.*;

import main.constants.Constant;
import main.controllers.ResultadoController;
import main.models.vo.SessionVo;

public class ResultadoListView {
    
    public static void mostrar() {
        
        LoadingView.mostrar();
        
        JFrame f = new JFrame("LISTADO RESULTADO");
        JButton bVolver = new JButton("Volver");
        
        bVolver.setBounds(50, 315, 275, 30);
        
        bVolver.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                MenuPrincipalView.mostrar();

            }

        });
        
        f.add(bVolver);
        
        final Vector<Vector> tableData = ResultadoController.getResultadosToPrint();
        final Vector cabeceras = new Vector(Arrays.asList(new String[] { "Centro", "Partido", "Votos" }));
        JTable table = new JTable(tableData, cabeceras) {
        
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {                
                    return false;               
            };
        
        };
        
        table.addMouseListener(new MouseAdapter() {
        
            public void mouseClicked(MouseEvent e) {
            
                if (e.getClickCount() == 2 && (SessionVo.getInstance().getUser().getRole() == Constant.ROLE_ADMINISTRADOR || SessionVo.getInstance().getUser().getRole() == Constant.ROLE_PRESIDENTE_MESA_ELECTORAL)) {
                
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    f.setVisible(false);
                    LoadingView.mostrar();
                    UpdateResultadoView.mostrar((String) tableData.get(row).get(0), (String) tableData.get(row).get(1), Integer.parseInt((String) tableData.get(row).get(2)));
                
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