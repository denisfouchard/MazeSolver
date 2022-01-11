package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
	 */
	private static final long serialVersionUID = 1L;
	private int rows;
	private int cols;
	private JButton[][] grid;
	
	
	public DrawingGrid(Maze maze) throws MazeReadingException {
		super();
		this.rows = maze.getRows();
		this.cols = maze.getCols();	
		this.grid = new JButton[cols][rows];
		setupGrid(maze);
		
		
	}
	
	public void setupGrid(Maze maze) throws MazeReadingException {
	
		// Couleurs du labyrinthe
		Color arrivalColor = Color.RED;
		Color departureColor = Color.BLUE;
		Color emptyColor = Color.WHITE;
		Color wallColor = Color.GRAY;
		
		
		// Dimensions du labyrinthe
		
	
		JButton caseButton = null;
		
		
		
		//Remplir la grille avec les données du Labyrinthe
		for (int i = 0; i < rows;  i++) {
			for (int j = 0; j < cols; j++) {
				try {
				switch(maze.maze[i][j].getType()) {
				
				case 'A':
					caseButton = new CaseButton(maze);
					caseButton.setBackground(arrivalColor);
					caseButton.setOpaque(true);
					//caseButton.setBorderPainted(false);
					caseButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					this.add(caseButton);
					grid[i][j] = caseButton;
					break;
					
				case 'D':
					caseButton = new CaseButton(maze);
					caseButton.setBackground(departureColor);
					caseButton.setOpaque(true);
					//caseButton.setBorderPainted(false);
					caseButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					this.add(caseButton);
					grid[i][j] = caseButton;
					break;
				
				case 'E':
					caseButton = new CaseButton(maze);
					caseButton.setBackground(emptyColor);
					caseButton.setOpaque(true);
					//caseButton.setBorderPainted(false);
					caseButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					this.add(caseButton);
					grid[i][j] = caseButton;
					break;
			
				case 'W':
					caseButton = new CaseButton(maze);
					caseButton.setBackground(wallColor);
					caseButton.setOpaque(true);
					//caseButton.setBorderPainted(false);
					caseButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
			
	this.setLayout(new GridLayout(rows, cols));
	//this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
}
}
	public void tracePath(Maze maze) {
		Color pathColor = Color.GREEN;
		
		GraphInterface g = (GraphInterface)maze;
		VertexInterface dep = (VertexInterface)maze.getDeparture();
		VertexInterface arr = (VertexInterface)maze.getArrival();
		
		//On exécute Dijkstra pour récuperer le chemin
		ASetInterface a = new ASet(g);
		Previous prev = new Previous(maze);
		Pi pi = new Pi(maze);
		prev = (Previous) Dijkstra.dijkstra(g, dep, a, pi, prev);
		
		VertexInterface v = prev.getPrevious(arr);
		while (v != dep) {
			int i = v.getX();
			int j = v.getY();
			JButton pathcase = grid[i][j];
			pathcase.setBackground(pathColor);
			v = prev.getPrevious(v);
			
		}

	}

}
