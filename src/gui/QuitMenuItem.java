package gui;

import javax.swing.JMenuItem;

public class QuitMenuItem extends JMenuItem{
	private final DrawingApp drawingApp;
	
	public QuitMenuItem(DrawingApp drawingApp) {
		super("Quit");
		this.drawingApp = drawingApp;
		
	}
}
