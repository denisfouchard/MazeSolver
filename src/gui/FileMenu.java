package gui;

import javax.swing.JMenu;

public class FileMenu extends JMenu{
	
	private final QuitMenuItem quitMenuItem;
	private final NewMenuItem newMenuItem;
	private final OpenMenuItem openMenuItem;
	
	public FileMenu(DrawingApp drawingApp) {
		super("File");
		 // Ajouter des items
		
		
		add(newMenuItem = new NewMenuItem(drawingApp));
		add(openMenuItem = new OpenMenuItem(drawingApp));
		add(quitMenuItem = new QuitMenuItem(drawingApp));
		
	}
}
