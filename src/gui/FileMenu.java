package gui;

import java.io.IOException;

import javax.swing.JMenu;

import maze.MazeReadingException;

public class FileMenu extends JMenu{
	
	private final QuitMenuItem quitMenuItem;
	private final NewMenuItem newMenuItem;
	private final OpenMenuItem openMenuItem;
	private final SaveMenuItem saveMenuItem;
	
	public FileMenu(DrawingApp drawingApp) throws MazeReadingException, IOException {
		super("File");
		 // Ajouter des items
		
		
		add(newMenuItem = new NewMenuItem(drawingApp));
		add(openMenuItem = new OpenMenuItem(drawingApp));
		add(saveMenuItem = new SaveMenuItem(drawingApp));
		add(quitMenuItem = new QuitMenuItem(drawingApp));
		
	}
}
