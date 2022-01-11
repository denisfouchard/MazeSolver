package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JMenuItem;

import maze.Maze;
import maze.MazeReadingException;


public class NewMenuItem extends JMenuItem{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public NewMenuItem(DrawingApp drawingApp) {
		super("New (to be implemented)");
	
		
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				NewMazeSelection newMazeSelection = new NewMazeSelection();
				
				int dim = newMazeSelection.getDim();
				
				Maze newMaze = new Maze(dim, dim);
				
				try {
					drawingApp.updateUI(newMaze);
				} catch (MazeReadingException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		
		
		});
	}
}
