package gui;

import java.io.IOException;

import javax.swing.JMenuBar;

import maze.MazeReadingException;

public class DrawingMenuBar extends JMenuBar{
	
	private final FileMenu fileMenu;
	
	public DrawingMenuBar(DrawingApp drawingApp) throws MazeReadingException, IOException {
		super();
		
		// Ajouter des menus
		
		add(fileMenu = new FileMenu(drawingApp));
	}
}
