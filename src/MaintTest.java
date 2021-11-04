

import java.io.IOException;
import java.util.Arrays;

import maze.Maze;
import maze.MazeReadingException;

public class MaintTest {

	public static void main(String[] args) throws IOException, MazeReadingException {
		Maze m = new Maze(10, 10);
		m.initFromTextFile("data/labyrinthe.txt");
		// System.out.println(Arrays.deepToString(m.maze));
		m.saveToTextFile("data/labyrinthe2.txt");
		
	}

}