package gui;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import maze.Maze;

public class CaseButton extends JButton {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CaseButton(DrawingApp app, ImageLoader imLoader, Maze maze, int x, int y) {
		super();

		setOpaque(true);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		

		
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (maze.maze[x][y].getType()) {
					
				case 'E':
					maze.maze[x][y].setType('W');
					setIcon(imLoader.getIcon("cobblestone"));
					break;
					
				case 'W':
					maze.maze[x][y].setType('E');
					setIcon(imLoader.getIcon("grass"));
					break;
				default: 
					
				
				
					
				
				
				}
				app.refreshGrid();
				
				
				if (app.getAutoComputeStatus() == 1) {
					app.tracePath();
				}
				
				
				
				
			}
			
		});
		
		
	}
}
