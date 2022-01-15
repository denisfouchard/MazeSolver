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
	private MBox[] boxes;
	private int size;
	private String fileName = null;
	private int rows;
	private int cols;
	
	public Maze() {
		
	}
	
	public Maze(int i, int j) {
		maze = new MBox[i][j];
		rows = i;
		cols  = j;
		
	}
	
	public Maze(int i, int j, MBox[] list_boxes) {
		
		//Pas utile, à supprimer
		
		maze = new MBox[i][j];
		rows = i;
		cols  = j;
		for (MBox box : boxes) {
			maze[box.getX()][box.getY()] = box;
		}
	}
	
	
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
	
	public final void printFromTextFile(String fileName) throws IOException {
		try (BufferedReader m = new BufferedReader(new FileReader(fileName))) {
			String strCurrentLine;
			while ((strCurrentLine = m.readLine()) != null) {
			    System.out.println(strCurrentLine);
			}
		}
		
	}
	
	public final void initFromTextFile(String fileName) throws MazeReadingException, IOException {
		
		BufferedReader buff = new BufferedReader(new FileReader(fileName));
		ArrayList<String> fileLines = new ArrayList<>();
		String strCurrentLine;
		this.fileName = fileName;
		
		
		while ((strCurrentLine = buff.readLine()) != null) {
			fileLines.add(strCurrentLine);
		}
		
		int n = fileLines.size();	
		int m = fileLines.get(0).length();
		
		rows = n;
		cols  = m;
		
		size = n*m;
		
		maze = new MBox[n][m];
		char Box;
		String currentLine;
		
		for (int i = 0; i < n; i+=1) {
			try {
				currentLine = fileLines.get(i);
				
				if (currentLine.length() != m) {
					throw new MazeReadingException(fileName, i, "NotAMaze");
					} 
				
				for (int j = 0; j < m; j+=1) {
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
				e.printStackTrace();
			}
		}
		buff.close();
	}
	
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

	public void setDeparture(DBox departure) {
		this.departure = departure;
	}

	public ABox getArrival() {
		return arrival;
	}

	public void setArrival(ABox arrival) {
		this.arrival = arrival;
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

	@Override
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		//MBox v = (MBox)vertex;
		int n = maze.length;
		int m = maze[0].length;
		int x = vertex.getX();
		int y = vertex.getY();
		ArrayList<VertexInterface> successors = new ArrayList<>();
		
		
		if (x > 1) {
			if (maze[x-1][y].getType() != 'W') {
				successors.add(maze[x-1][y]);
			}
		}
		if (x < n-1) {
			if (maze[x+1][y].getType() != 'W') {
				successors.add(maze[x+1][y]);
			}
		}
		if (y > 1) {
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

	@Override
	public int size() {
		return size;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}
	
	public String getFileName() {
		return fileName;
	}

}
