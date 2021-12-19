package gui;

import javax.swing.JMenuItem;

public class OpenMenuItem extends JMenuItem{
	private final DrawingApp drawingApp;
	
	public OpenMenuItem(DrawingApp drawingApp) {
		super("Open...");
		this.drawingApp = drawingApp;
		
	}
}