package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import maze.ErrorMessageWindow;
import maze.Maze;
import maze.MazeReadingException;

public class OpenMenuItem extends JMenuItem{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File selectedFile;
	
	public OpenMenuItem(DrawingApp drawingApp) {
		super("Open...");
		
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser;
				fileChooser = new JFileChooser();
				
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(new JPanel());
				if (result == JFileChooser.APPROVE_OPTION) {
				    selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
				
				//A partir du chemin du fichier récuperé, on génère un nouveau objet (Maze)newMaze
				
				Maze newMaze = new Maze();
				
		
				try {
					
					newMaze.initFromTextFile(selectedFile.getCanonicalPath());
					drawingApp.updateUI(newMaze);
			
				
				} catch (MazeReadingException e1) {
					
					e1.errorWindow();
					
				
				} catch (Exception exception) {
					//Dans le cas ou c'est une autre erreur, une fenêtre d'erreur générique s'ouvre
					new ErrorMessageWindow(null, -1);
				}
				
			}
			
			
			
			
				
				
		
			
			
			
		});
		
		
		
		
		
		
	}
}