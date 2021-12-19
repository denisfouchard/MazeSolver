package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import maze.Maze;

public class DrawingApp extends JFrame{
	
	
	public DrawingApp(Maze maze) {
		super("Maze solver");
		setupUI();
		setupGrid(maze);
		pack();
		setVisible(true);
	}
	
	public void setupUI() {
		final DrawingMenuBar drawingMenuBar;
		setPreferredSize(new Dimension(600, 600));
		setJMenuBar(drawingMenuBar = new DrawingMenuBar(this));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupButton();
	}
	
	public void setupButton() {
		final JButton compute = new JButton("Compute...");
		compute.setBounds(50, 100, 95, 30);
		this.add(compute);
	}
	
	public void setupGrid(Maze maze) {
//		final int caseSize = 30;
//		int rows = maze.getRows();
//		int cols = maze.getCols();
//		int width = cols * caseSize;
//		int height = rows * caseZise();
//		final DrawingGrid grid = new DrawingGrid(width, height, rows, cols);
		final DrawingGrid grid = new DrawingGrid(500,500,10,10);
		this.add(grid);
	}
}
