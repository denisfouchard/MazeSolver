package gui;


import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

		switch (maze.maze[x][y].getType()) {

			case 'E':
				maze.maze[x][y].setType('W');
				setBackground(Color.WHITE);
				break;

			case 'W':
				maze.maze[x][y].setType('E');
				setBackground(Color.BLACK);
				break;
			default:

		}

		if (app.getAutoComputeStatus() == 1) {
			app.tracePath();
		}
	
	}

	@Override
	public void mousePressed(MouseEvent e) {

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
