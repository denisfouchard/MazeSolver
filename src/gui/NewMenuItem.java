package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JMenuItem;



public class NewMenuItem extends JMenuItem{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public NewMenuItem(DrawingApp drawingApp) {
		super("New");
	
		
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new NewMazeSelection(drawingApp);
				
				
				
			
			}
		
		
		});
	}
}
