package dijkstra;

import java.util.ArrayList;

public interface VertexInterface {
	public void addNeighbour();
	public boolean hasNeighbours();
	public ArrayList<VertexInterface> getNeighbours();
	
}
