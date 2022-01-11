package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

public class QuitMenuItem extends JMenuItem{
	private final DrawingApp drawingApp;
	
	public QuitMenuItem(DrawingApp drawingApp) {
		super("Quit");
		this.drawingApp = drawingApp;
		
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
			
		});
		
	}
}
