package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetArrivalButton extends JButton {


    public SetArrivalButton(DrawingApp app) {
        super("Set Arrival");
        // Bouton de calcul du plus court chemin
        this.setBounds(50, 100, 95, 30);
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                app.setMode("setArrival");
                app.repaint();


            }

        });


    }
}
