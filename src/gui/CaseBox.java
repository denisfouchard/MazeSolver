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
	 * @author Denis Fouchard
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
		//Ne fait rien
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Ne fait rien
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if (app.getMode() == "setDeparture"){
			maze.setDeparture(x,y);
			setBackground(Color.BLUE);
			app.resetMode();
		} else if (app.getMode() == "setArrival"){
			maze.setArrival(x,y);
			setBackground(Color.RED);
			app.resetMode();
		} else {
			if (maze.maze[x][y].getType() == 'W'){
				maze.maze[x][y].setType('E');
				setBackground(Color.WHITE);

			} else if (maze.maze[x][y].getType() == 'E'){
				maze.maze[x][y].setType('W');
				setBackground(Color.BLACK);
			}

		}


		app.repaintGrid();

		if (app.getAutoComputeStatus() == 1) {
			app.computePath();
		}

		repaint();

		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
