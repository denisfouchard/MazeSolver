package gui;



import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.event.MenuKeyEvent;



public class FileMenu extends JMenu{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FileMenu(DrawingApp drawingApp) {
		super("File");
		 // Ajouter des items
		add(new NewMenuItem(drawingApp));
		add(new OpenMenuItem(drawingApp));
		add(new SaveMenuItem(drawingApp));
		add(new QuitMenuItem(drawingApp));

		//Ajout d'un raccourci clavier
		setMnemonic(MenuKeyEvent.VK_F);
	}
}
