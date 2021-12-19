package gui;

import javax.swing.JMenuItem;

public class NewMenuItem extends JMenuItem{
	
private final DrawingApp drawingApp;
	
	public NewMenuItem(DrawingApp drawingApp) {
		super("New...");
		this.drawingApp = drawingApp;
	}
}
