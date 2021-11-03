package maze;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Maze {
	public MBox[][] maze;
	private DBox departure;
	private ABox arrival;
	private MBox[] boxes;
	
	public Maze(int i, int j) {
		maze = new MBox[i][j];
	}
	
	public Maze(int i, int j, MBox[] list_boxes) {
		maze = new MBox[i][j];
		for (MBox box : boxes) {
			maze[box.getX()][box.getY()] = box;
		}
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
		ArrayList<String> lines = new ArrayList<>();
		String strCurrentLine;
		while ((strCurrentLine = buff.readLine()) != null) {
			lines.add(strCurrentLine);
		}
		int n = lines.size();	
		int m = lines.get(0).length();
		maze = new MBox[n][m];
		char Box;
		String currentLine;
		
		for (int i = 0; i < n; i+=1) {
			try {
				currentLine = lines.get(i);
				
				if (currentLine.length() != m) {
					throw new MazeReadingException(fileName, i, "NotAMaze");
					} 
				
				for (int j = 0; j < m; j+=1) {
					Box = currentLine.charAt(j);
					boolean noMatch = true;
					if (Character.compare(Box, 'A') ==0) {	
						arrival = new ABox(i, j);
						maze[i][j] = arrival;
						noMatch = false;
					}
					if (Character.compare(Box, 'D') ==0) {
						departure = new DBox(i,j);
						maze[i][j] = departure;
						noMatch = false;
					}
					if (Character.compare(Box, 'E') ==0) {
						maze[i][j] = new EBox(i, j);
						noMatch = false;
					}
					if (Character.compare(Box, 'W') ==0) {
						maze[i][j] = new WBox(i, j);
						noMatch = false;
					} 
					if (noMatch) {
						throw new MazeReadingException(fileName, i, "NotATile");
					}
				}

			} catch (MazeReadingException e) {
				e.getMessage();
			}
		}
	}
	
	public final void saveToTextFile(String fileName) throws FileNotFoundException {
		PrintWriter file = new PrintWriter(new File(fileName));
		int n = maze.length;
		int m = maze[0].length;
		for (int i = 0; i < n; i++) {
			String row = "";
			for (int j = 0; j < m; j++) {
				row = row + maze[i][j].type;
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
	
	
}