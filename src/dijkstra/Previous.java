package dijkstra;

import java.util.Hashtable;

public class Previous implements PreviousInterface {
	
	private  Hashtable<VertexInterface, VertexInterface> P = new Hashtable<VertexInterface, VertexInterface>();
	
	public Previous(GraphInterface g) {
		for (VertexInterface u: g.getAllVertices()) {
			P.put(u, u);
		}
	}

	@Override
	public VertexInterface getPrevious(VertexInterface u) {
		return P.get(u);
	}

	@Override
	public void setPrevious(VertexInterface u, VertexInterface v) {
		P.put(u, v);
		
	}
	
}
