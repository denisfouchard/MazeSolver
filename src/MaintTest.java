

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

	public static void main(String[] args) throws IOException, MazeReadingException {
		Maze m = new Maze();
		m.initFromTextFile("data/labyrinthe.txt");
		GraphInterface g = (GraphInterface)m;
		VertexInterface dep = (VertexInterface)m.getDeparture();
		VertexInterface arr = (VertexInterface)m.getArrival();
		// System.out.println(Arrays.deepToString(m.maze));
		//m.saveToTextFile("data/labyrinthe2.txt");
		ASetInterface a = new ASet(g);
		Previous prev = new Previous(m);
		Pi pi = new Pi(m);
		prev = (Previous) Dijkstra.dijkstra(g, dep, a, pi, prev);
		
		//System.out.println(pi.toString());
		
		//System.out.println(prev.toString());
		
//		String res = "";
//		
//		VertexInterface r = arr;
//		while (r.getType() != 'D') {
//			System.out.println(r.toString());
//			res = res + r.toString();
//			r = prev.getPrevious(r);
//			
//		}
//		
//		System.out.print(res);
		
		
		new DrawingApp(m);
		
		
		
		
	}

}