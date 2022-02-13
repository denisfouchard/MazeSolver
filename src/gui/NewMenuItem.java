package gui;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;

public class NewMenuItem extends JMenuItem{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewMenuItem(DrawingApp drawingApp) {
		super("New");
	
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new NewMazeSelection(drawingApp);
			}
		});
	}
}
