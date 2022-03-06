package maze;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

public class Maze implements GraphInterface {
	public MBox[][] maze;
	private DBox departure;
	private ABox arrival;
	private String fileName = null;
	private int rows;
	private int cols;
	private int size;

	public Maze(){
	}

	public Maze(int i, int j) {
		maze = new MBox[i][j];
		rows = i;
		cols  = j;
	}


	/**
	 * Affiche le labyrhinthe dans la console.
	 */
	public void printMaze()  {
		for (int i = 0; i < rows; i++) {
			String row = new String();
			for (int j = 0; j < cols; j++) {
					row += maze[i][j].getType();
				}
			}
	}


	/**
	 * Crée un labyrinthe avec des cases vides et le départ à (0,0)
	 * et l'arrivée en bas à droite
	 */
	public void initEmptyMaze() {
		
		departure = new DBox(0, 0);
		arrival = new ABox(rows-1, cols-1);
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i+j !=0) {
					maze[i][j] = new EBox(i, j);
				}
			}
		}
		
		maze[0][0] = departure;
		maze[rows-1][cols-1] = arrival;
		
	}

	/**
	 * Lit un labyrinthe à partir d'une fichier et l'affiche dans la console.
	 * @param fileName le fichier labyrinthe
	 * @throws IOException
	 */
	public final void printFromTextFile(String fileName) throws IOException {
		try (BufferedReader m = new BufferedReader(new FileReader(fileName))) {
			String strCurrentLine;
			while ((strCurrentLine = m.readLine()) != null) {
			    System.out.println(strCurrentLine);
			}
		}
		
	}

	/**
	 * Crée un objet Maze à partir d'un fichier donné
	 * @param fileName le fichier labyrinthe
	 * @throws MazeReadingException
	 * @throws IOException
	 */
	public final boolean initFromTextFile(String fileName) throws MazeReadingException, IOException {
		
		BufferedReader buff = new BufferedReader(new FileReader(fileName));
		ArrayList<String> fileLines = new ArrayList<>();
		String strCurrentLine;
		this.fileName = fileName;
		
		
		while ((strCurrentLine = buff.readLine()) != null) {
			fileLines.add(strCurrentLine);
		}

		rows = fileLines.size();
		cols  = fileLines.get(0).length();

		
		maze = new MBox[rows][cols];

		char Box;
		String currentLine;
		
		for (int i = 0; i < rows; i+=1) {
			try {
				currentLine = fileLines.get(i);
				
				if (currentLine.length() != cols) {
					throw new MazeReadingException(fileName, i, "Invalid row length");
					} 
				
				for (int j = 0; j < cols; j+=1) {
					Box = currentLine.charAt(j);
					switch(Box) {
					case 'A':
						arrival = new ABox(i, j);
						maze[i][j] = arrival;
						break;
						
					case 'D':
						departure = new DBox(i,j);
    					maze[i][j] = departure;
						break;
						
					case 'E':
						maze[i][j] = new EBox(i, j);
						break;
						
					case 'W':
						maze[i][j] = new WBox(i, j);
						break;
						
					default :
						throw new MazeReadingException(fileName, i, "NotATile");
					}
				}

			} catch (MazeReadingException e) {
				// Affiche une fenêtre d'erreur avec le nom de la ligne
				e.errorWindow();
				return false;
			}
		}
		buff.close();
		try {
			if (arrival == null || departure == null){
				throw new MazeReadingException(fileName, -1, "Arrival or departure is missing.");
			}
		} catch (MazeReadingException missingException){
			missingException.errorWindow();
			return false;
		}
		return true;

	}

	/**
	 * Sauvegarde le labyrinthe courant dans une fichier texte
	 * @param fileName le fichier texte. Il peut être crée s'il n'exite pas déja
	 * @throws FileNotFoundException
	 */
	public final void saveToTextFile(String fileName) throws FileNotFoundException {
		PrintWriter file = new PrintWriter(new File(fileName));
		int n = maze.length;
		int m = maze[0].length;
		for (int i = 0; i < n; i++) {
			String row = "";
			for (int j = 0; j < m; j++) {
				row = row + maze[i][j].getType();
			}
			file.println(row);
		}
		file.close();
	}

	public DBox getDeparture() {
		return departure;
	}

	public void setDeparture(int x, int y) {
		DBox newDeparture = new DBox(x, y);
		this.maze[x][y] = newDeparture;
		int departureX = departure.getX();
		int departureY = departure.getY();
		this.maze[departureX][departureY] = new EBox(departureX, departureY);
		this.departure = newDeparture;
	}

	public ABox getArrival() {
		return arrival;
	}

	public void setArrival(int x, int y) {
		ABox newArrival = new ABox(x, y);
		this.maze[x][y] = newArrival;
		int arrivalX = arrival.getX();
		int arrivalY = arrival.getY();
		this.maze[arrivalX][arrivalY] = new EBox(arrivalX, arrivalY);
		this.arrival = newArrival;
	}


	@Override
	public int size() {
		return size;
	}

	@Override
	public ArrayList<VertexInterface> getAllVertices() {
		int n = maze.length;
		int m = maze[0].length;
		ArrayList<VertexInterface> allVertices = new ArrayList<>();
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j <m; j ++) {
				allVertices.add(maze[i][j]);
			}
		}
		return allVertices;
	}

	/**
	 * Renvoie la liste des sommets voisins du sommet donné
	 * @param vertex le sommet
	 * @return la liste des voisins
	 */
	@Override
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		//MBox v = (MBox)vertex;
		int n = maze.length;
		int m = maze[0].length;
		int x = vertex.getX();
		int y = vertex.getY();
		ArrayList<VertexInterface> successors = new ArrayList<>();
		
		
		if (x >= 1) {
			if (maze[x-1][y].getType() != 'W') {
				successors.add(maze[x-1][y]);
			}
		}
		if (x < n-1) {
			if (maze[x+1][y].getType() != 'W') {
				successors.add(maze[x+1][y]);
			}
		}
		if (y >= 1) {
			if (maze[x][y-1].getType() != 'W') {
				successors.add(maze[x][y-1]);
			}
		}
		if (y < m-1) {
			if (maze[x][y+1].getType() != 'W') {
				successors.add(maze[x][y+1]);
			}	
		}
		return successors;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

}
