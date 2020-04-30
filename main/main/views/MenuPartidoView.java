package main.views;

import java.awt.event.*;
import javax.swing.*;

import main.constants.Constant;
import main.models.vo.SessionVo;

public class MenuPartidoView {
    
    public static void mostrar() {
        
        JFrame f = new JFrame("MENU PARTIDO");
        JButton bVerPartidos = new JButton("Ver Partidos");
        JButton bCrearPartidos = new JButton("Crear Partido");
        JButton bVolver = new JButton("Volver");
        
        if (SessionVo.getInstance().getUser().getRole() != Constant.ROLE_ADMINISTRADOR && SessionVo.getInstance().getUser().getRole() != Constant.ROLE_DELEGADO_ELECTORAL) {
        
            bCrearPartidos.setEnabled(false);
        
        }
        
        bVerPartidos.setBounds(50, 75, 275, 30);
        bCrearPartidos.setBounds(50, 150, 275, 30);
        bVolver.setBounds(50, 225, 275, 30);
        
        bVerPartidos.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                PartidoListView.mostrar();

            }

        });
        
        bCrearPartidos.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                NewPartidoView.mostrar();

            }

        });
        
        bVolver.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                f.setVisible(false);
                MenuPrincipalView.mostrar();

            }

        });
        
        f.add(bVerPartidos);
        f.add(bCrearPartidos);
        f.add(bVolver);

        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
  
    }
    
}
