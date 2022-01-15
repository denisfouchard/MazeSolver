package gui;

import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import maze.Maze;


public class DrawingApp extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;
	private JPanel buttonPanel;
	private DrawingGrid drawingGrid;
	
	public DrawingApp(Maze maze) {
		super("Maze solver");
		
		drawingGrid = new DrawingGrid(maze);
		
		setupUI(maze);
		
		
	}
	
	
	public void setupUI(Maze maze)  {
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.add(mainPanel);
		
		
		setPreferredSize(new Dimension(600, 650));
		setResizable(false);
		setJMenuBar(new DrawingMenuBar(this));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addGrid(maze);
		setupComputeButton(maze);
		pack();
		setVisible(true);
	}
	
	public void setupComputeButton(Maze maze) {
		
		
		ComputeButton compute = new ComputeButton(this);
		buttonPanel = new JPanel();
		buttonPanel.add(compute, BorderLayout.SOUTH);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		mainPanel.add(buttonPanel);
		
	}
	
	public void addGrid(Maze maze) {
		
		mainPanel.add(drawingGrid);
	}


	public void updateUI(Maze newMaze)  {
		
		
		this.remove(mainPanel);
		this.revalidate();
		
		drawingGrid = new DrawingGrid(newMaze);
		
		setupUI(newMaze);
		
		
	}


	public void computeButtonPressed() {
		drawingGrid.tracePath();
	}


	
	
	
	
	

	
}





