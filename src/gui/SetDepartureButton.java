package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetDepartureButton extends JButton {


    public SetDepartureButton(DrawingApp app) {
        super("Set Departure");
        // Bouton de calcul du plus court chemin
        this.setBounds(50, 100, 95, 30);
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                app.setMode("setDeparture");
                app.repaint();


            }

        });


    }
}
