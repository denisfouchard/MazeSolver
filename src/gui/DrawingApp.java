package gui;

import java.awt.Dimension;
import java.io.IOException;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import maze.Maze;
import maze.MazeReadingException;

public class DrawingApp extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;
	private JPanel buttonPanel;
	private DrawingGrid drawingGrid;
	
	public DrawingApp(Maze maze) throws MazeReadingException, IOException {
		super("Maze solver");
		
		drawingGrid = new DrawingGrid(maze);
		
		setupUI();
		addGrid(maze);
		setupComputeButton(maze);
		pack();
		setVisible(true);
	}
	
	
	public void setupUI() throws MazeReadingException, IOException {
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.add(mainPanel);
		
		
		setPreferredSize(new Dimension(600, 650));
		setResizable(false);
		setJMenuBar(new DrawingMenuBar(this));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setupComputeButton(Maze maze) {
		
		
		ComputeButton compute = new ComputeButton(drawingGrid, maze);
		buttonPanel = new JPanel();
		buttonPanel.add(compute, BorderLayout.SOUTH);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		mainPanel.add(buttonPanel);
		
		
	}
	
	public void addGrid(Maze maze) throws MazeReadingException {
		
		mainPanel.add(drawingGrid);
	}


	public void updateUI(Maze newMaze) throws MazeReadingException, IOException {
		mainPanel.remove(0);
		//buttonPanel.remove(0);
		setupComputeButton(newMaze);
		mainPanel.add(drawingGrid = new DrawingGrid(newMaze));
		
		mainPanel.updateUI();
		
	

	}
	
	
	
	
	

	
}





