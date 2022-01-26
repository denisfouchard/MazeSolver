package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import maze.ErrorMessageWindow;

public class SaveMenuItem extends JMenuItem{
	/**
	 * 
	 */
	private File selectedDir;
	
	private static final long serialVersionUID = 1L;

	public SaveMenuItem(DrawingApp drawingApp) {
		super("Save as...");
		
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser directoryChooser = new JFileChooser();
				
				directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				
				directoryChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = directoryChooser.showSaveDialog(new JPanel());
				if (result == JFileChooser.APPROVE_OPTION) {
				    selectedDir = directoryChooser.getSelectedFile();
				    System.out.println("Selected dir: " + selectedDir.getAbsolutePath());
				}
				
				try {
					drawingApp.saveMazeToTextFile(selectedDir.getAbsolutePath());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					new ErrorMessageWindow(null, -1);
				}
				
			}
			
		});
		
		
	}
}

