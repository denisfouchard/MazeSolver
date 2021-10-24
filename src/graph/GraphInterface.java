package graph;

import java.util.ArrayList;

public interface GraphInterface {
	public ArrayList<VertexInterface> getNeighbours(VertexInterface u);
	public int size();
	public boolean isEdge(VertexInterface u, VertexInterface v);
	public void addEdge(VertexInterface u, VertexInterface v, float p);
	public float getWeight(VertexInterface u, VertexInterface v);
	public ArrayList<VertexInterface> getVertices();
}
