import gui.*;
import maze.Maze;

public class Main {
	
	/**
	 * Description
	 *
	 * @author Denis Fouchard
	 * 
	 */

	public static void main(String[] args) {
		
		Maze initialMaze = new Maze(10, 10);
		initialMaze.initEmptyMaze();
		
		new DrawingApp(initialMaze);
		

	}

}
