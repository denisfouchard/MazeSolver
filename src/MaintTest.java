

import java.io.IOException;
import dijkstra.ASet;
import dijkstra.ASetInterface;
import dijkstra.Pi;
import dijkstra.Previous;
import dijkstra.VertexInterface;
import gui.DrawingApp;
import dijkstra.Dijkstra;
import dijkstra.GraphInterface;
import maze.Maze;
import maze.MazeReadingException;

public class MaintTest {
	/**
	 * Fonction de test des méthodes
	 * @param args
	 * @throws IOException
	 * @throws MazeReadingException
	 */
	public static void main(String[] args) throws IOException, MazeReadingException {
		Maze m = new Maze();
		//m.initFromTextFile("data/labyrinthe.txt");
		
		
		m.initFromTextFile("/Users/df/Desktop/labyrinthe2.txt");
		
		GraphInterface g = (GraphInterface)m;
		VertexInterface dep = (VertexInterface)m.getDeparture();
		VertexInterface arr = (VertexInterface)m.getArrival();
		// System.out.println(Arrays.deepToString(m.maze));
		//m.saveToTextFile("data/labyrinthe2.txt");
		ASetInterface a = new ASet(g);
		Previous prev = new Previous(m);
		Pi pi = new Pi(m);
		prev = (Previous) Dijkstra.dijkstra(g, dep, a, pi, prev);


		new DrawingApp(m);

		
		
		
		
	}

}