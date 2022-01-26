package gui;

import javax.swing.JButton;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class ComputeButton extends JButton{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ComputeButton(DrawingApp app) {
		super("Compute...");

		
		//setMnemonic(KeyEvent.VK_C);
		
		
		// Bouton de calcul du plus court chemin
		this.setBounds(50, 100, 95, 30);
		
		
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				app.tracePath();
				
			}
			
		});
		
		
	}

}
