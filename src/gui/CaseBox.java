package gui;


import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;


import maze.Maze;

public class CaseBox extends Box implements MouseListener {
	
	private Maze maze;
	private int x;
	private int y;
	private DrawingApp app;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CaseBox(DrawingApp app, ImageLoader imLoader, Maze maze, int x, int y) {
		super(BoxLayout.X_AXIS);

		this.maze = maze;
		this.app = app;
		this.x = x;
		this.y = y;
		this.setBounds(x, y, 1, 1);
		setOpaque(true);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		addMouseListener(this);

		}

	@Override
	public void mouseClicked(MouseEvent e) {


	
	}

	@Override
	public void mousePressed(MouseEvent e) {

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//System.out.println("Current type " +maze.maze[x][y].getType() );
		switch (maze.maze[x][y].getType()) {
			case 'E':
				maze.maze[x][y].setType('W');
				break;
			case 'W':
				maze.maze[x][y].setType('E');
				break;
			default:

		}
		//System.out.println("Changed type " +maze.maze[x][y].getType() );


		if (app.getAutoComputeStatus() == 1) {
			app.computePath();
		}
		app.repaintGrid();

		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}