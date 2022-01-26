package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JPanel;

import dijkstra.ASet;
import dijkstra.ASetInterface;
import dijkstra.Dijkstra;
import dijkstra.GraphInterface;
import dijkstra.Pi;
import dijkstra.Previous;
import dijkstra.VertexInterface;
import maze.Maze;
import maze.MazeReadingException;

public class DrawingGrid extends JPanel{
	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rows;
	private int cols;
	private Maze maze;
	private DrawingApp app;
	private JButton[][] grid;
	private ImageLoader imageLoader;
	
	public DrawingGrid(DrawingApp app, Maze maze) {
		super();
		this.rows = maze.getRows();
		this.cols = maze.getCols();	
		this.grid = new JButton[cols][rows];
		this.maze = maze;
		this.app = app;
		this.imageLoader = new ImageLoader(maze.getCols());
		setPreferredSize(new Dimension(600, 600));
		setupGrid();
		
		
	}
	
	public void setupGrid() {
	
		// Couleurs du labyrinthe
		

		
		
		// Dimensions du labyrinthe
		
		paintGrid();
		
		
		
		
		//Remplir la grille avec les données du Labyrinthe
		
		this.setLayout(new GridLayout(rows, cols));
}
	
	
	public void paintGrid() {
		
		JButton caseButton = null;
		Color arrivalColor = Color.RED;
		Color departureColor = Color.BLUE;
		
		for (int i = 0; i < rows;  i++) {
			for (int j = 0; j < cols; j++) {
				try {
				switch(maze.maze[i][j].getType()) {
				
				case 'A':
					caseButton = new CaseButton(this.app, imageLoader, maze, i, j);
					caseButton.setBackground(arrivalColor);
					this.add(caseButton);
					grid[i][j] = caseButton;
					break;
					
				case 'D':
					caseButton = new CaseButton(this.app, imageLoader, maze, i, j);
					caseButton.setBackground(departureColor);
			
				
					this.add(caseButton);
					grid[i][j] = caseButton;
					break;
				
				case 'E':
					
					caseButton = new CaseButton(this.app, imageLoader, maze, i, j);
					//caseButton.setBackground(emptyColor);
					caseButton.setIcon(this.imageLoader.getIcon("grass"));
					
					this.add(caseButton);
					grid[i][j] = caseButton;
					break;
			
				case 'W':
					caseButton = new CaseButton(this.app, imageLoader, maze, i, j);
					//caseButton.setBackground(wallColor);
					caseButton.setIcon(this.imageLoader.getIcon("cobblestone"));
					
					this.add(caseButton);
					grid[i][j] = caseButton;
					break;
				
				default:
					throw new MazeReadingException(maze.getFileName(), i, "NotAMaze");
				} 
				
			} catch (MazeReadingException e) {
				System.out.println(e.getMessage());
			}
			} 
			
	

		}
	}
	
public void repaintGrid() {
		
		JButton caseButton = null;
		Color arrivalColor = Color.RED;
		Color departureColor = Color.BLUE;
		
		for (int i = 0; i < rows;  i++) {
			for (int j = 0; j < cols; j++) {
				try {
				switch(maze.maze[i][j].getType()) {
				
				case 'A':
					caseButton = grid[i][j];
					caseButton.setBackground(arrivalColor);
					
					
					break;
					
				case 'D':
					caseButton = grid[i][j];
					caseButton.setBackground(departureColor);
			
					break;
				
				case 'E':
					
					caseButton = grid[i][j];
					caseButton.setIcon(this.imageLoader.getIcon("grass"));
				
					break;
			
				case 'W':
					caseButton = grid[i][j];
					//caseButton.setBackground(wallColor);
					caseButton.setIcon(this.imageLoader.getIcon("cobblestone"));
					
					break;
				
				default:
					throw new MazeReadingException(maze.getFileName(), i, "NotAMaze");
				} 
				
			} catch (MazeReadingException e) {
				System.out.println(e.getMessage());
			}
			} 
			
	

		}
	}
	
	
	
	
	public void tracePath() {

		
		
		
		GraphInterface g = (GraphInterface)maze;
		VertexInterface dep = (VertexInterface)maze.getDeparture();
		VertexInterface arr = (VertexInterface)maze.getArrival();
		
		//On exécute Dijkstra pour récuperer le chemin
		ASetInterface a = new ASet(g);
		Previous prev = new Previous(maze);
		Pi pi = new Pi(maze);
		prev = (Previous) Dijkstra.dijkstra(g, dep, a, pi, prev);
		
		ArrayList<JButton> pathButtons = new ArrayList<>();
		
		VertexInterface v = prev.getPrevious(arr);
		while (v != dep && prev.getPrevious(v) != v) {
			int i = v.getX();
			int j = v.getY();
			JButton pathCase = grid[i][j];
			
			pathButtons.add(pathCase);
			v = prev.getPrevious(v);
			
		}
		
		
		
		//On ne colorie les cases que si Dijkstra a réussi
		if (v == dep) {
			for (JButton pathCase : pathButtons) {
				pathCase.setIcon(this.imageLoader.getIcon("sand"));
				
			}
			
		}

	}

}
