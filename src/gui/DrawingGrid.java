package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
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
	private CaseBox[][] grid;
	private ImageLoader imageLoader;
	
	public DrawingGrid(DrawingApp app, Maze maze) {
		super();
		this.rows = maze.getRows();
		this.cols = maze.getCols();	
		this.grid = new CaseBox[cols][rows];
		this.maze = maze;
		this.app = app;
		this.imageLoader = new ImageLoader(maze.getCols());
		setPreferredSize(new Dimension(600, 600));
		setupGrid();
		
		
	}
	
	public void setupGrid() {
	
		// Couleurs du labyrinthe
		

		
		
		// Dimensions du labyrinthe
		
		

		//Remplir la grille avec les données du Labyrinthe
		
		this.setLayout(new GridLayout(rows, cols));
		paintGrid();
	
}
	
	
	public void paintGrid() {
		
		CaseBox caseBox = null;
		Color arrivalColor = Color.RED;
		Color departureColor = Color.BLUE;
		
		for (int i = 0; i < rows;  i++) {
			for (int j = 0; j < cols; j++) {
				try {
				switch(maze.maze[i][j].getType()) {
				
				case 'A':
					caseBox = new CaseBox(this.app, imageLoader, maze, i, j);
					caseBox.setBackground(arrivalColor);
					this.add(caseBox);
					grid[i][j] = caseBox;
					break;
					
				case 'D':
					caseBox = new CaseBox(this.app, imageLoader, maze, i, j);
					caseBox.setBackground(departureColor);
			
				
					this.add(caseBox);
					grid[i][j] = caseBox;
					break;
				
				case 'E':
					
					caseBox = new CaseBox(this.app, imageLoader, maze, i, j);
					//caseButton.setBackground(emptyColor);
					caseBox.setBackground(Color.WHITE);
					
					this.add(caseBox);
					grid[i][j] = caseBox;
					break;
			
				case 'W':
					caseBox = new CaseBox(this.app, imageLoader, maze, i, j);
					//caseButton.setBackground(wallColor);
					caseBox.setBackground(Color.BLACK);
					
					this.add(caseBox);
					grid[i][j] = caseBox;
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
		
		CaseBox caseBox = null;
		Color arrivalColor = Color.RED;
		Color departureColor = Color.BLUE;
		
		for (int i = 0; i < rows;  i++) {
			for (int j = 0; j < cols; j++) {
				try {
				switch(maze.maze[i][j].getType()) {
				
				case 'A':
					caseBox = grid[i][j];
					caseBox.setBackground(arrivalColor);
					
					
					break;
					
				case 'D':
					caseBox = grid[i][j];
					caseBox.setBackground(departureColor);
			
					break;
				
				case 'E':
					
					caseBox = grid[i][j];
					caseBox.setBackground(Color.WHITE);
				
					break;
			
				case 'W':
					caseBox = grid[i][j];
					//caseButton.setBackground(wallColor);
					caseBox.setBackground(Color.BLACK);
					
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
		
		ArrayList<CaseBox> pathCases = new ArrayList<>();
		
		VertexInterface v = prev.getPrevious(arr);
		while (v != dep && prev.getPrevious(v) != v) {
			int i = v.getX();
			int j = v.getY();
			CaseBox pathCase = grid[i][j];
			
			pathCases.add(pathCase);
			v = prev.getPrevious(v);
			
		}
		
		
		
		//On ne colorie les cases que si Dijkstra a réussi
		if (v == dep) {
			repaintGrid();
			for (CaseBox pathCase : pathCases) {
				pathCase.setBackground(Color.GREEN);
				
			}
			
		}

	}

}
