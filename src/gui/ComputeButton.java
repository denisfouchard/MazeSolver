package gui;

import javax.swing.JButton;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import maze.Maze;

public class ComputeButton extends JButton{
	
	
	public ComputeButton(DrawingGrid grid, Maze maze) {
		super("Compute...");
		// Bouton de calcul du plus court chemin
		this.setBounds(50, 100, 95, 30);
		
		
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				grid.tracePath(maze);
				
			}
			
		});
		
		
	}

}
