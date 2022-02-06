package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

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
		
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser;
				fileChooser = new JFileChooser();
				
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int result = fileChooser.showOpenDialog(new JPanel());
				if (result == JFileChooser.APPROVE_OPTION) {
				    selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());

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
				
				//A partir du chemin du fichier récuperé, on génère un nouveau objet (Maze)newMaze
				

				
			}
			
			
			
			
				
				
		
			
			
			
		});
		
		
		
		
		
		
	}
}