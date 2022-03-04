package dijkstra;

import java.util.Hashtable;

public class Previous implements PreviousInterface {
	
	private  Hashtable<VertexInterface, VertexInterface> P = new Hashtable<VertexInterface, VertexInterface>();

	/**
	 * Initialize a previous Hashtable with every vertex being its own previous.
	 * @param g the graph
	 */
	public Previous(GraphInterface g) {
		for (VertexInterface u: g.getAllVertices()) {
			P.put(u, u);
		}
	}

	/**
	 * Returns the previous vertex associated to a given vertex.
	 * @param u
	 * @return the previous vertex associated to the vertex u
	 */
	@Override
	public VertexInterface getPrevious(VertexInterface u) {
		return P.get(u);
	}

	/**
	 * Sets a vertex as the previous of a given vertex
	 * @param u the vertex to associate a previous vertex to
	 * @param v the vertex to be set to previous of vertex u
	 */
	@Override
	public void setPrevious(VertexInterface u, VertexInterface v) {
		P.put(u, v);
		
	}
	
	@Override
	public String toString() {
		return P.toString();
	}
	
}
