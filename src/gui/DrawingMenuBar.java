package gui;



import javax.swing.JMenuBar;



public class DrawingMenuBar extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrawingMenuBar(DrawingApp drawingApp)  {
		super();
		
		// Ajouter des menus
		
		add(new FileMenu(drawingApp));
	}
}
