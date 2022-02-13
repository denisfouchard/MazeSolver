package dijkstra;

import java.util.ArrayList;

public interface GraphInterface {
	public int size();
	public ArrayList<VertexInterface> getAllVertices();
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex);
}
