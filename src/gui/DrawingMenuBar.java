package gui;



import javax.swing.JMenuBar;



public class DrawingMenuBar extends JMenuBar{
	private static final long serialVersionUID = 1L;

	/**
	 * Ajoute les menus à la barre de menus
	 * @param drawingApp l'interface de l'application
	 */
	public DrawingMenuBar(DrawingApp drawingApp)  {
		super();
		// Ajouter des menus
		add(new FileMenu(drawingApp));
	}
}
