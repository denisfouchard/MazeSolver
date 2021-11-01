package graph;


import java.io.IOException;

import maze.Maze;

public class MaintTest {

	public static void main(String[] args) throws IOException {
		Maze m = new Maze(10, 10);
		m.initFromTextFile("data/labyrinthe.txt");
		
	}

}
