package gui;

import javax.swing.JMenuBar;

public class DrawingMenuBar extends JMenuBar{
	
	private final FileMenu fileMenu;
	
	public DrawingMenuBar(DrawingApp drawingApp) {
		super();
		
		// Ajouter des menus
		
		add(fileMenu = new FileMenu(drawingApp));
	}
}
