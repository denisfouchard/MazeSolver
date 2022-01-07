package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import maze.Maze;
import maze.MazeReadingException;

public class DrawingApp extends JFrame{
	
	
	private JPanel mainPanel;
	private DrawingGrid drawingGrid;
	
	public DrawingApp(Maze maze) throws MazeReadingException {
		super("Maze solver");
		
		drawingGrid = new DrawingGrid(maze);
		
		setupUI();
		setupGrid(maze);
		setupButton(maze);
		pack();
		setVisible(true);
	}
	
	
	public void setupUI() {
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.add(mainPanel);
		
		final DrawingMenuBar drawingMenuBar;
		
		setPreferredSize(new Dimension(600, 650));
		setResizable(false);
		setJMenuBar(drawingMenuBar = new DrawingMenuBar(this));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setupButton(Maze maze) {
		JPanel buttonPanel;
		ComputeButton compute = new ComputeButton(drawingGrid, maze);
		buttonPanel = new JPanel();
		buttonPanel.add(compute, BorderLayout.SOUTH);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		mainPanel.add(buttonPanel);
		
		
	}
	
	public void setupGrid(Maze maze) throws MazeReadingException {
		
		mainPanel.add(drawingGrid);
	}
	

	
}